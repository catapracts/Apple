package com.example.phoneShopping.product.controller;

import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.phoneShopping.product.domain.Product;
import com.example.phoneShopping.product.dto.request.CreateProductRequest;
import com.example.phoneShopping.product.dto.request.UpdateProductRequest;
import com.example.phoneShopping.product.dto.response.CreateProductResponse;
import com.example.phoneShopping.product.dto.response.DeleteProductResponse;
import com.example.phoneShopping.product.dto.response.UpdateProductResponse;
import com.example.phoneShopping.product.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/admin/product")
@RequiredArgsConstructor
public class ProductController {

	// DI : 생성자 주입
	private final ProductService service;
	
	// 상품 추가
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/create")
	public ResponseEntity<CreateProductResponse> createProduct (
			@RequestBody CreateProductRequest req) 
	{	
		System.out.println("ProductController createProduct" + new Date());
		
		return ResponseEntity.ok(service.createProduct(req));
	}
	
	// 상품 상세 1개
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/getOne/{prodSeq}")
	public Product findByIdProduct(@PathVariable(value = "prodSeq")String prodSeq) 
	{
		System.out.println("상품 정보 1개 출력");
		System.out.println(prodSeq);
		return service.findByIdProduct(prodSeq);
	}
	
	// 상품 목록
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/getAll")
	public List<Product> findAllProduct() 
	{
		System.out.println("상품 정보 전체 출력");
		return service.findAllProduct();
	}
	
	// 상품 수정
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/update/{prodSeq}")
	public ResponseEntity<UpdateProductResponse> updateProduct (
			@RequestBody UpdateProductRequest req) 
	{
		System.out.println("회원 정보 수정");
		return ResponseEntity.ok(service.updateProduct(req));
	}
	
	// 상품 삭제
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/delete/{prodSeq}")
	public ResponseEntity<DeleteProductResponse> deleteProduct(@PathVariable(value = "prodSeq") String prodSeq) 
	{
		System.out.println("회원 정보 제거");
		System.out.println(prodSeq);
		return ResponseEntity.ok(service.deleteProduct(prodSeq));
	}
	
}
