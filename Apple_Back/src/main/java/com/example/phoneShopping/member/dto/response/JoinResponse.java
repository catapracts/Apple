package com.example.phoneShopping.member.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoinResponse 
{
	private String mem_id;
	
	public JoinResponse(String mem_id)
	{
		this.mem_id=mem_id;
	}
}
