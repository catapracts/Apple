package com.example.phoneShopping.member.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Card 
{
	private int cardSeq;		// 카드 구분 번호
	private String cardComp;	// 카드회사
	private String cardNum;		// 카드번호
	private String cardDate;	// 카드 유효기간
	private int cardCvc;		// 카드 CVC
	
	public Card(String cardComp, String cardNum, String cardDate, int cardCvc)
	{
		this.cardComp=cardComp;
		this.cardNum=cardNum;
		this.cardDate=cardDate;
		this.cardCvc=cardCvc;
	}
}
