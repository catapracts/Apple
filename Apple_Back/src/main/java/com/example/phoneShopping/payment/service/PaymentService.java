package com.example.phoneShopping.payment.service;


import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.phoneShopping.payment.dao.PaymentDao;
import com.example.phoneShopping.payment.dto.param.CreatePaymentParam;
import com.example.phoneShopping.payment.dto.param.UpdatePaymentParam;
import com.example.phoneShopping.payment.dto.request.CreatePaymentRequest;
import com.example.phoneShopping.payment.dto.request.UpdatePaymentRequest;
import com.example.phoneShopping.payment.dto.response.CreatePaymentResponse;
import com.example.phoneShopping.payment.dto.response.UpdatePaymentResponse;
import com.example.phoneShopping.payment.exception.PaymentException;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class PaymentService 
{
	private final PaymentDao dao;


	@Transactional
	public CreatePaymentResponse CreatePayment(CreatePaymentRequest req)	// CreatePayment 처리 
	{
		createPayment(req);
		return new CreatePaymentResponse(req.getPay_seq());
	}

	public void createPayment(CreatePaymentRequest req)	// CreatePayment method
	{
		// CreatePayment 생성
		CreatePaymentParam param = new CreatePaymentParam(req.getPay_seq(), req.getMember(),
						req.getPay_date(), req.getPay_status());

		Integer result = dao.createPayment(param);
		if (result == 0) 
		{
			throw new PaymentException("결제를 실패했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Transactional(readOnly=true)
	public void findAllPayment()
	{
		System.out.println("findAllPayment동작");
		dao.findAll();
	}
	
	@Transactional(readOnly=true)
	public void findByIdPayment(int pay_seq)
	{
		System.out.println("findByIdPayment동작");
		dao.findById(pay_seq);
	}
	
	@Transactional
	public UpdatePaymentResponse updatePayment(UpdatePaymentRequest req)
	{
		findByIdPayment(req.getPay_seq());
		updatePaymentMethod(req);
		return new UpdatePaymentResponse(req.getPay_seq());
	}	
	
	private void updatePaymentMethod(UpdatePaymentRequest req)
	{
		System.out.println("updatePaymentMethod동작");
		UpdatePaymentParam param = new UpdatePaymentParam(req.getPay_seq(), req.getMember(),
					req.getPay_date(), req.getPay_status());
		
		Integer result = dao.updatePayment(param);
		if(result==0)
		{
			throw new PaymentException("결제 재시작 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		
	@Transactional
	public void deletePayment(int pay_seq)
	{
		System.out.println("deletePayment동작");
		dao.deletePayment(pay_seq);
	}
}
