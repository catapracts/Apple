package com.example.phoneShopping.payment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.phoneShopping.payment.domain.Payment;


@Mapper
@Repository
public interface PaymentDao {
	// payment 작성 (결제)
	Payment createPayment(Payment payment);

	// payment 1개 조회
	Payment findById(int pay_seq);

	// payment 삭제
	Integer deletePayment(int pay_seq);
	
	// "select o from Payment o " +    "where o.member.mem_id = :mem_id " +  "Payment by o.pay_Date desc
	List<Payment> findPayment(String mem_id);
	
	// "select count(o) from Payment o " + "where o.member.mem_id = :mem_id"
	Integer countOrder(@Param("mem_id") String mem_id);
	
}
