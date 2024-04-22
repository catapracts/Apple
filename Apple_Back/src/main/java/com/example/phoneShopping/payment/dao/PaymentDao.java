package com.example.phoneShopping.payment.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.phoneShopping.payment.domain.Payment;
import com.example.phoneShopping.payment.dto.param.CreatePaymentParam;
import com.example.phoneShopping.payment.dto.param.UpdatePaymentParam;

@Mapper
@Repository
public interface PaymentDao {
	// payment 작성 (결제)
	Integer createPayment(CreatePaymentParam param);
	// payment 전체 조회
	Payment findAll();
	// payment 1개 조회
	Payment findById(int pay_seq);
	// payment 수정
	Integer updatePayment(UpdatePaymentParam param);
	// payment 삭제
	Integer deletePayment(int pay_seq);
	
}
