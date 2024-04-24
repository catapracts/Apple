package com.example.phoneShopping.payment.dto.param;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class PaymentDto 
{
	private String prod_seq;	// 장바구니에 넣을 상품
	private int count;		// 상품 개수
}
