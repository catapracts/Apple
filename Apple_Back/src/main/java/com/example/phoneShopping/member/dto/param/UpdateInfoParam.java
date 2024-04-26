package com.example.phoneShopping.member.dto.param;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateInfoParam 
{
	private int info_seq;		// 개인정보 구분 번호
	private String info_name;	// 회원 이름
	private String info_birth;	// 회원 생일
	private String info_gender;	// 회원 성별
	private String info_phone;	// 회원 전화번호
	
	public UpdateInfoParam(int info_seq, String info_name, String info_birth, String info_gender, String info_phone)
	{
		this.info_seq=info_seq;
		this.info_name=info_name;
		this.info_birth=info_birth;
		this.info_gender=info_gender;
		this.info_phone=info_phone;
	}
}
