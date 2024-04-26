package com.example.phoneShopping.member.dto.param;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateAddressParam 
{
	private int addr_seq;
	private String addr_zip;
	private String addr_detail;
	
	public UpdateAddressParam(int addr_seq, String addr_zip, String addr_detail)
	{
		this.addr_seq=addr_seq;
		this.addr_zip=addr_zip;
		this.addr_detail=addr_detail;
	}
}
