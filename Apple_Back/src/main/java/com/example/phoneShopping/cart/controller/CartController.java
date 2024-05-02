package com.example.phoneShopping.cart.controller;


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

import com.example.phoneShopping.cart.domain.Cart;
import com.example.phoneShopping.cart.domain.CartProduct;
import com.example.phoneShopping.cart.dto.request.CreateCartProductRequest;
import com.example.phoneShopping.cart.dto.request.CreateCartRequest;
import com.example.phoneShopping.cart.dto.request.UpdateCartProductRequest;
import com.example.phoneShopping.cart.dto.request.UpdateCartRequest;
import com.example.phoneShopping.cart.dto.response.CreateCartProductResponse;
import com.example.phoneShopping.cart.dto.response.CreateCartResponse;
import com.example.phoneShopping.cart.dto.response.DeleteCartProductResponse;
import com.example.phoneShopping.cart.dto.response.DeleteCartResponse;
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
	@PostMapping("/create")
	public ResponseEntity<CreateCartResponse> createCart(@Valid @RequestBody CreateCartRequest req)
	{
		System.out.println("Cart 정보 생성");
		return ResponseEntity.ok(service.createCart(req));
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/getAll")
	public List<Cart> findAllCart()
	{
		System.out.println("Cart 정보 전체 출력");
		return service.findAllCart();
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/{cartSeq}")
	public Cart findByIdCart(@PathVariable(value = "cartSeq") int cartSeq)
	{
		System.out.println("Cart 정보 1개 출력");
		System.out.println(cartSeq);
		return service.findByIdCart(cartSeq);
	}
	
	@PreAuthorize("isAuthenticated()")
	@PatchMapping("/{cartSeq}")
	public ResponseEntity<UpdateCartResponse> updateCart(@Valid @RequestBody UpdateCartRequest req)
	{
		System.out.println("Cart 정보 수정");
		return ResponseEntity.ok(service.updateCart(req));
	}
	
	@PreAuthorize("isAuthenticated()")
	@DeleteMapping("/{cartSeq}")
	public ResponseEntity<DeleteCartResponse> deleteCart(@PathVariable(value = "cartSeq") int cartSeq)
	{
		System.out.println("Cart 정보 제거");
		System.out.println(cartSeq);
		return ResponseEntity.ok(service.deleteCart(cartSeq));
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
	public List<CartProduct> findAllCartProduct()
	{
		System.out.println("CartProduct 정보 전체 출력");
		return service.findAllCartProduct();
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/{cartpSeq}")
	public CartProduct findByIdCartProduct(@PathVariable(value = "cartpSeq") int cartpSeq)
	{
		System.out.println("CartProduct 정보 1개 출력");
		System.out.println(cartpSeq);
		return service.findByIdCartProduct(cartpSeq);
	}
	
	@PreAuthorize("isAuthenticated()")
	@PatchMapping("/{cartpSeq}")
	public ResponseEntity<UpdateCartProductResponse> updateCartProduct(@Valid @RequestBody UpdateCartProductRequest req)
	{
		System.out.println("CartProduct 정보 수정");
		return ResponseEntity.ok(service.updateCartProduct(req));
	}
	
	@PreAuthorize("isAuthenticated()")
	@DeleteMapping("/{cartpSeq}")
	public ResponseEntity<DeleteCartProductResponse> deleteCartProduct(@PathVariable(value = "cartpSeq") int cartpSeq)
	{
		System.out.println("CartProduct 정보 제거");
		System.out.println(cartpSeq);
		return ResponseEntity.ok(service.deleteCartProduct(cartpSeq));
	}
}
