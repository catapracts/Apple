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
	private String prodSeq;
	
	// 상품 이름
	private String prodName;
	
	// 상품 가격
	private int prodPrice;
	
	// 재고
	private int prodCnt;
	
	// 옵션 1 : 용량 - FK
	private int hddSeq;
	
	// 옵션 2 : 색상 - FK
	private int colorSeq;
	
	public UpdateProductParam(String prodName, int prodPrice, int prodCnt, int hddSeq, int colorSeq)
	{
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		this.prodCnt = prodCnt;
		this.hddSeq = hddSeq;
		this.colorSeq = colorSeq;
	}
}
