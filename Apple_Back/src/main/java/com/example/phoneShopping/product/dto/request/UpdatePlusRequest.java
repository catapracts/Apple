package com.example.phoneShopping.product.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePlusRequest 
{
	int plusSeq;	// 용량별 추가금액 구분
	int price;		// 추가 금액
	
	public UpdatePlusRequest(int price)
	{
		this.price=price;
	}
}
