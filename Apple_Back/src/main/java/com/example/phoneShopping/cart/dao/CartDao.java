package com.example.phoneShopping.cart.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.phoneShopping.cart.domain.Cart;
import com.example.phoneShopping.cart.domain.CartProduct;
import com.example.phoneShopping.cart.dto.param.CartDetailDto;


@Mapper
@Repository
public interface CartDao 
{
	// Cart관련 CRUD
	Cart createCart(Cart cart);
	
	
	// CartProduct관련 CRUD
	CartProduct createCartProduct(CartProduct cart);
	
	
	
	// Cart와 Cart Product는 잠시 거쳐가는 용도이므로 DB는 만들되 안에 값은 굳이 저장할 필요가 없으니 내부로직처리
	// 1회원 : 1장바구니
	Cart findByMemberId(String memberId);	// id(mem_id)로 member 정보 찾기(특정 1개)
	
	// 장바구니에 어떤 아이템이 들어있는지 가져오기 - 1개
	//select * from CartItem where cart_id =? and item_id = ?
	CartProduct findByCartIdAndProductId(int cart_seq, String prod_seq);
	
	// 장바구니에 어떤 아이템이 들어있는지 가져오기 - 전체
    /*
select new com.example.phoneShopping.cart.CartDetailDto(cp.cart_seq, p.prod_seq, p.price, cp.cnt)
from CartProduct cp join cp.Product p where cp.cart.cart_seq = :cart_seq - ANSI Join
    */
	List<CartDetailDto> findCartDetailDtoList(@Param("cart_seq") int cart_seq);

}