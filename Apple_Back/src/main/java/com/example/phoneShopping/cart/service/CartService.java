package com.example.phoneShopping.cart.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.phoneShopping.cart.dao.CartDao;
import com.example.phoneShopping.cart.domain.Cart;
import com.example.phoneShopping.cart.domain.CartProduct;

import com.example.phoneShopping.cart.dto.param.CreateCartParam;
import com.example.phoneShopping.cart.dto.param.CreateCartProductParam;
import com.example.phoneShopping.cart.dto.param.UpdateCartParam;
import com.example.phoneShopping.cart.dto.param.UpdateCartProductParam;
import com.example.phoneShopping.cart.dto.request.CreateCartProductRequest;
import com.example.phoneShopping.cart.dto.request.CreateCartRequest;
import com.example.phoneShopping.cart.dto.request.UpdateCartProductRequest;
import com.example.phoneShopping.cart.dto.request.UpdateCartRequest;
import com.example.phoneShopping.cart.dto.response.CreateCartProductResponse;
import com.example.phoneShopping.cart.dto.response.CreateCartResponse;
import com.example.phoneShopping.cart.dto.response.UpdateCartProductResponse;
import com.example.phoneShopping.cart.dto.response.UpdateCartResponse;
import com.example.phoneShopping.cart.exception.CartException;
import com.example.phoneShopping.cart.exception.CartProductException;

import lombok.RequiredArgsConstructor;


@Service
@Transactional
@RequiredArgsConstructor
public class CartService 
{
	private final CartDao dao;
	
	@Transactional
	public CreateCartResponse createCart(CreateCartRequest req)
	{
		createCartMethod(req);
		return new CreateCartResponse(req.getCartSeq());
	}
		
	private void createCartMethod(CreateCartRequest req)
	{
		System.out.println("createCart동작");
		CreateCartParam param = new CreateCartParam(req.getCartSeq() ,req.getMemSeq());
		
		Integer result = dao.createCart(param);
		if(result==0)
		{
			throw new CartException("Cart 등록 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Transactional(readOnly=true)
	public List<Cart> findAllCart()
	{
		System.out.println("findAllAddress동작");
		List<Cart> list = dao.findAllCart();
		
		for(int i = 0; i < dao.findAllCart().size(); i++)
		{
			System.out.println(dao.findAllCart().get(i).getCartSeq());
			System.out.println(dao.findAllCart().get(i).getMemSeq());
			System.out.println("\n");
		}
		
		return list;
	}
	
	@Transactional(readOnly=true)
	public Cart findByIdCart(int cart_seq) 
	{
		System.out.println("findByIdCart동작");
		Cart cart = dao.findByIdCart(cart_seq);
		System.out.println(cart.getCartSeq());
		System.out.println(cart.getMemSeq());
		return cart;
	}
	
	@Transactional
	public UpdateCartResponse updateCart(UpdateCartRequest req)
	{
		Cart cart = findByIdCart(req.getCartSeq());
		if(req.getCartSeq() == cart.getCartSeq())
		{
			updateCartMethod(req);
		}
		
		return new UpdateCartResponse(req.getCartSeq());
	}
	
	private void updateCartMethod(UpdateCartRequest req)
	{
		System.out.println("updateCart동작");
				
		UpdateCartParam param = new UpdateCartParam(req.getCartSeq() ,req.getMemSeq());
		
		Integer result = dao.updateCart(param);
		
		if(result==0)
		{
			throw new CartException("Cart 수정 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Transactional
	public void deleteCart(int cart_seq)
	{
		System.out.println("deleteCart동작");
		dao.deleteCart(cart_seq);
	}
	
	
	@Transactional
	public CreateCartProductResponse createCartProduct(CreateCartProductRequest req)
	{
		createCartProductMethod(req);
		return new CreateCartProductResponse(req.getCartpSeq());
	}
		
	private void createCartProductMethod(CreateCartProductRequest req)
	{
		System.out.println("createCartProduct동작");
		CreateCartProductParam param = new CreateCartProductParam(req.getCartpSeq() ,req.getCartSeq(), req.getProductSeq(), req.getCartpCnt());
		
		Integer result = dao.createCartProduct(param);
		
		if(result==0)
		{
			throw new CartProductException("CartProduct 등록 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Transactional(readOnly=true)
	public List<CartProduct> findAllCartProduct()
	{
		System.out.println("findAllCartProduct동작");
		List<CartProduct> list = dao.findAllCartProduct();
		
		for(int i = 0; i < dao.findAllCartProduct().size(); i++)
		{
			System.out.println(dao.findAllCartProduct().get(i).getCartpSeq());
			System.out.println(dao.findAllCartProduct().get(i).getCartSeq());
			System.out.println(dao.findAllCartProduct().get(i).getProductSeq());
			System.out.println(dao.findAllCartProduct().get(i).getCartpCnt());
			System.out.println("\n");
		}
		
		return list;
	}
	
	@Transactional(readOnly=true)
	public CartProduct findByIdCartProduct(int cartp_seq) 
	{
		System.out.println("findByIdCartProduct동작");
		CartProduct cartProduct = dao.findByIdCartProduct(cartp_seq);
		System.out.println(cartProduct.getCartpSeq());
		System.out.println(cartProduct.getCartSeq());
		System.out.println(cartProduct.getProductSeq());
		System.out.println(cartProduct.getCartpCnt());
		return cartProduct;
	}
	
	@Transactional
	public UpdateCartProductResponse updateCartProduct(UpdateCartProductRequest req)
	{
		CartProduct cartProduct = findByIdCartProduct(req.getCartpSeq());
		if(req.getCartpSeq() == cartProduct.getCartpSeq())
		{
			updateCartProductMethod(req);
		}
		
		return new UpdateCartProductResponse(req.getCartpSeq());
	}
	
	private void updateCartProductMethod(UpdateCartProductRequest req)
	{
		System.out.println("updateCartProduct동작");
				
		UpdateCartProductParam param = new UpdateCartProductParam(req.getCartpSeq() ,req.getCartSeq(), req.getProductSeq(), req.getCartpCnt());
		
		Integer result = dao.updateCartProduct(param);
		
		if(result==0)
		{
			throw new CartProductException("CartProduct 수정 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Transactional
	public void deleteCartProduct(int cartp_seq)
	{
		System.out.println("deleteCartProduct동작");
		dao.deleteCartProduct(cartp_seq);
	}
    
    
    public void updateCartProductCount(int cartp_seq, int cnt)	// 장바구니 상품 수량 업데이트
    {
    	CartProduct cartProduct = dao.findByIdCartProduct(cartp_seq);
    	cartProduct.updateCount(cnt);
    }
}
