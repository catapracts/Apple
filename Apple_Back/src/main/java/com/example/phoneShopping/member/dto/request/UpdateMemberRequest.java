package com.example.phoneShopping.member.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateMemberRequest 
{
	@NotBlank
	private int mem_seq;	// 회원 ID
	
	@NotBlank
	private String mem_id;	// 회원 ID
	
	@NotBlank
	private String mem_pw;	// 회원 PW
	
	@NotBlank
	private String check_mem_pw;	// 회원 PW
	
	public UpdateMemberRequest(int mem_seq, String mem_id, String mem_pw, String check_mem_pw)
	{
		this.mem_seq=mem_seq;
		this.mem_id=mem_id;
		this.mem_pw=mem_pw;
		this.check_mem_pw=check_mem_pw;
	}
}
