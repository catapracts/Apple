package com.example.phoneShopping.payment.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.phoneShopping.payment.dto.param.PaymentDto;

import com.example.phoneShopping.payment.service.PaymentService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Tag(name = "PaymentController", description = "Payment API")
@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {
	
	private final PaymentService service;
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/create")
	public @ResponseBody ResponseEntity createPayment(@RequestBody @Valid PaymentDto paymentDto, String mem_id) 
	{
		System.out.println("결제 정보 생성");
		String id = mem_id;
		String member_id;
        try 
        {
        	member_id = service.order(paymentDto, mem_id);
        } 
        
        catch(Exception e)
        {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        
		return new ResponseEntity<String>(member_id, HttpStatus.OK);
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/getAll")
	public void findAllPaymentProduct(String mem_id) 
	{
		System.out.println("결제 정보 전체 출력");
		service.getPaymentList(mem_id);
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/getOne")
	public void findByIdPayment(int pay_seq) 
	{
		System.out.println("결제 정보 1개 출력");
		System.out.println(pay_seq);
		service.findByIdPayment(pay_seq);
	}

	@PreAuthorize("isAuthenticated()")
	@DeleteMapping("/delete")
	public @ResponseBody ResponseEntity deletePayment(@PathVariable("pay_seq") int pay_seq , String mem_id) 
	{
		if(!service.validateOrder(pay_seq, mem_id))
		{
			return new ResponseEntity<String>("주문 취소 권한이 없습니다.", HttpStatus.FORBIDDEN);
		}
		
		System.out.println("결제 정보 제거");
		System.out.println("pay_seq");
		service.cancelOrder(pay_seq);
		
		return new ResponseEntity<Integer>(pay_seq, HttpStatus.OK);
	}

}
