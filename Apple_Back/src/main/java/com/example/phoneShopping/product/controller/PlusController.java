package com.example.phoneShopping.product.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.phoneShopping.product.dto.request.CreatePlusRequest;
import com.example.phoneShopping.product.dto.request.UpdatePlusRequest;
import com.example.phoneShopping.product.dto.response.CreatePlusResponse;
import com.example.phoneShopping.product.dto.response.UpdatePlusResponse;
import com.example.phoneShopping.product.service.PlusService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Tag(name = "PlusController", description = "추가 금액 API")
@RestController
@RequestMapping("/plus")
@RequiredArgsConstructor
public class PlusController 
{
	private final PlusService service;
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/create")
	public ResponseEntity<CreatePlusResponse> createPlus(@Valid @RequestBody CreatePlusRequest req)
	{
		System.out.println("Plus 정보 생성");
		return ResponseEntity.ok(service.createPlus(req));
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/getAll")
	public void findAllPlus()
	{
		System.out.println("Plus 정보 전체 출력");
		service.findAllPlus();
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/getOne")
	public void findByIdPlus(int plus_seq)
	{
		System.out.println("Plus 정보 1개 출력");
		System.out.println(plus_seq);
		service.findByIdPlus(plus_seq);
	}
	
	@PreAuthorize("isAuthenticated()")
	@PatchMapping(value = "/update/{plus_seq}")
	public ResponseEntity<UpdatePlusResponse> updatePlus(@Valid @RequestBody UpdatePlusRequest req)
	{
		System.out.println("Plus 정보 수정");
		return ResponseEntity.ok(service.updatePlus(req));
	}
	
	@PreAuthorize("isAuthenticated()")
	@DeleteMapping(value = "/delete/{plus_seq}")
	public void deletePlus(int plus_seq)
	{
		System.out.println("Plus 정보 제거");
		System.out.println(plus_seq);
		service.deletePlus(plus_seq);
	}
}
