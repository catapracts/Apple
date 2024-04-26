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

import com.example.phoneShopping.product.dto.request.CreateHddRequest;
import com.example.phoneShopping.product.dto.request.UpdateHddRequest;
import com.example.phoneShopping.product.dto.response.CreateHddResponse;
import com.example.phoneShopping.product.dto.response.UpdateHddResponse;
import com.example.phoneShopping.product.service.HddService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Tag(name = "HddController", description = "Hdd API")
@RestController
@RequestMapping("/hdd")
@RequiredArgsConstructor
public class HddController 
{
	private final HddService service;
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/create")
	public ResponseEntity<CreateHddResponse> createColor(@Valid @RequestBody CreateHddRequest req)
	{
		System.out.println("Hdd 정보 생성");
		return ResponseEntity.ok(service.createHdd(req));
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/getAll")
	public void findAllHdd()
	{
		System.out.println("Hdd 정보 전체 출력");
		service.findAllHdd();
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/getOne")
	public void findByIdHdd(int hdd_seq)
	{
		System.out.println("Hdd 정보 1개 출력");
		System.out.println(hdd_seq);
		service.findByIdHdd(hdd_seq);
	}
	
	@PreAuthorize("isAuthenticated()")
	@PatchMapping(value = "/update/{hdd_seq}")
	public ResponseEntity<UpdateHddResponse> updateHdd(@Valid @RequestBody UpdateHddRequest req)
	{
		System.out.println("Hdd 정보 수정");
		return ResponseEntity.ok(service.updateHdd(req));
	}
	
	@PreAuthorize("isAuthenticated()")
	@DeleteMapping(value = "/delete/{hdd_seq}")
	public void deleteHdd(int hdd_seq)
	{
		System.out.println("Hdd 정보 제거");
		System.out.println(hdd_seq);
		service.deleteHdd(hdd_seq);
	}
}
