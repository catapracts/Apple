package com.example.phoneShopping;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.phoneShopping.member.domain.Member;
import com.example.phoneShopping.member.dto.request.JoinRequest;
import com.example.phoneShopping.member.dto.response.JoinResponse;
import com.example.phoneShopping.member.service.MemberService;

@SpringBootTest
public class MemberTest 
{
	@Autowired
	MemberService service;
	
	@Test
	void createTest()
	{
		Member member = new Member(1, "a", "1234");
		JoinRequest joinRequest = new JoinRequest();
		joinRequest.setMem_seq(member.getMem_seq());
		joinRequest.setMem_id(member.getMem_id());
		joinRequest.setMem_pw(member.getMem_pw());
		joinRequest.setCheck_mem_pw(member.getMem_pw());
		JoinResponse joinResponse = new JoinResponse(joinRequest.getMem_id());
		service.join(joinRequest);
	}

}
