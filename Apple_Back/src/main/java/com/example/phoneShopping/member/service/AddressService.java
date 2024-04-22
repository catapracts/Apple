package com.example.phoneShopping.member.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.phoneShopping.member.dao.AddressDao;
import com.example.phoneShopping.member.dto.param.CreateAddressParam;
import com.example.phoneShopping.member.dto.param.UpdateAddressParam;
import com.example.phoneShopping.member.dto.request.CreateAddressRequest;
import com.example.phoneShopping.member.dto.request.UpdateAddressRequest;
import com.example.phoneShopping.member.dto.response.CreateAddressResponse;
import com.example.phoneShopping.member.dto.response.UpdateAddressResponse;
import com.example.phoneShopping.member.exception.AddressException;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class AddressService 
{
	private final AddressDao addressDao;
	
	@Transactional
	public CreateAddressResponse createAddress(CreateAddressRequest req)
	{
		createAddressMethod(req);
		return new CreateAddressResponse(req.getAddr_seq());
	}
		
	private void createAddressMethod(CreateAddressRequest req)
	{
		System.out.println("createAddress동작");
		CreateAddressParam param = new CreateAddressParam(req);
		
		Integer result = addressDao.createAddress(param);
		if(result==0)
		{
			throw new AddressException("카드 등록 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Transactional(readOnly=true)
	public void findAllAddress()
	{
		System.out.println("findAllAddress동작");
		addressDao.findAllAddress();	
	}
	
	@Transactional(readOnly=true)
	public void findByIdAddress(int addr_seq) 
	{
		System.out.println("findByIdAddress동작");
		addressDao.findByIdAddress(addr_seq);
	}
	
	@Transactional
	public UpdateAddressResponse updateAddress(UpdateAddressRequest req)
	{
		findByIdAddress(req.getAddr_seq());
		updateAddressMethod(req);
		return new UpdateAddressResponse(req.getAddr_seq());
	}
	
	private void updateAddressMethod(UpdateAddressRequest req)
	{
		System.out.println("updateAddress동작");
				
		UpdateAddressParam param = new UpdateAddressParam(req.getAddr_zip(), req.getAddr_detail());
		
		Integer result = addressDao.updateAddress(param);
		if(result==0)
		{
			throw new AddressException("카드 수정 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Transactional
	public void deleteAddress(int addr_seq)
	{
		System.out.println("deleteAddress동작");
		addressDao.deleteAddress(addr_seq);
	}
}
