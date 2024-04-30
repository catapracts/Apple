package com.example.phoneShopping.cart.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.phoneShopping.cart.dto.request.CreateCartProductRequest;
import com.example.phoneShopping.cart.dto.request.CreateCartRequest;
import com.example.phoneShopping.cart.dto.request.UpdateCartProductRequest;
import com.example.phoneShopping.cart.dto.request.UpdateCartRequest;
import com.example.phoneShopping.cart.dto.response.CreateCartProductResponse;
import com.example.phoneShopping.cart.dto.response.CreateCartResponse;
import com.example.phoneShopping.cart.dto.response.UpdateCartProductResponse;
import com.example.phoneShopping.cart.dto.response.UpdateCartResponse;
import com.example.phoneShopping.cart.service.CartService;


import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Tag(name = "CartController", description = "Cart API")
@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController 
{
	private final CartService service;
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/createCart")
	public ResponseEntity<CreateCartResponse> createCart(@Valid @RequestBody CreateCartRequest req)
	{
		System.out.println("Cart 정보 생성");
		return ResponseEntity.ok(service.createCart(req));
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/getAllCart")
	public void findAllCart()
	{
		System.out.println("Cart 정보 전체 출력");
		service.findAllCart();
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/getOneCart")
	public void findByIdCart(int cart_seq)
	{
		System.out.println("Cart 정보 1개 출력");
		System.out.println(cart_seq);
		service.findByIdCart(cart_seq);
	}
	
	@PreAuthorize("isAuthenticated()")
	@PatchMapping(value = "/updateCart/{cart_seq}")
	public ResponseEntity<UpdateCartResponse> updateCart(@Valid @RequestBody UpdateCartRequest req)
	{
		System.out.println("Cart 정보 수정");
		return ResponseEntity.ok(service.updateCart(req));
	}
	
	@PreAuthorize("isAuthenticated()")
	@DeleteMapping(value = "/deleteCart/{cartSeq}")
	public void deleteCart(int cart_seq)
	{
		System.out.println("Cart 정보 제거");
		System.out.println(cart_seq);
		service.deleteCart(cart_seq);
	}
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/createCartProduct")
	public ResponseEntity<CreateCartProductResponse> createCartProduct(@Valid @RequestBody CreateCartProductRequest req)
	{
		System.out.println("CartProduct 정보 생성");
		return ResponseEntity.ok(service.createCartProduct(req));
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/getAllCartProduct")
	public void findAllCartProduct()
	{
		System.out.println("CartProduct 정보 전체 출력");
		service.findAllCartProduct();
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/getOneCartProduct")
	public void findByIdCartProduct(int cartp_seq)
	{
		System.out.println("CartProduct 정보 1개 출력");
		System.out.println(cartp_seq);
		service.findByIdCartProduct(cartp_seq);
	}
	
	@PreAuthorize("isAuthenticated()")
	@PatchMapping(value = "/updateCartProduct/{cartpSeq}")
	public ResponseEntity<UpdateCartProductResponse> updateCartProduct(@Valid @RequestBody UpdateCartProductRequest req)
	{
		System.out.println("CartProduct 정보 수정");
		return ResponseEntity.ok(service.updateCartProduct(req));
	}
	
	@PreAuthorize("isAuthenticated()")
	@DeleteMapping(value = "/deleteCartProduct/{cartpSeq}")
	public void deleteCartProduct(int cartp_seq)
	{
		System.out.println("CartProduct 정보 제거");
		System.out.println(cartp_seq);
		service.deleteCart(cartp_seq);
	}
}
