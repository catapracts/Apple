package com.example.phoneShopping.cart.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.phoneShopping.cart.dto.param.CartProductDto;
import com.example.phoneShopping.cart.service.CartService;


import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Tag(name = "CartController", description = "Cart API")
@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController 
{
	private final CartService service;
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping(value = "/create")
	public @ResponseBody ResponseEntity createCartCartProduct(
			@Valid @RequestBody CartProductDto req, String mem_id)	// 카트 생성 + 장바구니에 상품 담기
	{
		System.out.println("Cart 정보 생성 or 불러오기");
		
		String id = service.findMemberId(mem_id);
		
		int cartp_id;
		try
		{
			cartp_id = service.addCart(req, id);
		}
		
		catch(Exception e)
		{
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Integer>(cartp_id, HttpStatus.OK);
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/getAll")
	public void findAllCartProduct(String mem_id)	// 장바구니에 담긴 상품 전체 출력
	{
		System.out.println("Cart Product 정보 전체 출력");
		String memberId = service.findMemberId(mem_id);
		service.getCartList(memberId);
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/getOne/{cartp_seq}")
	public void findByIdCartProduct(int cartp_seq)	// 장바구니에 담긴 상품 1개 출력
	{
		System.out.println("Cart Product 정보 1개 출력");
		System.out.println(cartp_seq);
		service.findCartProductId(cartp_seq);		
	}
	
	@PreAuthorize("isAuthenticated()")
	@PatchMapping(value = "/update/{cartp_seq}")
	public @ResponseBody ResponseEntity updateCartProduct(@PathVariable("cartp_seq") int cartp_seq, int cnt, String mem_id)	// 장바구니에 담긴 상품 갯수 수정
	{
		System.out.println("Cart Product 갯수 수정");
		
		if(cnt <= 0)
		{
			return new ResponseEntity<String>("최소 1개 이상 담아주세요", HttpStatus.BAD_REQUEST);
		}
		
		else if(!service.validateCartProduct(cartp_seq, mem_id))
		{
			return new ResponseEntity<String>("수정 권한이 없습니다.", HttpStatus.FORBIDDEN);
		}
		
		service.updateCartProductCount(cartp_seq, cnt);
		
		return new ResponseEntity<Integer>(cartp_seq, HttpStatus.OK);
	}
	
	@PreAuthorize("isAuthenticated()")
	@DeleteMapping(value = "/delete/{cartp_seq}")
	public @ResponseBody ResponseEntity deleteCartProduct(@PathVariable("cartp_seq") int cartp_seq, String mem_id)		// 장바구니에 담긴 상품 삭제
	{
		System.out.println("Cart Product 정보 제거");
		System.out.println(cartp_seq);
		
		if(!service.validateCartProduct(cartp_seq, mem_id))
		{
			return new ResponseEntity<String>("삭제 권한이 없습니다.", HttpStatus.FORBIDDEN);
		}
				
		service.deleteCartProduct(cartp_seq);
		return new ResponseEntity<Integer>(cartp_seq, HttpStatus.OK);
				
	}
}
