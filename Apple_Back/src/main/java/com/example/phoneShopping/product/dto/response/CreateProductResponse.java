package com.example.phoneShopping.product.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductResponse {

	private String prod_seq;
	
	public CreateProductResponse(String prod_seq) 
	{
		this.prod_seq = prod_seq;
	}
	
}
