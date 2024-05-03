package com.example.phoneShopping.cart.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartProduct 
{
	private int cartpSeq;
	
	private int cartSeq;
	
	private String prodSeq;
	
	private int cartpCnt;
	
    public void addCount(int cartpCnt)
    {
        this.cartpCnt += cartpCnt;
    }

    public void updateCount(int cartpCnt)
    {
        this.cartpCnt = cartpCnt;
    }	
    
    public CartProduct(int cartSeq, String prodSeq, int cartpCnt)
    {
    	this.cartSeq=cartSeq;
    	this.prodSeq=prodSeq;
    	this.cartpCnt=cartpCnt;    			
    }
	
}
