package com.example.phoneShopping.member.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member 
{
	private int mem_seq;	// 회원 구분 번호
	private String mem_id;	// 회원 ID
	private String mem_pw;	// 회원 PW
	
	public Member(int mem_seq, String mem_id, String mem_pw)
	{
		super();
		this.mem_seq=mem_seq;
		this.mem_id=mem_id;
		this.mem_pw=mem_pw;
	}
}
