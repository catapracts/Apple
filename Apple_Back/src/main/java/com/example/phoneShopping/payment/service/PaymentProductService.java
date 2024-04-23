package com.example.phoneShopping.payment.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.phoneShopping.payment.dao.PaymentProductDao;
import com.example.phoneShopping.payment.dto.param.CreatePaymentProductParam;
import com.example.phoneShopping.payment.dto.param.UpdatePaymentProductParam;
import com.example.phoneShopping.payment.dto.request.CreatePaymentProductRequest;
import com.example.phoneShopping.payment.dto.request.UpdatePaymentProductRequest;
import com.example.phoneShopping.payment.dto.response.CreatePaymentProductResponse;
import com.example.phoneShopping.payment.dto.response.UpdatePaymentProductResponse;
import com.example.phoneShopping.payment.exception.PaymentProductException;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class PaymentProductService {
	private final PaymentProductDao dao;


	@Transactional
	public CreatePaymentProductResponse createPaymentProduct(CreatePaymentProductRequest req)	// CreatePayment 처리 
	{
		createPaymentProducts(req);
		return new CreatePaymentProductResponse(req.getPayi_seq());
	}

	public void createPaymentProducts(CreatePaymentProductRequest req)	// CreatePayment method
	{
		// CreatePaymentProduct 생성
		CreatePaymentProductParam param = new CreatePaymentProductParam(req.getPayi_seq(), req.getProduct(),
						req.getPayment(), req.getPayi_price(), req.getPayi_count());

		Integer result = dao.createPaymentProduct(param);
		if (result == 0) 
		{
			throw new PaymentProductException("결제 상품 실패했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Transactional(readOnly=true)
	public void findAllPaymentProduct()
	{
		System.out.println("findAllPaymentProduct동작");
		dao.findAll();
	}
	
	@Transactional(readOnly=true)
	public void findByIdPaymentProduct(int payi_seq)
	{
		System.out.println("findByIdPaymentProduct동작");
		dao.findById(payi_seq);
	}
	
	@Transactional
	public UpdatePaymentProductResponse updatePaymentProduct(UpdatePaymentProductRequest req)
	{
		findByIdPaymentProduct(req.getPayi_seq());
		updatePaymentProductMethod(req);
		return new UpdatePaymentProductResponse(req.getPayi_seq());
	}	
	
	private void updatePaymentProductMethod(UpdatePaymentProductRequest req)
	{
		System.out.println("updatePaymentProductMethod동작");
		UpdatePaymentProductParam param = new UpdatePaymentProductParam(req.getPayi_seq(), req.getProduct(),
						req.getPayment(), req.getPayi_price(), req.getPayi_count());
		
		Integer result = dao.updatePaymentProduct(param);
		if(result==0)
		{
			throw new PaymentProductException("결제 상품 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		
	@Transactional
	public void deletePaymentProduct(int payi_seq)
	{
		System.out.println("deletePaymentProduct동작");
		dao.deletePaymentProduct(payi_seq);
	}

}
