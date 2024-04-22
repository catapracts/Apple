package com.example.phoneShopping.member.dto.param;

import com.example.phoneShopping.member.dto.request.CreateCardRequest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCardParam 
{
	private int card_seq;		// 카드 구분 번호
	private String card_comp;	// 카드회사
	private int card_num;		// 카드번호
	private String card_date;	// 카드 유효기간
	private int card_cvc;		// 카드 CVC
	
	public CreateCardParam(CreateCardRequest req)
	{
		this.card_seq=req.getCard_seq();
		this.card_comp=req.getCard_comp();
		this.card_num=req.getCard_num();
		this.card_date=req.getCard_date();
		this.card_cvc=req.getCard_cvc();
	}
}
