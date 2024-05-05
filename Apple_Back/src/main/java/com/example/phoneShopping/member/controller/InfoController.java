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

import com.example.phoneShopping.member.domain.Info;
import com.example.phoneShopping.member.dto.request.CreateInfoRequest;
import com.example.phoneShopping.member.dto.request.UpdateInfoRequest;
import com.example.phoneShopping.member.dto.response.CreateInfoResponse;
import com.example.phoneShopping.member.dto.response.DeleteInfoResponse;
import com.example.phoneShopping.member.dto.response.UpdateInfoResponse;
import com.example.phoneShopping.member.service.InfoService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Tag(name = "InfoController", description = "회원 개인정보 API")
@RestController
@RequestMapping("/info")
@RequiredArgsConstructor
public class InfoController 
{
	private final InfoService service;
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/create")
	public ResponseEntity<CreateInfoResponse> createInfo(@RequestBody CreateInfoRequest req)
	{
		System.out.println("Info 정보 생성");
		return ResponseEntity.ok(service.createInfo(req));
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/getAll")
	public List<Info> findAllInfo()
	{
		System.out.println("Info 정보 전체 출력");
		return service.findAllInfo();
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/{infoSeq}")
	public Info findByIdInfo(@PathVariable(value = "infoSeq") int infoSeq)
	{
		System.out.println("Info 정보 1개 출력");
		System.out.println(infoSeq);
		return service.findByIdInfo(infoSeq);
	}
	
	@PreAuthorize("isAuthenticated()")
	@PatchMapping("/{infoSeq}")
	public ResponseEntity<UpdateInfoResponse> updateInfo(@RequestBody UpdateInfoRequest req)
	{
		System.out.println("Info 정보 수정");
		return ResponseEntity.ok(service.updateInfo(req));
	}
	
	@PreAuthorize("isAuthenticated()")
	@DeleteMapping("/{infoSeq}")
	public ResponseEntity<DeleteInfoResponse> deletInfo(@PathVariable(value = "infoSeq") int infoSeq)
	{
		System.out.println("Info 정보 제거");
		System.out.println(infoSeq);
		return ResponseEntity.ok(service.deleteInfo(infoSeq));
	}
}
