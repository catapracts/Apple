package com.example.phoneShopping.product.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProductResponse {
	
	// 상품 일련번호
	private String prod_seq;
	
	public UpdateProductResponse(String prod_seq) {
		
		this.prod_seq = prod_seq;
	}
	
}
