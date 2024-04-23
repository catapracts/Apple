package com.example.phoneShopping.member.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.phoneShopping.member.dto.request.CreateCardRequest;
import com.example.phoneShopping.member.dto.request.UpdateCardRequest;
import com.example.phoneShopping.member.dto.response.CreateCardResponse;
import com.example.phoneShopping.member.dto.response.UpdateCardResponse;
import com.example.phoneShopping.member.service.CardService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Tag(name = "CardController", description = "카드 API")
@RestController
@RequestMapping("/card")
@RequiredArgsConstructor
public class CardController 
{
	private final CardService service;
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/create")
	public ResponseEntity<CreateCardResponse> createCard(@Valid @RequestBody CreateCardRequest req)
	{
		System.out.println("Card 정보 생성");
		return ResponseEntity.ok(service.createCard(req));
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/getAll")
	public void findAllCard()
	{
		System.out.println("Card 정보 전체 출력");
		service.findAllCard();
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/getOne")
	public void findByIdCard(int card_seq)
	{
		System.out.println("Card 정보 1개 출력");
		System.out.println(card_seq);
		service.findByIdCard(card_seq);
	}
	
	@PreAuthorize("isAuthenticated()")
	@PatchMapping(value = "/update/{card_seq}")
	public ResponseEntity<UpdateCardResponse> updateCard(@Valid @RequestBody UpdateCardRequest req)
	{
		System.out.println("Card 정보 수정");
		return ResponseEntity.ok(service.updateCard(req));
	}
	
	@PreAuthorize("isAuthenticated()")
	@DeleteMapping(value = "/delete/{card_seq}")
	public void delete(int card_seq)
	{
		System.out.println("Card 정보 제거");
		System.out.println(card_seq);
		service.deleteCard(card_seq);
	}
}
