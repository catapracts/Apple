package com.example.phoneShopping.payment.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.phoneShopping.member.dao.MemberDao;
import com.example.phoneShopping.member.domain.Member;
import com.example.phoneShopping.payment.dao.PaymentDao;
import com.example.phoneShopping.payment.domain.Payment;
import com.example.phoneShopping.payment.domain.PaymentProduct;

import com.example.phoneShopping.payment.dto.param.PaymentDto;
import com.example.phoneShopping.payment.dto.param.PaymentHistDto;


import com.example.phoneShopping.product.dao.ProductDao;
import com.example.phoneShopping.product.domain.Product;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class PaymentService 
{
	private final PaymentDao pay_dao;
	private final ProductDao prod_dao;
	private final MemberDao mem_dao;

	
    public String order(PaymentDto paymentDto, String mem_id)
    {

        Product product = prod_dao.findByIdProduct(paymentDto.getProd_seq());
        Member member = mem_dao.findByIdMember(mem_id);

        List<PaymentProduct> paymentProductList = new ArrayList<>();
        PaymentProduct paymentProduct = PaymentProduct.createPaymentProduct(product, paymentDto.getCount());
        paymentProductList.add(paymentProduct);
        Payment payment = Payment.createPayment(member, paymentProductList);
        pay_dao.createPayment(payment);

        return payment.getMember().getMemId();
    }

    @Transactional(readOnly = true)
    public List<PaymentHistDto> getPaymentList(String mem_id) 
    {
    	List<Payment> payments = pay_dao.findPayment(mem_id);
        int totalCount = pay_dao.countOrder(mem_id);

        List<PaymentHistDto> paymentHistDtos = new ArrayList<>();

        for (Payment payment : payments) 
        {
        	PaymentHistDto paymentHistDto = new PaymentHistDto(payment);
        	List<PaymentProduct> paymentProductList = payment.getPaymentProducts();

        	paymentHistDtos.add(paymentHistDto);
        }

        return paymentHistDtos;
    }
    

    @Transactional(readOnly = true)
    public boolean validateOrder(int pay_seq, String mem_id)
    {
        Member curMember = mem_dao.findByIdMember(mem_id);
        Payment payment = pay_dao.findById(pay_seq);
        Member savedMember = payment.getMember();

        if(curMember != savedMember)
        {
            return false;
        }

        return true;
    }

    public void cancelOrder(int pay_seq)
    {
    	Payment payment = pay_dao.findById(pay_seq);
        payment.cancelPayment();
    }

    
    // 장바구니에서 값을 읽어와서 주문 테이블에 저장하는 메소드 
    public int Payments(List<PaymentDto> paymentDtoList, String mem_id)
    {

        Member member = mem_dao.findByIdMember(mem_id);
        
        // PaymentProductList 선언 : Payment : PaymentProduct 
        List<PaymentProduct> paymentProductList = new ArrayList<>();

        for (PaymentDto paymentDto : paymentDtoList) 
        {
        	Product product = prod_dao.findByIdProduct(paymentDto.getProd_seq());

        	PaymentProduct paymentProduct = PaymentProduct.createPaymentProduct(product, paymentDto.getCount());
        	paymentProductList.add(paymentProduct);
        }

        Payment payment = Payment.createPayment(member, paymentProductList);
        pay_dao.createPayment(payment);

        return payment.getPay_seq();
    }
    
	
	@Transactional(readOnly=true)
	public void findByIdPayment(int pay_seq)
	{
		System.out.println("findByIdPayment동작");
		pay_dao.findById(pay_seq);
	}

}
