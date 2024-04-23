package com.example.phoneShopping.payment.controller;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.phoneShopping.member.dto.request.JoinRequest;
import com.example.phoneShopping.member.dto.response.JoinResponse;
import com.example.phoneShopping.member.service.MemberService;
import com.example.phoneShopping.payment.dto.request.CreatePaymentProductRequest;
import com.example.phoneShopping.payment.dto.request.CreatePaymentRequest;
import com.example.phoneShopping.payment.dto.request.UpdatePaymentRequest;
import com.example.phoneShopping.payment.dto.response.CreatePaymentProductResponse;
import com.example.phoneShopping.payment.dto.response.CreatePaymentResponse;
import com.example.phoneShopping.payment.dto.response.UpdatePaymentResponse;
import com.example.phoneShopping.payment.service.PaymentProductService;
import com.example.phoneShopping.payment.service.PaymentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

// @Tag(name = "MemberController", description = "회원 API") 이게 뭐임?
@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {
	
	private final PaymentProductService service;
	
	@PostMapping("/create")
	public ResponseEntity<CreatePaymentProductResponse> createPayment(CreatePaymentProductRequest req) 
	{
		System.out.println("UserController join " + new Date());

		return ResponseEntity.ok(service.createPaymentProduct(req));
	}
	
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
	
	@PostMapping("/update")
	public ResponseEntity<UpdatePaymentResponse> updatepayment(@Valid @RequestBody UpdatePaymentRequest req) {
		System.out.println("결제 정보 수정");
		return ResponseEntity.ok(service.updatePayment(req));
	}
	
	@GetMapping("/deletePayment")
	public void delete(int pay_seq) {
		System.out.println("결제 정보 제거");
		System.out.println("pay_seq");
		service.deletePayment(pay_seq);
	}

}
