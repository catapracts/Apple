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
public class UpdateMemberRequest 
{
	@NotBlank
	private String mem_id;	// 회원 ID
	
	@NotBlank
	private String mem_pw;	// 회원 PW
	
	@NotBlank
	private String check_mem_pw;	// 회원 PW

}
