package com.example.phoneShopping.cart.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCartRequest 
{
	private int cartSeq;	// 장바구니 번호
	private int memSeq;	// 장바구니 사용하는 회원 정보
	
	public CreateCartRequest(int memSeq)
	{
		this.memSeq=memSeq;
	}
}
