package com.example.phoneShopping.payment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.phoneShopping.payment.dto.request.CreatePaymentProductRequest;
import com.example.phoneShopping.payment.dto.request.CreatePaymentRequest;
import com.example.phoneShopping.payment.dto.request.UpdatePaymentProductRequest;
import com.example.phoneShopping.payment.dto.request.UpdatePaymentRequest;
import com.example.phoneShopping.payment.dto.response.CreatePaymentProductResponse;
import com.example.phoneShopping.payment.dto.response.CreatePaymentResponse;
import com.example.phoneShopping.payment.dto.response.UpdatePaymentProductResponse;
import com.example.phoneShopping.payment.dto.response.UpdatePaymentResponse;
import com.example.phoneShopping.payment.service.PaymentService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Tag(name = "PaymentController", description = "Payment API")
@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController 
{
	
	private final PaymentService service;
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/createPayment")
	public ResponseEntity<CreatePaymentResponse> createPayment(@Valid @RequestBody CreatePaymentRequest req)
	{
		System.out.println("Payment 정보 생성");
		return ResponseEntity.ok(service.createPayment(req));
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/getAllPayment")
	public void findAllPayment()
	{
		System.out.println("Payment정보 전체 출력");
		service.findAllPayment();
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/getOnePayment")
	public void findByIdPayment(int paySeq)
	{
		System.out.println("Payment 정보 1개 출력");
		System.out.println(paySeq);
		service.findByIdPayment(paySeq);
	}
	
	@PreAuthorize("isAuthenticated()")
	@PatchMapping(value = "/updatePayment/{paySeq}")
	public ResponseEntity<UpdatePaymentResponse> updatePayment(@Valid @RequestBody UpdatePaymentRequest req)
	{
		System.out.println("Payment 정보 수정");
		return ResponseEntity.ok(service.updatePayment(req));
	}
	
	@PreAuthorize("isAuthenticated()")
	@DeleteMapping(value = "/deletePayment/{paySeq}")
	public void deletePayment(int paySeq)
	{
		System.out.println("Payment 정보 제거");
		System.out.println(paySeq);
		service.deletePayment(paySeq);
	}
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/createPaymentProduct")
	public ResponseEntity<CreatePaymentProductResponse> createPaymentProduct(@Valid @RequestBody CreatePaymentProductRequest req)
	{
		System.out.println("PaymentProduct 정보 생성");
		return ResponseEntity.ok(service.createPaymentProduct(req));
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/getAllPaymentProduct")
	public void findAllPaymentProduct()
	{
		System.out.println("PaymentProduct 정보 전체 출력");
		service.findAllPaymentProduct();
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/getOnePaymentProduct")
	public void findByIdPaymentProduct(int payiSeq)
	{
		System.out.println("PaymentProduct 정보 1개 출력");
		System.out.println(payiSeq);
		service.findByIdPaymentProduct(payiSeq);
	}
	
	@PreAuthorize("isAuthenticated()")
	@PatchMapping(value = "/updatePaymentProduct/{payiSeq}")
	public ResponseEntity<UpdatePaymentProductResponse> updatePaymentProduct(@Valid @RequestBody UpdatePaymentProductRequest req)
	{
		System.out.println("PaymentProduct 정보 수정");
		return ResponseEntity.ok(service.updatePaymentProduct(req));
	}
	
	@PreAuthorize("isAuthenticated()")
	@DeleteMapping(value = "/deletePaymentProduct/{payiSeq}")
	public void deletePaymentProduct(int payiSeq)
	{
		System.out.println("PaymentProduct 정보 제거");
		System.out.println(payiSeq);
		service.deletePayment(payiSeq);
	}

}
