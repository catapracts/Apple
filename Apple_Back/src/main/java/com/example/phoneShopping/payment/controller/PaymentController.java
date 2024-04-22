package com.example.phoneShopping.payment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.phoneShopping.member.service.MemberService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

// @Tag(name = "MemberController", description = "회원 API") 이게 뭐임?
@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {
	
	@GetMapping("/getAll")
	public void findAllPayment() {
		System.out.println("결제 정보 전체 출력");
		service.findAllPayment();
	}
	
	@GetMapping("/getOnePayment")
	public void findByIdPayment(int pay_seq) {
		System.out.println("결제 정보 1개 출력");
		System.out.println(pay_seq);
		service.findByIdPayment(pay_seq);
	}
	
	@PostMapping("/")

}
