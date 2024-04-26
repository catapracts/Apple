package com.example.phoneShopping.cart.dto.param;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartOrderDto
{
	private int cartp_seq;
	private List<CartOrderDto> cartOrderDtoList;
}
