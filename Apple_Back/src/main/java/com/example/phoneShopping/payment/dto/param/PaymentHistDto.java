package com.example.phoneShopping.payment.dto.param;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.phoneShopping.payment.domain.Payment;

public class PaymentHistDto 
{
	
	public PaymentHistDto(Payment payment)
	{
		this.mem_id = payment.getMember().getMem_id();
		this.date = payment.getPay_date();
		this.status = payment.getPay_status();
	}
	
	private String mem_id;
	private LocalDateTime date;
	private int status;

	
	private List<PaymentProductDto> paymentProductDtoList = new ArrayList<>();
	
	public void addPaymentProductDto(PaymentProductDto paymentProductDto)
	{
		paymentProductDtoList.add(paymentProductDto);
	}
}
