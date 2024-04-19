package com.example.phoneShopping.product.dto.request;

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
	
	
	public String getProd_seq() {
		return prod_seq;
	}
	
	public void setProd_seq(String prod_seq) {
		this.prod_seq = prod_seq;
	}
	
	public String getProd_name() {
		return prod_name;
	}
	
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	
	public int getProd_price() {
		return prod_price;
	}
	
	public void setProd_price(int prod_price) {
		this.prod_price = prod_price;
	}
	
	public int getProd_hdd() {
		return prod_hdd;
	}
	
	public void setProd_hdd(int prod_hdd) {
		this.prod_hdd = prod_hdd;
	}
	
	public String getProd_color() {
		return prod_color;
	}
	
	public void setProd_color(String prod_color) {
		this.prod_color = prod_color;
	}
	
	public int getProd_cnt() {
		return prod_cnt;
	}
	
	public void setProd_cnt(int prod_cnt) {
		this.prod_cnt = prod_cnt;
	}
	
}