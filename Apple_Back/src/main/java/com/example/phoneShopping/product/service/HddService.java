package com.example.phoneShopping.product.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.phoneShopping.product.dao.HddDao;
import com.example.phoneShopping.product.domain.Hdd;
import com.example.phoneShopping.product.dto.param.CreateHddParam;
import com.example.phoneShopping.product.dto.param.UpdateHddParam;
import com.example.phoneShopping.product.dto.request.CreateHddRequest;
import com.example.phoneShopping.product.dto.request.UpdateHddRequest;
import com.example.phoneShopping.product.dto.response.CreateHddResponse;
import com.example.phoneShopping.product.dto.response.UpdateHddResponse;
import com.example.phoneShopping.product.exception.HddException;

import lombok.RequiredArgsConstructor;



@Service
@Transactional
@RequiredArgsConstructor
public class HddService 
{
	private final HddDao dao;
	
	@Transactional
	public CreateHddResponse createHdd(CreateHddRequest req)
	{
		createHddMethod(req);
		return new CreateHddResponse(req.getHdd_seq());
	}
		
	private void createHddMethod(CreateHddRequest req)
	{
		System.out.println("createHdd동작");
		CreateHddParam param = new CreateHddParam(req.getHdd_seq(), req.getCapacity(), req.getPlus_seq());
		
		Integer result = dao.createHdd(param);
		
		if(result==0)
		{
			throw new HddException("Hdd 등록 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Transactional(readOnly=true)
	public void findAllHdd()
	{
		System.out.println("findAllHdd동작");
		dao.findAllHdd();
		
		for(int i = 0; i < dao.findAllHdd().size(); i++)
		{
			System.out.println(dao.findAllHdd().get(i).getHdd_seq());
			System.out.println(dao.findAllHdd().get(i).getCapacity());
			System.out.println(dao.findAllHdd().get(i).getPlus_seq());
			System.out.println("\n");
		}
	}
	
	@Transactional(readOnly=true)
	public Hdd findByIdHdd(int hdd_seq) 
	{
		System.out.println("findByIdHdd동작");
		dao.findByIdHdd(hdd_seq);
		System.out.println(dao.findByIdHdd(hdd_seq).getHdd_seq());
		System.out.println(dao.findByIdHdd(hdd_seq).getCapacity());
		System.out.println(dao.findByIdHdd(hdd_seq).getPlus_seq());
		return dao.findByIdHdd(hdd_seq);
	}
	
	@Transactional
	public UpdateHddResponse updateHdd(UpdateHddRequest req)
	{
		updateHddMethod(req);		
		return new UpdateHddResponse(req.getHdd_seq());
	}
	
	private void updateHddMethod(UpdateHddRequest req)
	{
		System.out.println("updateHdd동작");
				
		UpdateHddParam param = new UpdateHddParam(req.getHdd_seq(), req.getCapacity(), req.getPlus_seq());
		
		Integer result = dao.updateHdd(param);
		
		if(result==0)
		{
			throw new HddException("Color 수정 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Transactional
	public void deleteHdd(int hdd_seq)
	{
		System.out.println("deleteHdd동작");
		dao.deleteHdd(hdd_seq);
	}
}
