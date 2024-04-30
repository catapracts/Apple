package com.example.phoneShopping.product.dto.param;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductParam 
{

	// 상품 일련번호
	private String prod_seq;
	
	// 상품 이름
	private String prod_name;
	
	// 상품 가격
	private int prod_price;
	
	// 재고
	private int prod_cnt;
	
	// 옵션 1 : 용량 - FK
	private int hdd_seq;
	
	// 옵션 2 : 색상 - FK
	private int color_seq;
}
