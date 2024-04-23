package com.example.phoneShopping.payment.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatePaymentProductResponse {
	
	private int payi_seq;
	
	public UpdatePaymentProductResponse(int payi_seq) {
		this.payi_seq=payi_seq;
	}

}
