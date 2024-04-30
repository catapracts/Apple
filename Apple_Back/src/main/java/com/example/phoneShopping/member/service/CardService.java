package com.example.phoneShopping.member.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.phoneShopping.member.dao.CardDao;
import com.example.phoneShopping.member.domain.Card;
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
	public List<Card> findAllCard()
	{
		System.out.println("findAllCard동작");
		List<Card> list = dao.findAllCard();
		
		for(int i = 0; i<dao.findAllCard().size(); i++)
		{
			System.out.println(dao.findAllCard().get(i).getCard_seq());
			System.out.println(dao.findAllCard().get(i).getCard_comp());
			System.out.println(dao.findAllCard().get(i).getCard_num());
			System.out.println(dao.findAllCard().get(i).getCard_date());
			System.out.println(dao.findAllCard().get(i).getCard_cvc());
		}
		
		return list;
	}
	
	@Transactional(readOnly=true)
	public Card findByIdCard(int card_seq) 
	{
		System.out.println("findByIdCard동작");
		dao.findByIdCard(card_seq);
		System.out.println(dao.findByIdCard(card_seq).getCard_seq());
		System.out.println(dao.findByIdCard(card_seq).getCard_comp());
		System.out.println(dao.findByIdCard(card_seq).getCard_num());
		System.out.println(dao.findByIdCard(card_seq).getCard_date());
		System.out.println(dao.findByIdCard(card_seq).getCard_cvc());
		Card card = new Card(dao.findByIdCard(card_seq).getCard_seq(), dao.findByIdCard(card_seq).getCard_comp(), dao.findByIdCard(card_seq).getCard_num(), dao.findByIdCard(card_seq).getCard_date(), dao.findByIdCard(card_seq).getCard_cvc());
		return card;
	}
	
	@Transactional
	public UpdateCardResponse updateCard(UpdateCardRequest req)
	{
		Card card = findByIdCard(req.getCard_seq());
		if(req.getCard_seq() == card.getCard_seq())
		{
			updateCardMethod(req);
		}
		return new UpdateCardResponse(req.getCard_seq());
	}
	
	private void updateCardMethod(UpdateCardRequest req)
	{
		System.out.println("updateCard동작");
				
		UpdateCardParam param = new UpdateCardParam(req.getCard_seq(), req.getCard_comp(), req.getCard_num(), req.getCard_date(), req.getCard_cvc());
		
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
