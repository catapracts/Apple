package com.example.phoneShopping.payment.dto.request;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePaymentRequest {
	
	private int pay_seq;	// 결제 번호
	
	private String member;	// 결제자
	
	private Date pay_date;	// 결제일
	
	private int pay_status;	// 결제 상태

}
