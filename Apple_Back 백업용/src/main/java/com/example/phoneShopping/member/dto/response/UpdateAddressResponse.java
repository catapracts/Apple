package com.example.phoneShopping.member.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateAddressResponse 
{
	private int addr_seq;
	
	public UpdateAddressResponse(int addr_seq)
	{
		this.addr_seq=addr_seq;
	}
}
