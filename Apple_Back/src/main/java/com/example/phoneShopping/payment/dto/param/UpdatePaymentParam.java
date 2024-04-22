package com.example.phoneShopping.payment.dto.param;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatePaymentParam {
	private int pay_seq;	// 결제 번호
	private String member;	// 결제자
	private Date pay_date;	// 결제일
	private int pay_status;	// 결제 상태

	public UpdatePaymentParam(int pay_seq, String member, Date pay_date, int pay_status) {
		super();
		this.pay_seq=pay_seq;
		this.member=member;
		this.pay_date=pay_date;
		this.pay_status=pay_status;
	}

}
