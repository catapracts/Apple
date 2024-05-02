package com.example.phoneShopping.product.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatePlusRequest 
{
	int plusSeq;	// 용량별 추가금액 구분
	int price;		// 추가 금액
	
	public CreatePlusRequest(int price)
	{
		this.price=price;
	}
}
