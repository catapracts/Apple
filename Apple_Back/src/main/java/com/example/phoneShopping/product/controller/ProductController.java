package com.example.phoneShopping.product.controller;

import java.util.Date;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.phoneShopping.product.dto.request.CreateProductRequest;
import com.example.phoneShopping.product.dto.response.CreateProductResponse;
import com.example.phoneShopping.product.dto.response.ProductResponse;
import com.example.phoneShopping.product.service.ProductService;

public class ProductController {

	// DI : 생성자 주입
	private final ProductService service;
	
	public ProductController(ProductService service) {
		this.service = service;
	}
	
	/* 상품 추가 POST */
	@PostMapping
	public ResponseEntity<CreateProductResponse> createProduct (
			@RequestBody CreateProductRequest req) {	
		System.out.println("ProductController crerateProduct" + new Date());
		
		return ResponseEntity.ok(service.createProduct(req));
	}
	
	/* 상품 상세 GET */
	@GetMapping("/{prod_seq}")
	public ResponseEntity<ProductResponse> getProduct(
			@PathVariable("prod_seq") String prod_seq) {
		
	return ResponseEntity.ok(service.getProduct(prod_seq));
	}
	/* 상품 목록 GET */
	/* 상품 수정 PATCH */
	/* 상품 삭제 DELETE */
	
}
