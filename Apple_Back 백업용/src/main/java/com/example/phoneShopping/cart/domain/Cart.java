package com.example.phoneShopping.cart.domain;

import com.example.phoneShopping.member.domain.Member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cart 
{
	private int cart_seq;	// 장바구니 번호
	
	private Member member;	// 장바구니 사용하는 회원 정보
	
    public static Cart createCart(Member member) // 회원이 장바구니 생성
    {
        Cart cart = new Cart();
        cart.setMember(member);
        return cart;
    }
}
