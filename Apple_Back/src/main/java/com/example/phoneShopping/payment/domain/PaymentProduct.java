package com.example.phoneShopping.payment.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentProduct {
	private int payi_seq;	// 결제 상품 번호
	private String product;	// 결제 상품
	private Payment payment;	// 결제 내역
	private int payi_price;	// 결제 가격
	private int payi_count;	// 결제 개수
	
	public PaymentProduct(int payi_seq, String product, Payment payment, int payi_price, int payi_count) {
		super();
		this.payi_seq=payi_seq;
		this.product=product;
		this.payment=payment;
		this.payi_price=payi_price;
		this.payi_count=payi_count;
	}

}
