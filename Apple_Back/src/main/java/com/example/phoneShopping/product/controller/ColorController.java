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

import com.example.phoneShopping.product.domain.Color;
import com.example.phoneShopping.product.dto.request.CreateColorRequest;
import com.example.phoneShopping.product.dto.request.UpdateColorRequest;
import com.example.phoneShopping.product.dto.response.CreateColorResponse;
import com.example.phoneShopping.product.dto.response.DeleteColorResponse;
import com.example.phoneShopping.product.dto.response.UpdateColorResponse;
import com.example.phoneShopping.product.service.ColorService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Tag(name = "ColorController", description = "Color API")
@RestController
@RequestMapping("/color")
@RequiredArgsConstructor
public class ColorController 
{
	private final ColorService service;
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/create")
	public ResponseEntity<CreateColorResponse> createColor(@Valid @RequestBody CreateColorRequest req)
	{
		System.out.println("Color 정보 생성");
		return ResponseEntity.ok(service.createColor(req));
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/getAll")
	public List<Color> findAllColor()
	{
		System.out.println("Color 정보 전체 출력");
		return service.findAllColor();
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/{colorSeq}")
	public Color findByIdColor(@PathVariable(value = "colorSeq") int colorSeq)
	{
		System.out.println("color 정보 1개 출력");
		System.out.println(colorSeq);
		return service.findByIdColor(colorSeq);
	}
	
	@PreAuthorize("isAuthenticated()")
	@PatchMapping("/{colorSeq}")
	public ResponseEntity<UpdateColorResponse> updateColor(@Valid @RequestBody UpdateColorRequest req)
	{
		System.out.println("Color 정보 수정");
		return ResponseEntity.ok(service.updateColor(req));
	}
	
	@PreAuthorize("isAuthenticated()")
	@DeleteMapping("/{colorSeq}")
	public ResponseEntity<DeleteColorResponse> deleteColor(@PathVariable(value = "colorSeq") int colorSeq)
	{
		System.out.println("Color 정보 제거");
		System.out.println(colorSeq);
		return ResponseEntity.ok(service.deleteColor(colorSeq));
	}
}
