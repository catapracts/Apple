package com.example.phoneShopping.payment.dto.response;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePaymentResponse {
	private int pay_seq;
	
	public CreatePaymentResponse(int pay_seq) {
		
		this.pay_seq=pay_seq;
	}

}
