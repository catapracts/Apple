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
public class JoinRequest 
{
	@NotBlank
	private String memId;	// 회원 ID
	
	@NotBlank
	private String memPw;	// 회원 PW
	
	@NotBlank
	private String checkMemPw;	// 회원 PW
}
