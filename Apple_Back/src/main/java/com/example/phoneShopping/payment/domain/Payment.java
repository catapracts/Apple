package com.example.phoneShopping.payment.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.phoneShopping.member.domain.Member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment 
{
	
	private int pay_seq;	// 결제 번호
	private Member member;	// 결제자
	private LocalDateTime pay_date;	// 결제일
	private int pay_status;	// 결제 상태

	private List<PaymentProduct> paymentProducts = new ArrayList<>();
	
    public void addPaymentProduct(PaymentProduct paymentProduct) 
    {
    	paymentProducts.add(paymentProduct);
        paymentProduct.setPayment(this);
    }
	
    public static Payment createPayment(Member member, List<PaymentProduct> paymentProductList) 
    {
        Payment payment = new Payment();
        payment.setMember(member);

        for(PaymentProduct paymentProduct : paymentProductList) 
        {
        	payment.addPaymentProduct(paymentProduct);
        }

        payment.setPay_status(1); // 1 = 결제 완료
        payment.setPay_date(LocalDateTime.now());
        return payment;
    }

    public int getTotalPrice() 
    {
        int totalPrice = 0;
        for(PaymentProduct paymentProduct : paymentProducts)
        {
            totalPrice += paymentProduct.getTotalPrice();
        }
        return totalPrice;
    }

    public void cancelPayment() 
    {
        this.pay_status = 2;
        for (PaymentProduct paymentProduct : paymentProducts) 
        {
        	paymentProduct.deletePayment();
        }
    }	
}
