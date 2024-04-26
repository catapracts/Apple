package com.example.phoneShopping.member.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data
@AllArgsConstructor
public class Member 
{
	private int memSeq;	// 회원 구분 번호
	private String memId;	// 회원 ID
	private String memPw;	// 회원 PW
	

}
