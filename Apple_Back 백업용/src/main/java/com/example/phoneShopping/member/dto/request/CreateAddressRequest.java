package com.example.phoneShopping.member.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAddressRequest 
{
	@NotBlank
	private int addr_seq;	// 주소 구분 번호
	
	@NotBlank
	private String addr_zip;	// 주소 우편번호
	
	@NotBlank
	private String addr_detail;	// 주소 상세
}
