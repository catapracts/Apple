package com.example.phoneShopping.member.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Info 
{
	private int infoSeq;		// 개인정보 구분 번호
	private String infoName;	// 회원 이름
	private String infoBirth;	// 회원 생일
	private String infoGender;	// 회원 성별
	private String infoPhone;	// 회원 전화번호
	
	public Info(String infoName, String infoBirth, String infoGender, String infoPhone)
	{
		this.infoName=infoName;
		this.infoBirth=infoBirth;
		this.infoGender=infoGender;
		this.infoPhone=infoPhone;
	}
}
