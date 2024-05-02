package com.example.phoneShopping.member.dto.param;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAddressParam 
{
	private int addrSeq;
	private String addrZip;
	private String addrDetail;
	
	public UpdateAddressParam(String addr_zip, String addr_detail)
	{
		this.addrZip=addr_zip;
		this.addrDetail=addr_detail;
	}
}
