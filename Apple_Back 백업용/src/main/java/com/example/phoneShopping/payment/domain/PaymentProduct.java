package com.example.phoneShopping.payment.domain;

import com.example.phoneShopping.product.domain.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentProduct 
{
	private int payi_seq;	// 결제 상품 번호
	private Product product;	// 결제 상품
	private Payment payment;	// 결제 내역
	private int payi_price;	// 결제 가격
	private int payi_count;	// 결제 개수
	
    public static PaymentProduct createPaymentProduct(Product product, int count)
    {
    	PaymentProduct paymentProduct = new PaymentProduct();
    	paymentProduct.setProduct(product);
    	paymentProduct.setPayi_count(count);
    	paymentProduct.setPayi_price(product.getProd_price());
        return paymentProduct;
    }

    public int getTotalPrice()
    {
        return payi_price*payi_count;
    }
    
    public void deletePayment()
    {
    	//delete Query작성
    }

}
