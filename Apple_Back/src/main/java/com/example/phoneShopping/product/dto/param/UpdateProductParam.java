package com.example.phoneShopping.product.dto.param;

import com.example.phoneShopping.product.dto.request.UpdateProductRequest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProductParam {

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
	
	public UpdateProductParam(String prod_seq, String prod_name, int prod_price, int prod_hdd,
								String prod_color, int prod_cnt) {
		this.prod_seq = prod_seq();
		this.prod_name = prod_name();
		this.prod_price = prod_price();
		this.prod_hdd = prod_hdd();
		this.prod_color = prod_color();
		this.prod_cnt = prod_cnt();
	}
	
}
