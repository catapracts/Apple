package com.example.phoneShopping.product.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.phoneShopping.product.dao.ColorDao;
import com.example.phoneShopping.product.domain.Color;
import com.example.phoneShopping.product.dto.param.CreateColorParam;
import com.example.phoneShopping.product.dto.param.UpdateColorParam;
import com.example.phoneShopping.product.dto.request.CreateColorRequest;
import com.example.phoneShopping.product.dto.request.UpdateColorRequest;
import com.example.phoneShopping.product.dto.response.CreateColorResponse;
import com.example.phoneShopping.product.dto.response.UpdateColorResponse;
import com.example.phoneShopping.product.exception.ColorException;

import lombok.RequiredArgsConstructor;



@Service
@Transactional
@RequiredArgsConstructor
public class ColorService 
{
	private final ColorDao dao;
	
	@Transactional
	public CreateColorResponse createColor(CreateColorRequest req)
	{
		createColorMethod(req);
		return new CreateColorResponse(req.getColor_seq());
	}
		
	private void createColorMethod(CreateColorRequest req)
	{
		System.out.println("createColor동작");
		CreateColorParam param = new CreateColorParam(req.getColor_seq(), req.getColor());
		
		Integer result = dao.createColor(param);
		
		if(result==0)
		{
			throw new ColorException("Color 등록 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Transactional(readOnly=true)
	public void findAllColor()
	{
		System.out.println("findAllColor동작");
		dao.findAllColor();
		
		for(int i = 0; i < dao.findAllColor().size(); i++)
		{
			System.out.println(dao.findAllColor().get(i).getColor_seq());
			System.out.println(dao.findAllColor().get(i).getColor());
			System.out.println("\n");
		}
	}
	
	@Transactional(readOnly=true)
	public Color findByIdColor(int color_seq) 
	{
		System.out.println("findByIdColor동작");
		dao.findByIdColor(color_seq);
		System.out.println(dao.findByIdColor(color_seq).getColor_seq());
		System.out.println(dao.findByIdColor(color_seq).getColor());
		return dao.findByIdColor(color_seq);
	}
	
	@Transactional
	public UpdateColorResponse updateColor(UpdateColorRequest req)
	{
		updateColorMethod(req);		
		return new UpdateColorResponse(req.getColor_seq());
	}
	
	private void updateColorMethod(UpdateColorRequest req)
	{
		System.out.println("updateColor동작");
				
		UpdateColorParam param = new UpdateColorParam(req.getColor_seq(), req.getColor());
		
		Integer result = dao.updateColor(param);
		
		if(result==0)
		{
			throw new ColorException("Color 수정 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Transactional
	public void deleteColor(int color_seq)
	{
		System.out.println("deleteColor동작");
		dao.deleteColor(color_seq);
	}
}
