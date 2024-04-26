package com.example.phoneShopping.member.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse 
{
    private String jwt;
    private String mem_id;

    public LoginResponse(String jwt, String mem_id) 
    {
        this.jwt = jwt;
        this.mem_id = mem_id;
    }
}
