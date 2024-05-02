package com.example.phoneShopping.product.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequest 
{

	// 상품 일련번호
	@NotBlank
	private String prodSeq;
	
	// 상품 이름
	@NotBlank
	private String prodName;
	
	// 상품 가격
	@NotBlank
	private int prodPrice;
	
	// 재고
	@NotBlank
	private int prodCnt;
	
	// 옵션 1 : 용량 - FK
	@NotBlank
	private int hddSeq;
	
	// 옵션 2 : 색상 - FK
	@NotBlank
	private int colorSeq;
	
}