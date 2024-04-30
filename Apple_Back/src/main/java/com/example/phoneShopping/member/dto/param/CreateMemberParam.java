package com.example.phoneShopping.member.dto.param;

import com.example.phoneShopping.member.dto.request.JoinRequest;


import lombok.Getter;

import lombok.Setter;

@Getter
@Setter

public class CreateMemberParam 
{
	private int mem_seq;	// 회원 구분 번호
	private String mem_id;	// 회원 ID
	private String mem_pw;	// 회원 PW
	
	public CreateMemberParam(JoinRequest req, String encodedPwd)
	{
		this.mem_id=req.getMem_id();
		this.mem_pw=encodedPwd;
	}
}
