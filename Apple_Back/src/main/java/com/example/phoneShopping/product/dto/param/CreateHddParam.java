package com.example.phoneShopping.product.dto.param;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateHddParam 
{
	int hdd_seq;	// HDD 구분
	int capacity;	// HDD 용량
	int plus_seq;	// HDD용량에 따른 추가 금액
	
	public CreateHddParam(int capacity, int plus_seq)
	{
		this.capacity=capacity;
		this.plus_seq=plus_seq;
	}
}
