package com.example.phoneShopping.member.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCardResponse 
{
	private int card_seq;
	
	public CreateCardResponse(int card_seq)
	{
		this.card_seq=card_seq;
	}
}
