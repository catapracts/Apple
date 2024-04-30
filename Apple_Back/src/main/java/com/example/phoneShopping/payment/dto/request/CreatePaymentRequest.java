package com.example.phoneShopping.payment.dto.request;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreatePaymentRequest 
{
	private int paySeq;	// 결제 번호
	private int memSeq;	// 결제자
	private LocalDateTime payDate;	// 결제일
	private int payStatus;	// 결제 상태

	public CreatePaymentRequest(int memSeq, LocalDateTime payDate, int payStatus)
	{
		this.memSeq=memSeq;
		this.payDate=payDate;
		this.payStatus=payStatus;
	}
}
