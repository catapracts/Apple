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

import com.example.phoneShopping.member.dto.request.CreateInfoRequest;
import com.example.phoneShopping.member.dto.request.UpdateInfoRequest;
import com.example.phoneShopping.member.dto.response.CreateInfoResponse;
import com.example.phoneShopping.member.dto.response.UpdateInfoResponse;
import com.example.phoneShopping.member.service.InfoService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Tag(name = "InfoController", description = "Info API")
@RestController
@RequestMapping("/info")
@RequiredArgsConstructor
public class InfoController 
{
	private final InfoService service;
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/create")
	public ResponseEntity<CreateInfoResponse> createInfo(@Valid @RequestBody CreateInfoRequest req)
	{
		System.out.println("Info 정보 생성");
		return ResponseEntity.ok(service.createInfo(req));
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/getAll")
	public void findAllInfo()
	{
		System.out.println("Info 정보 전체 출력");
		service.findAllInfo();
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/getOne")
	public void findByIdInfo(int info_seq)
	{
		System.out.println("Info 정보 1개 출력");
		System.out.println(info_seq);
		service.findByIdInfo(info_seq);
	}
	
	@PreAuthorize("isAuthenticated()")
	@PatchMapping(value = "/update/{info_seq}")
	public ResponseEntity<UpdateInfoResponse> updateInfo(@Valid @RequestBody UpdateInfoRequest req)
	{
		System.out.println("Info 정보 수정");
		return ResponseEntity.ok(service.updateInfo(req));
	}
	
	@PreAuthorize("isAuthenticated()")
	@DeleteMapping(value = "/delete/{info_seq}")
	public void deletInfo(int info_seq)
	{
		System.out.println("Info 정보 제거");
		System.out.println(info_seq);
		service.deleteInfo(info_seq);
	}
}
