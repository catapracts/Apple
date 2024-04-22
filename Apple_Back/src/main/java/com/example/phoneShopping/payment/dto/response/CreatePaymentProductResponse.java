package com.example.phoneShopping.payment.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePaymentProductResponse {
	private int payi_seq;
	
	public CreatePaymentProductResponse(int payi_seq) {
		this.payi_seq=payi_seq;
	}

}
