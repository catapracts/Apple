package com.example.phoneShopping.member.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.phoneShopping.member.dao.AddressDao;
import com.example.phoneShopping.member.dao.InfoDao;
import com.example.phoneShopping.member.domain.Address;
import com.example.phoneShopping.member.domain.Info;
import com.example.phoneShopping.member.dto.param.CreateInfoParam;
import com.example.phoneShopping.member.dto.param.UpdateInfoParam;
import com.example.phoneShopping.member.dto.request.CreateInfoRequest;
import com.example.phoneShopping.member.dto.request.UpdateInfoRequest;
import com.example.phoneShopping.member.dto.response.CreateInfoResponse;
import com.example.phoneShopping.member.dto.response.UpdateInfoResponse;
import com.example.phoneShopping.member.exception.InfoException;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class InfoService 
{
	private final InfoDao dao;
	private final AddressDao a_dao;
	
	@Transactional
	public CreateInfoResponse createInfo(CreateInfoRequest req)
	{
		createInfoMethod(req);
		return new CreateInfoResponse(req.getInfo_seq());
	}
		
	private void createInfoMethod(CreateInfoRequest req)
	{
		System.out.println("createAddress동작");
		System.out.println(req.getInfo_seq());
		System.out.println(req.getInfo_name());
		System.out.println(req.getInfo_birth());
		System.out.println(req.getInfo_gender());
		System.out.println(req.getInfo_phone());
		
		System.out.println("\n\n");
		CreateInfoParam param = new CreateInfoParam(req);

				
		
		Integer result = dao.createInfo(param);
		if(result==0)
		{
			throw new InfoException("카드 등록 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Transactional(readOnly=true)
	public List<Info> findAllInfo()
	{
		System.out.println("findAllInfo동작");
		List<Info> list = dao.findAllInfo();
		for(int i = 0; i < dao.findAllInfo().size(); i++)
		{
			System.out.println(dao.findAllInfo().get(i).getInfo_seq());
			System.out.println(dao.findAllInfo().get(i).getInfo_name());
			System.out.println(dao.findAllInfo().get(i).getInfo_gender());
			System.out.println(dao.findAllInfo().get(i).getInfo_birth());
			System.out.println(dao.findAllInfo().get(i).getInfo_phone());
			System.out.println("\n");
		}
		
		return list;
	}
	
	@Transactional(readOnly=true)
	public void findByIdInfo(int info_seq) 
	{
		System.out.println("findByIdInfo동작");
		dao.findByIdInfo(info_seq);
		System.out.println(dao.findByIdInfo(info_seq).getInfo_seq());
		System.out.println(dao.findByIdInfo(info_seq).getInfo_name());
		System.out.println(dao.findByIdInfo(info_seq).getInfo_gender());
		System.out.println(dao.findByIdInfo(info_seq).getInfo_birth());
		System.out.println(dao.findByIdInfo(info_seq).getInfo_phone());
	}
	
	@Transactional
	public UpdateInfoResponse updateInfo(UpdateInfoRequest req)
	{
		findByIdInfo(req.getInfo_seq());
		updateInfoMethod(req);
		return new UpdateInfoResponse(req.getInfo_seq());
	}
	
	private void updateInfoMethod(UpdateInfoRequest req)
	{
		System.out.println("updateInfo동작");
				
		UpdateInfoParam param = new UpdateInfoParam(req.getInfo_seq(), req.getInfo_name(), req.getInfo_birth(), req.getInfo_gender(), req.getInfo_phone());
		
		Integer result = dao.updateInfo(param);
		
		if(result==0)
		{
			throw new InfoException("Info 수정 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Transactional
	public void deleteInfo(int info_seq)
	{
		System.out.println("deleteInfo동작");
		dao.deleteInfo(info_seq);
	}	
}
