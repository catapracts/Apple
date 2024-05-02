package com.example.phoneShopping.product.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Color
{
	int colorSeq;	// 용량별 추가금액 구분
	String color;		// 추가 금액
	
	public Color(String color)
	{
		this.color=color;
	}
}
