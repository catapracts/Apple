package com.example.phoneShopping.cart.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Create Cart Product response")
public class CreateCartProductResponse 
{
	@Schema(description = "Cart Product Create성공 시 response, 반환값 = Integer(생성된 cartpSeq)")
	private int cartpSeq;
}
