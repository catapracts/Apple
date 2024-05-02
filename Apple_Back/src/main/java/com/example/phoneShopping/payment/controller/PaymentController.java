package com.example.phoneShopping.payment.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.phoneShopping.payment.domain.Payment;
import com.example.phoneShopping.payment.domain.PaymentProduct;
import com.example.phoneShopping.payment.dto.request.CreatePaymentProductRequest;
import com.example.phoneShopping.payment.dto.request.CreatePaymentRequest;
import com.example.phoneShopping.payment.dto.request.UpdatePaymentProductRequest;
import com.example.phoneShopping.payment.dto.request.UpdatePaymentRequest;
import com.example.phoneShopping.payment.dto.response.CreatePaymentProductResponse;
import com.example.phoneShopping.payment.dto.response.CreatePaymentResponse;
import com.example.phoneShopping.payment.dto.response.DeletePaymentProductResponse;
import com.example.phoneShopping.payment.dto.response.DeletePaymentResponse;
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
	@PostMapping("/create")
	public ResponseEntity<CreatePaymentResponse> createPayment(@Valid @RequestBody CreatePaymentRequest req)
	{
		System.out.println("Payment 정보 생성");
		return ResponseEntity.ok(service.createPayment(req));
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/getAll")
	public List<Payment> findAllPayment()
	{
		System.out.println("Payment정보 전체 출력");
		return service.findAllPayment();
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/{paySeq}")
	public Payment findByIdPayment(@PathVariable(value = "paySeq") int paySeq)
	{
		System.out.println("Payment 정보 1개 출력");
		System.out.println(paySeq);
		return service.findByIdPayment(paySeq);
	}
	
	@PreAuthorize("isAuthenticated()")
	@PatchMapping("/{paySeq}")
	public ResponseEntity<UpdatePaymentResponse> updatePayment(@Valid @RequestBody UpdatePaymentRequest req)
	{
		System.out.println("Payment 정보 수정");
		return ResponseEntity.ok(service.updatePayment(req));
	}
	
	@PreAuthorize("isAuthenticated()")
	@DeleteMapping("/{paySeq}")
	public ResponseEntity<DeletePaymentResponse> deletePayment(@PathVariable(value = "paySeq") int paySeq)
	{
		System.out.println("Payment 정보 제거");
		System.out.println(paySeq);
		return ResponseEntity.ok(service.deletePayment(paySeq));
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
	public List<PaymentProduct> findAllPaymentProduct()
	{
		System.out.println("PaymentProduct 정보 전체 출력");
		return service.findAllPaymentProduct();
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/{payiSeq}")
	public PaymentProduct findByIdPaymentProduct(@PathVariable(value = "payiSeq") int payiSeq)
	{
		System.out.println("PaymentProduct 정보 1개 출력");
		System.out.println(payiSeq);
		return service.findByIdPaymentProduct(payiSeq);
	}
	
	@PreAuthorize("isAuthenticated()")
	@PatchMapping("/{payiSeq}")
	public ResponseEntity<UpdatePaymentProductResponse> updatePaymentProduct(@Valid @RequestBody UpdatePaymentProductRequest req)
	{
		System.out.println("PaymentProduct 정보 수정");
		return ResponseEntity.ok(service.updatePaymentProduct(req));
	}
	
	@PreAuthorize("isAuthenticated()")
	@DeleteMapping("/{payiSeq}")
	public ResponseEntity<DeletePaymentProductResponse> deletePaymentProduct(@PathVariable(value = "payiSeq") int payiSeq)
	{
		System.out.println("PaymentProduct 정보 제거");
		System.out.println(payiSeq);
		return ResponseEntity.ok(service.deletePaymentProduct(payiSeq));
	}

}
