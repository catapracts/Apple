package com.example.phoneShopping.product.service;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.phoneShopping.product.dao.PlusDao;
import com.example.phoneShopping.product.domain.Plus;
import com.example.phoneShopping.product.dto.param.CreatePlusParam;
import com.example.phoneShopping.product.dto.param.UpdatePlusParam;
import com.example.phoneShopping.product.dto.request.CreatePlusRequest;
import com.example.phoneShopping.product.dto.request.UpdatePlusRequest;
import com.example.phoneShopping.product.dto.response.CreatePlusResponse;
import com.example.phoneShopping.product.dto.response.UpdatePlusResponse;
import com.example.phoneShopping.product.exception.PlusException;

import lombok.RequiredArgsConstructor;



@Service
@Transactional
@RequiredArgsConstructor
public class PlusService 
{
	private final PlusDao dao;
	
	@Transactional
	public CreatePlusResponse createPlus(CreatePlusRequest req)
	{
		createPlusMethod(req);
		return new CreatePlusResponse(req.getPlus_seq());
	}
		
	private void createPlusMethod(CreatePlusRequest req)
	{
		System.out.println("createPlus동작");
		CreatePlusParam param = new CreatePlusParam(req.getPlus_seq(), req.getPrice());
		
		Integer result = dao.createPlus(param);
		
		if(result==0)
		{
			throw new PlusException("Plus 등록 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Transactional(readOnly=true)
	public List<Plus> findAllPlus()
	{
		System.out.println("findAllPlus동작");
		List<Plus> list = dao.findAllPlus();
		
		for(int i = 0; i < dao.findAllPlus().size(); i++)
		{
			System.out.println(dao.findAllPlus().get(i).getPlus_seq());
			System.out.println(dao.findAllPlus().get(i).getPrice());
			System.out.println("\n");
		}
		
		return list;
	}
	
	@Transactional(readOnly=true)
	public Plus findByIdPlus(int plus_seq) 
	{
		System.out.println("findByIdPlus동작");
		dao.findByIdPlus(plus_seq);
		System.out.println(dao.findByIdPlus(plus_seq).getPlus_seq());
		System.out.println(dao.findByIdPlus(plus_seq).getPrice());
		return dao.findByIdPlus(plus_seq);
	}
	
	@Transactional
	public UpdatePlusResponse updatePlus(UpdatePlusRequest req)
	{
		updatePlusMethod(req);		
		return new UpdatePlusResponse(req.getPlus_seq());
	}
	
	private void updatePlusMethod(UpdatePlusRequest req)
	{
		System.out.println("updatePlus동작");
				
		UpdatePlusParam param = new UpdatePlusParam(req.getPlus_seq(), req.getPrice());
		
		Integer result = dao.updatePlus(param);
		
		if(result==0)
		{
			throw new PlusException("Plus 수정 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Transactional
	public void deletePlus(int plus_seq)
	{
		System.out.println("deletePlus동작");
		dao.deletePlus(plus_seq);
	}
}
