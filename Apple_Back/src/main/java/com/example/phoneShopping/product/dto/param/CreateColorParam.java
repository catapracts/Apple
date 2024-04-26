package com.example.phoneShopping.product.dto.param;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateColorParam 
{
	int color_seq;	// Color 구분
	String color;	// Color
	
	public CreateColorParam(String color)
	{
		this.color=color;
	}
}
