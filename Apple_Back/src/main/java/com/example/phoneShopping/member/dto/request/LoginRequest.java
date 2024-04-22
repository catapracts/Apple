package com.example.phoneShopping.member.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest 
{
	@NotBlank
	private String mem_id;	// 회원 ID
	
	@NotBlank
	private String mem_pw;	// 회원 PW
}
