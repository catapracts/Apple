package com.example.phoneShopping.payment.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePaymentProductRequest {
	
	private int payi_seq;	// 결제 상품 번호

	private String product;	// 결제 상품
	
	private int payment;	// 결제 내역
	
	private int payi_price;	// 결제 가격
	
	private int payi_count;	// 결제 개수
	
}
