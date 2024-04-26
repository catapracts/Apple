package com.example.phoneShopping.product.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequest {

	// 상품 일련번호
	private String prod_seq;
	
	// 상품 이름
	private String prod_name;
	
	// 상품 가격
	private int prod_price;
	
	// 옵션 1 : 용량
	private int prod_hdd;
	
	// 옵션 2 : 색상
	private String prod_color;
	
	// 재고
	private int prod_cnt;
	
}