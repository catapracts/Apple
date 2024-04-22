package com.example.phoneShopping.payment.dto.param;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatePaymentProductParam {
	private int payi_seq;	// 결제 상품 번호
	private String product;	// 결제 상품
	private int payment;	// 결제 내역
	private int payi_price;	// 결제 가격
	private int payi_count;	// 결제 개수
	
	public UpdatePaymentProductParam(int payi_seq, String product, int payment, int payi_price, int payi_count) {
		super();
		this.payi_seq=payi_seq;
		this.product=product;
		this.payment=payment;
		this.payi_price=payi_price;
		this.payi_count=payi_count;
	}

}
