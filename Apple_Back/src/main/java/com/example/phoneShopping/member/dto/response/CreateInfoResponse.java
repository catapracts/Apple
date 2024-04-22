package com.example.phoneShopping.member.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateInfoResponse 
{
	private int info_seq;
	
	public CreateInfoResponse(int info_seq)
	{
		this.info_seq=info_seq;
	}
}
