package com.example.phoneShopping.payment.dto.request;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatePaymentRequest {
	
	private int pay_seq;	// 결제 번호
	
	private String member;	// 결제한 사람
	
	private Date pay_date;	// 결제일
	
	private int pay_status;	// 결제 상태 (0 = 결제 전, 1 = 결제 완료, 2 = 환불)

}
