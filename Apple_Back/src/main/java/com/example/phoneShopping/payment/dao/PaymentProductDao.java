package com.example.phoneShopping.payment.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.phoneShopping.payment.domain.PaymentProduct;
import com.example.phoneShopping.payment.dto.param.CreatePaymentProductParam;
import com.example.phoneShopping.payment.dto.param.UpdatePaymentProductParam;

@Mapper
@Repository
public interface PaymentProductDao {
	// payment 작성 (결제)
	Integer createPaymentProduct(CreatePaymentProductParam param);
	// payment 전체 조회
	PaymentProduct findAll();
	// payment 1개 조회
	PaymentProduct findById(int payi_seq);
	// payment 수정
	Integer updatePaymentProduct(UpdatePaymentProductParam param);
	// payment 삭제
	Integer deletePaymentProduct(int payi_seq);

}
