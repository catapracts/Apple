package com.example.phoneShopping.member.dto.param;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateMemberParam 
{
	private int mem_seq;	// 회원 구분 번호
	private String mem_id;	// 회원 ID
	private String mem_pw;	// 회원 PW
	private String check_mem_pw;	// 회원 PW
	
	public UpdateMemberParam(int mem_seq, String mem_id, String mem_pw, String check_mem_pw)
	{
		this.mem_seq=mem_seq;
		this.mem_id=mem_id;
		this.mem_pw=mem_pw;
		this.check_mem_pw=check_mem_pw;
	}
}
