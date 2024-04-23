package com.example.phoneShopping.payment.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatePaymentResponse {
	
	private int pay_seq;
	
	public UpdatePaymentResponse(int pay_seq) {
		this.pay_seq=pay_seq;
	}

}
