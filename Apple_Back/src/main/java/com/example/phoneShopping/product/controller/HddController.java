package com.example.phoneShopping.product.controller;

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

import com.example.phoneShopping.product.domain.Hdd;
import com.example.phoneShopping.product.dto.request.CreateHddRequest;
import com.example.phoneShopping.product.dto.request.UpdateHddRequest;
import com.example.phoneShopping.product.dto.response.CreateHddResponse;
import com.example.phoneShopping.product.dto.response.DeleteHddResponse;
import com.example.phoneShopping.product.dto.response.UpdateHddResponse;
import com.example.phoneShopping.product.service.HddService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Tag(name = "HddController", description = "Hdd API")
@RestController
@RequestMapping("/admin/hdd")
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
	public List<Hdd> findAllHdd()
	{
		System.out.println("Hdd 정보 전체 출력");
		return service.findAllHdd();
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/getOne/{hddSeq}")
	public Hdd findByIdHdd(@PathVariable(value = "hddSeq") int hddSeq)
	{
		System.out.println("Hdd 정보 1개 출력");
		System.out.println(hddSeq);
		return service.findByIdHdd(hddSeq);
	}
	
	@PreAuthorize("isAuthenticated()")
	@PatchMapping("/update/{hddSeq}")
	public ResponseEntity<UpdateHddResponse> updateHdd(@Valid @RequestBody UpdateHddRequest req)
	{
		System.out.println("Hdd 정보 수정");
		return ResponseEntity.ok(service.updateHdd(req));
	}
	
	@PreAuthorize("isAuthenticated()")
	@DeleteMapping("/delete/{hddSeq}")
	public ResponseEntity<DeleteHddResponse> deleteHdd(@PathVariable(value = "hddSeq") int hddSeq)
	{
		System.out.println("Hdd 정보 제거");
		System.out.println(hddSeq);
		return ResponseEntity.ok(service.deleteHdd(hddSeq));
	}
}
