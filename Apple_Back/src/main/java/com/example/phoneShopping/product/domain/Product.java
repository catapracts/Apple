package com.example.phoneShopping.product.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product 
{
	// 상품 일련번호
//	private String prod_seq;
	private String prodSeq;
	// 상품 이름
//	private String prod_name;
	private String prodName;
	// 상품 가격
//	private int prod_price;
	private int prodPrice;
	// 재고
//	private int prod_cnt;
	private int prodCnt;
	
	// 옵션 1 : 용량 - FK
//	private int hdd_seq;
	private int hddSeq;
	
	// 옵션 2 : 색상 - FK
//	private int color_seq;
	private int colorSeq;
}
