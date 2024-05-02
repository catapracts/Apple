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
public class UpdateInfoRequest 
{
	@NotBlank
	private int infoSeq;		// 개인정보 구분 번호
	
	@NotBlank
	private String infoName;	// 회원 이름
	
	@NotBlank
	private String infoBirth;	// 회원 생일
	
	@NotBlank
	private String infoGender;	// 회원 성별
	
	@NotBlank
	private String infoPhone;	// 회원 전화번호

	public UpdateInfoRequest(String infoName, String infoBirth, String infoGender, String infoPhone)
	{
		this.infoName=infoName;
		this.infoBirth=infoBirth;
		this.infoGender=infoGender;
		this.infoPhone=infoPhone;
	}
}
