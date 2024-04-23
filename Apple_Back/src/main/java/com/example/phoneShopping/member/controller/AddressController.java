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

import com.example.phoneShopping.member.dto.request.CreateAddressRequest;
import com.example.phoneShopping.member.dto.request.UpdateAddressRequest;
import com.example.phoneShopping.member.dto.response.CreateAddressResponse;
import com.example.phoneShopping.member.dto.response.UpdateAddressResponse;
import com.example.phoneShopping.member.service.AddressService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Tag(name = "AddressController", description = "주소 API")
@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController 
{
	private final AddressService service;
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/create")
	public ResponseEntity<CreateAddressResponse> createAddress(@Valid @RequestBody CreateAddressRequest req)
	{
		System.out.println("Address 정보 생성");
		return ResponseEntity.ok(service.createAddress(req));
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/getAll")
	public void findAllAddress()
	{
		System.out.println("Address 정보 전체 출력");
		service.findAllAddress();
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/getOne")
	public void findByIdAddress(int addr_seq)
	{
		System.out.println("Address 정보 1개 출력");
		System.out.println(addr_seq);
		service.findByIdAddress(addr_seq);
	}
	
	@PreAuthorize("isAuthenticated()")
	@PatchMapping(value = "/update/{addr_seq}")
	public ResponseEntity<UpdateAddressResponse> updateAddress(@Valid @RequestBody UpdateAddressRequest req)
	{
		System.out.println("Address 정보 수정");
		return ResponseEntity.ok(service.updateAddress(req));
	}
	
	@PreAuthorize("isAuthenticated()")
	@DeleteMapping(value = "/delete/{addr_seq}")
	public void delete(int addr_seq)
	{
		System.out.println("Address 정보 제거");
		System.out.println(addr_seq);
		service.deleteAddress(addr_seq);
	}
}
