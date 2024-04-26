package com.example.phoneShopping.member.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateInfoRequest 
{
	@NotBlank
	private int info_seq;		// 개인정보 구분 번호
	
	@NotBlank
	private String info_name;	// 회원 이름
	
	@NotBlank
	private String info_birth;	// 회원 생일
	
	@NotBlank
	private String info_gender;	// 회원 성별
	
	@NotBlank
	private String info_phone;	// 회원 전화번호
}
