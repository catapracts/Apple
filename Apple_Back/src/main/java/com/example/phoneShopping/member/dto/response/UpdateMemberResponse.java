package com.example.phoneShopping.member.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateMemberResponse 
{
	private int mem_seq;
	
	public UpdateMemberResponse(int mem_seq)
	{
		this.mem_seq=mem_seq;
	}	
}
