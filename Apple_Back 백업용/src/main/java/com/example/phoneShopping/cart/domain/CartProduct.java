package com.example.phoneShopping.cart.domain;

import com.example.phoneShopping.product.domain.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartProduct 
{
	private int cartp_seq;
	
	private Cart cart;
	
	private Product product;
	
	private int cartp_cnt;
	
	public static CartProduct createCartProduct(Cart cart, Product product, int cartp_cnt)
	{
		CartProduct cartproduct = new CartProduct();
		cartproduct.setCart(cart);
		cartproduct.setProduct(product);
		cartproduct.setCartp_cnt(cartp_cnt);
		return cartproduct;
	}
	
    public void addCount(int cartp_cnt)
    {
        this.cartp_cnt += cartp_cnt;
    }

    public void updateCount(int cartp_cnt)
    {
        this.cartp_cnt = cartp_cnt;
    }	
	
}
