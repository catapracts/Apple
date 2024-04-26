package com.example.phoneShopping.payment.dto.param;

import com.example.phoneShopping.payment.domain.PaymentProduct;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentProductDto 
{
	
	public PaymentProductDto(PaymentProduct paymentProduct)
	{
		this.payi_count = paymentProduct.getPayi_count();
		this.payi_price = paymentProduct.getPayi_price();
		this.prod_name = paymentProduct.getProduct().getProd_name();
	}
	
	private String prod_name;	// 결제 상품 이름
	private int payi_price;	// 결제 가격
	private int payi_count;	// 결제 개수
}
