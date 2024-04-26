package com.example.phoneShopping.member.dto.param;

import com.example.phoneShopping.member.dto.request.CreateInfoRequest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateInfoParam 
{
	private int info_seq;		// 개인정보 구분 번호
	private String info_name;	// 회원 이름
	private String info_birth;	// 회원 생일
	private String info_gender;	// 회원 성별
	private String info_phone;	// 회원 전화번호
	
	public CreateInfoParam(CreateInfoRequest req)
	{
		this.info_seq=req.getInfo_seq();
		this.info_name=req.getInfo_name();
		this.info_birth=req.getInfo_birth();
		this.info_gender=req.getInfo_gender();
		this.info_phone=req.getInfo_phone();
	}
}
