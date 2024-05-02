package com.example.phoneShopping.member.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCardRequest 
{
	@NotBlank
	private int cardSeq;		// 카드 구분 번호
	
	@NotBlank
	private String cardComp;	// 카드회사
	
	@NotBlank
	private String cardNum;		// 카드번호
	
	@NotBlank
	private String cardDate;	// 카드 유효기간
	
	@NotBlank
	private int cardCvc;		// 카드 CVC
	
	public UpdateCardRequest(String cardComp, String cardNum, String cardDate, int cardCvc)
	{
		this.cardComp=cardComp;
		this.cardNum=cardNum;
		this.cardDate=cardDate;
		this.cardCvc=cardCvc;
	}
}
