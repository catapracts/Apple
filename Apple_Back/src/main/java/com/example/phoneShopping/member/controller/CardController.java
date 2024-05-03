package com.example.phoneShopping.member.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.phoneShopping.member.domain.Card;
import com.example.phoneShopping.member.dto.request.CreateCardRequest;
import com.example.phoneShopping.member.dto.request.UpdateCardRequest;
import com.example.phoneShopping.member.dto.response.CreateCardResponse;
import com.example.phoneShopping.member.dto.response.DeleteCardResponse;
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
	public ResponseEntity<CreateCardResponse> createCard(@RequestBody CreateCardRequest req)
	{
		System.out.println("Card 정보 생성");
		return ResponseEntity.ok(service.createCard(req));
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/getAll")
	public List<Card> findAllCard()
	{
		System.out.println("Card 정보 전체 출력");
		return service.findAllCard();
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/{cardSeq}")
	public Card findByIdCard(@PathVariable(value = "cardSeq") int cardSeq)
	{
		System.out.println("Card 정보 1개 출력");
		System.out.println(cardSeq);
		return service.findByIdCard(cardSeq);
	}
	
	@PreAuthorize("isAuthenticated()")
	@PatchMapping("/{cardSeq}")
	public ResponseEntity<UpdateCardResponse> updateCard(@RequestBody UpdateCardRequest req)
	{
		System.out.println("Card 정보 수정");
		return ResponseEntity.ok(service.updateCard(req));
	}
	
	@PreAuthorize("isAuthenticated()")
	@DeleteMapping("/{cardSeq}")
	public ResponseEntity<DeleteCardResponse> delete(@PathVariable(value = "cardSeq") int cardSeq)
	{
		System.out.println("Card 정보 제거");
		System.out.println(cardSeq);
		return ResponseEntity.ok(service.deleteCard(cardSeq));
	}
}
