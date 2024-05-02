package com.example.phoneShopping.product.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateColorRequest 
{
	int colorSeq;	// Color 구분
	String color;	// Color
	
	public UpdateColorRequest(String color)
	{
		this.color=color;
	}
}
