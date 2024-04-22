package com.example.phoneShopping.member.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoinRequest 
{
	@NotBlank
	private int mem_seq;	// 회원 구분 번호
	
	@NotBlank
	private String mem_id;	// 회원 ID
	
	@NotBlank
	private String mem_pw;	// 회원 PW
	
	@NotBlank
	private String check_mem_pw;	// 회원 PW
}
