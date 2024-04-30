package com.example.phoneShopping.product.dto.param;

import com.example.phoneShopping.product.dto.request.CreateProductRequest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductParam {

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
	
	public CreateProductParam(CreateProductRequest req) 
	{
		this.prod_seq = req.getProd_seq();
		this.prod_name = req.getProd_name();
		this.prod_price = req.getProd_price();
		this.hdd_seq = req.getHdd_seq();
		this.color_seq = req.getColor_seq();
		this.prod_cnt = req.getProd_cnt();
	}
	
}
