package com.example.phoneShopping.cart.dto.param;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartDetailDto 
{
    private String cartp_seq; //장바구니 상품 아이디

    private String prod_name; //상품명

    private int price; //상품 금액

    private int cnt; //수량


    public CartDetailDto(String cartp_seq, String prod_name, int price, int cnt)
    {
        this.cartp_seq = cartp_seq;
        this.prod_name = prod_name;
        this.price = price;
        this.cnt = cnt;
    }
}
