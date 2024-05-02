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

import com.example.phoneShopping.member.domain.Address;
import com.example.phoneShopping.member.dto.request.CreateAddressRequest;
import com.example.phoneShopping.member.dto.request.UpdateAddressRequest;
import com.example.phoneShopping.member.dto.response.CreateAddressResponse;
import com.example.phoneShopping.member.dto.response.DeleteAddressResponse;
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
	public List<Address> findAllAddress()
	{
		System.out.println("Address 정보 전체 출력");
		return service.findAllAddress();
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/{addrSeq}")
	public Address findByIdAddress(@PathVariable(value = "addrSeq") int addrSeq)
	{
		System.out.println("Address 정보 1개 출력");
		System.out.println(addrSeq);
		return service.findByIdAddress(addrSeq);
	}
	
	@PreAuthorize("isAuthenticated()")
	@PatchMapping("/{addrSeq}")
	public ResponseEntity<UpdateAddressResponse> updateAddress(@Valid @RequestBody UpdateAddressRequest req)
	{
		System.out.println("Address 정보 수정");
		return ResponseEntity.ok(service.updateAddress(req));
	}
	
	@PreAuthorize("isAuthenticated()")
	@DeleteMapping("/{addrSeq}")
	public ResponseEntity<DeleteAddressResponse> delete(@PathVariable(value = "addrSeq") int addrSeq)
	{
		System.out.println("Address 정보 제거");
		System.out.println(addrSeq);
		return ResponseEntity.ok(service.deleteAddress(addrSeq));
	}
}
