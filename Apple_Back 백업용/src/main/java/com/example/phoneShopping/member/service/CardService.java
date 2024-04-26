package com.example.phoneShopping.member.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.phoneShopping.member.dao.CardDao;
import com.example.phoneShopping.member.dto.param.CreateCardParam;
import com.example.phoneShopping.member.dto.param.UpdateCardParam;
import com.example.phoneShopping.member.dto.request.CreateCardRequest;
import com.example.phoneShopping.member.dto.request.UpdateCardRequest;
import com.example.phoneShopping.member.dto.response.CreateCardResponse;
import com.example.phoneShopping.member.dto.response.UpdateCardResponse;
import com.example.phoneShopping.member.exception.CardException;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CardService 
{
	private final CardDao dao;
	
	@Transactional
	public CreateCardResponse createCard(CreateCardRequest req)
	{
		createCardMethod(req);
		return new CreateCardResponse(req.getCard_seq());
	}
		
	private void createCardMethod(CreateCardRequest req)
	{
		System.out.println("createAddress동작");
		CreateCardParam param = new CreateCardParam(req);
		
		Integer result = dao.createCard(param);
		if(result==0)
		{
			throw new CardException("카드 등록 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Transactional(readOnly=true)
	public void findAllCard()
	{
		System.out.println("findAllCard동작");
		dao.findAllCard();	
	}
	
	@Transactional(readOnly=true)
	public void findByIdCard(int card_seq) 
	{
		System.out.println("findByIdCard동작");
		dao.findByIdCard(card_seq);
	}
	
	@Transactional
	public UpdateCardResponse updateCard(UpdateCardRequest req)
	{
		findByIdCard(req.getCard_seq());
		updateCardMethod(req);
		return new UpdateCardResponse(req.getCard_seq());
	}
	
	private void updateCardMethod(UpdateCardRequest req)
	{
		System.out.println("updateCard동작");
				
		UpdateCardParam param = new UpdateCardParam(req.getCard_comp(), req.getCard_num(), req.getCard_date(), req.getCard_cvc());
		
		Integer result = dao.updateCard(param);
		if(result==0)
		{
			throw new CardException("카드 수정 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Transactional
	public void deleteCard(int card_seq)
	{
		System.out.println("deleteCard동작");
		dao.deleteCard(card_seq);
	}
}
