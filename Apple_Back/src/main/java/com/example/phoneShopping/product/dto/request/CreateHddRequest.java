package com.example.phoneShopping.product.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateHddRequest 
{
	int hddSeq;	// HDD 구분
	int capacity;	// HDD 용량
	int plusSeq;	// HDD용량에 따른 추가 금액
	
	public CreateHddRequest(int capacity, int plusSeq)
	{
		this.capacity=capacity;
		this.plusSeq=plusSeq;
	}
}
