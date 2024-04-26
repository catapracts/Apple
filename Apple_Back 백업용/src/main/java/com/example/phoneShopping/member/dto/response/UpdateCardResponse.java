package com.example.phoneShopping.member.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCardResponse 
{
	private int card_seq;
	
	public UpdateCardResponse(int card_seq)
	{
		this.card_seq=card_seq;
	}
}
