package com.example.phoneShopping.cart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.phoneShopping.cart.dao.CartDao;
import com.example.phoneShopping.cart.domain.Cart;
import com.example.phoneShopping.cart.domain.CartProduct;
import com.example.phoneShopping.cart.dto.param.CartDetailDto;
import com.example.phoneShopping.cart.dto.param.CartOrderDto;
import com.example.phoneShopping.cart.dto.param.CartProductDto;
import com.example.phoneShopping.member.dao.MemberDao;
import com.example.phoneShopping.member.domain.Member;
import com.example.phoneShopping.payment.dto.param.PaymentDto;
import com.example.phoneShopping.payment.service.PaymentService;
import com.example.phoneShopping.product.domain.Product;
import com.example.phoneShopping.product.dao.ProductDao;

import lombok.RequiredArgsConstructor;



@Service
@Transactional
@RequiredArgsConstructor
public class CartService 
{
	private final ProductDao pdao;
	private final MemberDao mdao;
	private final CartDao cdao;
	private final PaymentService service;
	
	
	public String findMemberId(String mem_id)	// Member 찾기
	{
		Member member = mdao.findById(mem_id);
		return member.getMem_id();
	}
	
	public int findCartProductId(int cartp_seq)	// 장바구니에 담긴 상품 1개 출력
	{
		CartProduct cartProduct = cdao.findCartProductId(cartp_seq);
		return cartProduct.getCartp_seq();
	}
	
	
	public int addCart(CartProductDto cartProductDto, String mem_id)	// 장바구니에 상품 추가
	{
		Product product = pdao.findById(cartProductDto.getCartp_seq());	// 장바구니에 넣을 아이템 불러오기
		Member member = mdao.findById(mem_id);	// 장바구니 생성할 회원 불러오기
		
		// 장바구니 생성 - 이미 장바구니 생성한 사용자면 그 사람 꺼 불러오기, 없으면 새로 생성하기
		Cart cart = cdao.findByMemberId(member.getMem_id());	// 불러오기
		if(cart == null)	// 새로 생성
		{
			cart = Cart.createCart(member);
			cdao.createCart(cart);
		}
		
		// 장바구니에 상품 담기 - 있으면 갯수만 변경, 없으면 상품 추가
		CartProduct saveCartProd = cdao.findByCartIdAndProductId(cart.getCart_seq(), product.getProd_seq());
		if(saveCartProd != null)	// 선택한 상품이 장바구니에 있으면 갯수 변경
		{
			saveCartProd.addCount(cartProductDto.getCartp_cnt());
			return saveCartProd.getCartp_seq();
		}
		
		else	// 선택한 상품이 장바구니에 없으면 새로 추가
		{
			CartProduct cartProduct = CartProduct.createCartProduct(cart, product, cartProductDto.getCartp_cnt());
			cdao.createCartProduct(cartProduct);
			return cartProduct.getCartp_seq();
		}
	}
	
	
    @Transactional(readOnly = true)
    public List<CartDetailDto> getCartList(String mem_id)	// 장바구니에 담긴 상품 전체 출력
    {
        List<CartDetailDto> cartDetailDtoList = new ArrayList<>(); // 장바구니에 담긴 상품들 출력하기 위해 만든 ArrayList

        Member member = mdao.findById(mem_id);	// 회원 선택
        
        Cart cart = cdao.findByMemberId(member.getMem_id());	// 선택한 회원의 장바구니 가져오기 
        
        if(cart == null)	// 장바구니에 담긴게 없으면
        {
            return cartDetailDtoList;	// 빈채로 출력
        }

        cartDetailDtoList = cdao.findCartDetailDtoList(cart.getCart_seq());	// 담긴게 있으면 그대로 저장
        return cartDetailDtoList;	// 출력
    }
    
    
    @Transactional(readOnly = true)
    public boolean validateCartProduct(int cartp_seq, String mem_id) // 로그인한 사람이랑 주문한 사람이랑 동일한지 확인
    {
    	Member member = mdao.findById(mem_id);	// 매개변수로 받은 id값(로그인한 사람)
    	CartProduct cartProduct = cdao.findCartProductId(cartp_seq);	// 장바구니에 담긴 상품 구분번호
    	Member saveMember = cartProduct.getCart().getMember();	// 장바구니 생성한 id값(장바구니 주인 = 주문자)
    	if(member.getMem_id()!=saveMember.getMem_id())	// 장바구니 생성한 id값(주문자)과 매개변수로 받은 id값(로그인한 사람)이 다르면
    	{
    		return false;	// 장바구니에 상품 담기 불가능
    	}
    	
    	return true;	// 장바구니에 상품담는 거 가능
    }
    
    
    public void updateCartProductCount(int cartp_seq, int cnt)	// 장바구니 상품 수량 업데이트
    {
    	CartProduct cartProduct = cdao.findCartProductId(cartp_seq);
    	cartProduct.updateCount(cnt);
    }
    
    
    public void deleteCartProduct(int cartp_seq)	// 장바구니에 담긴 상품 삭제
    {
    	CartProduct cartProduct = cdao.findCartProductId(cartp_seq);	// 삭제할 장바구니 아이템 선택
    	cdao.deleteCartProduct(cartProduct);	//	장바구니에 담긴 상품 삭제
    }
    
    
    // 장바구니 정보 가져와서 payment랑 paymentProduct에 저장 후 장바구니의 값을 제거
    public int paymentCartProduct(List<CartOrderDto> cartOrderDtoList, String mem_id)
    {
    	List<PaymentDto> paymentDtoList = new ArrayList<>(); // Payment에 저장하기 위한 ArrayList생성
    	for(CartOrderDto cartOrderDto : cartOrderDtoList)
    	{
    		CartProduct cartProduct = cdao.findCartProductId(cartOrderDto.getCartp_seq());
    		PaymentDto paymentDto = new PaymentDto();
    		paymentDto.setProd_seq(cartProduct.getProduct().getProd_seq());
    		paymentDto.setCount(cartProduct.getCartp_cnt());
    		paymentDtoList.add(paymentDto);
    	}
    	
    	int pay_seq = service.Payments(paymentDtoList, mem_id);
    	
    	for(CartOrderDto cartOrderDto : cartOrderDtoList)
    	{
    		CartProduct cartProduct = cdao.findCartProductId(cartOrderDto.getCartp_seq());
    		cdao.deleteCartProduct(cartProduct);
    	}
    	
    	return pay_seq;
    }
}
