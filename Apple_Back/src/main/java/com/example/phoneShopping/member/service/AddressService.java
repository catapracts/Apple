package com.example.phoneShopping.member.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.phoneShopping.member.dao.AddressDao;
import com.example.phoneShopping.member.domain.Address;
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
	public List<Address> findAllAddress()
	{
		System.out.println("findAllAddress동작");
		List<Address> list = addressDao.findAllAddress();
		
		for(int i = 0; i < addressDao.findAllAddress().size(); i++)
		{
			System.out.println(addressDao.findAllAddress().get(i).getAddr_seq());
			System.out.println(addressDao.findAllAddress().get(i).getAddr_zip());
			System.out.println(addressDao.findAllAddress().get(i).getAddr_detail());
			System.out.println("\n");
		}
		
		return list;
	}
	
	@Transactional(readOnly=true)
	public Address findByIdAddress(int addr_seq) 
	{
		System.out.println("findByIdAddress동작");
		addressDao.findByIdAddress(addr_seq);
		System.out.println(addressDao.findByIdAddress(addr_seq).getAddr_seq());
		System.out.println(addressDao.findByIdAddress(addr_seq).getAddr_zip());
		System.out.println(addressDao.findByIdAddress(addr_seq).getAddr_detail());
		Address address = new Address(addressDao.findByIdAddress(addr_seq).getAddr_seq(), addressDao.findByIdAddress(addr_seq).getAddr_zip(), addressDao.findByIdAddress(addr_seq).getAddr_detail());
		return address;
	}
	
	@Transactional
	public UpdateAddressResponse updateAddress(UpdateAddressRequest req)
	{
		Address addr = findByIdAddress(req.getAddr_seq());
		if(req.getAddr_seq() == addr.getAddr_seq())
		{
			updateAddressMethod(req);
		}
		
		return new UpdateAddressResponse(req.getAddr_seq());
	}
	
	private void updateAddressMethod(UpdateAddressRequest req)
	{
		System.out.println("updateAddress동작");
				
		UpdateAddressParam param = new UpdateAddressParam(req.getAddr_seq() ,req.getAddr_zip(), req.getAddr_detail());
		
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
