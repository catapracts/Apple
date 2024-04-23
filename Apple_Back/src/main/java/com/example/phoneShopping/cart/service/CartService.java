package com.example.phoneShopping.cart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.phoneShopping.cart.dao.CartDao;
import com.example.phoneShopping.cart.domain.Cart;
import com.example.phoneShopping.cart.domain.CartProduct;
import com.example.phoneShopping.cart.dto.param.CartDetailDto;
import com.example.phoneShopping.cart.dto.param.CartProductDto;
import com.example.phoneShopping.member.dao.MemberDao;
import com.example.phoneShopping.member.domain.Member;
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
	
	public int addCart(CartProductDto cartProductDto, String mem_id)
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
    public List<CartDetailDto> getCartList(String mem_id)	// 장바구니에 담긴 상품 리스트 출력
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
    
    
}
