package com.example.phoneShopping.member.dto.param;

import com.example.phoneShopping.member.dto.request.CreateAddressRequest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAddressParam 
{
	private int addr_seq;
	private String addr_zip;
	private String addr_detail;
	
	public CreateAddressParam(CreateAddressRequest req)
	{
		this.addr_seq=req.getAddr_seq();
		this.addr_zip=req.getAddr_zip();
		this.addr_detail=req.getAddr_detail();
	}
}
