package com.example.phoneShopping.product.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product 
{
	
	// 상품 일련번호
	private String prod_seq;
	
	// 상품 이름
	private String prod_name;
	
	// 상품 가격
	private int prod_price;
	
	// 옵션 1 : 용량 - FK
	private int prod_hdd;
	
	// 옵션 2 : 색상 - FK
	private String prod_color;
	
	// 재고
	private int prod_cnt;
	
}
