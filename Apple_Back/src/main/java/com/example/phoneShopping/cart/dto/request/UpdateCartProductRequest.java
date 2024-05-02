package com.example.phoneShopping.cart.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCartProductRequest 
{
	private int cartpSeq;
	private int cartSeq;
	private String productSeq;
	private int cartpCnt;
	
	public UpdateCartProductRequest(int cartSeq, String productSeq, int cartpCnt)
	{
		this.cartSeq=cartSeq;
		this.productSeq=productSeq;
		this.cartpCnt=cartpCnt;
	}
}
