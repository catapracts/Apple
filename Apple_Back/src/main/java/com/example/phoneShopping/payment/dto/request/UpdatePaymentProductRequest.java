package com.example.phoneShopping.payment.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePaymentProductRequest 
{
	private int payiSeq;	// 결제 상품 번호
	private String prodSeq;	// 결제 상품
	private int paySeq;	// 결제 내역
	private int payiPrice;	// 결제 가격
	private int payiCount;	// 결제 개수
	
	public UpdatePaymentProductRequest(int paySeq, String prodSeq, int payiPrice, int payiCount)
	{
		this.paySeq=paySeq;
		this.prodSeq=prodSeq;
		this.payiPrice=payiPrice;
		this.payiCount=payiCount;
	}
}
