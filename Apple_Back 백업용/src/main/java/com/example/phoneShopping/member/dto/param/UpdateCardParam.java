package com.example.phoneShopping.member.dto.param;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCardParam 
{
	private String card_comp;	// 카드회사
	private String card_num;		// 카드번호
	private String card_date;	// 카드 유효기간
	private int card_cvc;		// 카드 CVC
	
	public UpdateCardParam(String card_comp, String card_num, String card_date, int card_cvc)
	{
		this.card_comp=card_comp;
		this.card_num=card_num;
		this.card_date=card_date;
		this.card_cvc=card_cvc;
	}
}
