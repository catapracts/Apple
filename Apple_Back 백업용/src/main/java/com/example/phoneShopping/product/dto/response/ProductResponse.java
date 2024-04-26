package com.example.phoneShopping.product.dto.response;

import com.example.phoneShopping.product.domain.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse {

	private Product product;
	
	public ProductResponse(Product product) {
		this.product = product;
	}
	
}
