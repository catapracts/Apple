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
	
	private String productSeq;
	
	private int cartpCnt;
	
    public void addCount(int cartp_cnt)
    {
        this.cartpCnt += cartp_cnt;
    }

    public void updateCount(int cartp_cnt)
    {
        this.cartpCnt = cartp_cnt;
    }	
    
    public CartProduct(int cartSeq, String productSeq, int cartpCnt)
    {
    	this.cartSeq=cartSeq;
    	this.productSeq=productSeq;
    	this.cartpCnt=cartpCnt;    			
    }
	
}
