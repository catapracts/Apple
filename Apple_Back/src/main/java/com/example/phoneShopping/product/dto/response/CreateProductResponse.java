package com.example.phoneShopping.product.dto.response;

public class CreateProductResponse {

	private String prod_seq;
	
	public CreateProductResponse(String prod_seq) {
		this.prod_seq = prod_seq;
	}
	
	public String getProd_seq() {
		return prod_seq;
	}
	
	public void setProd_seq(String prod_seq) {
		this.prod_seq = prod_seq;
	}
	
}
