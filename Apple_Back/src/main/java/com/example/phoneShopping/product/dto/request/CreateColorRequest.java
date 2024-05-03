package com.example.phoneShopping.product.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateColorRequest 
{	
	@NotBlank
	int colorSeq;	// Color 구분
	
	@NotBlank
	String color;	// Color
	
	public CreateColorRequest(String color)
	{
		this.color=color;
	}
}
