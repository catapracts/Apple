package com.example.phoneShopping.member.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAddressResponse 
{
	private int addr_seq;
	
	public CreateAddressResponse(int addr_seq)
	{
		this.addr_seq=addr_seq;
	}
}
