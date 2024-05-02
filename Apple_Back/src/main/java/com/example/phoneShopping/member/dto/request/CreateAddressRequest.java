package com.example.phoneShopping.member.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateAddressRequest 
{
	@NotBlank
	private int addrSeq;	// 주소 구분 번호
	
	@NotBlank
	private String addrZip;	// 주소 우편번호
	
	@NotBlank
	private String addrDetail;	// 주소 상세
	
	public CreateAddressRequest(String addrZip, String addrDetail)
	{
		this.addrZip=addrZip;
		this.addrDetail=addrDetail;
	}
}
