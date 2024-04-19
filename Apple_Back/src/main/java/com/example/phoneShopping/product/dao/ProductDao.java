package com.example.phoneShopping.product.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.phoneShopping.product.domain.Product;
import com.example.phoneShopping.product.dto.param.*;

@Mapper
@Repository
public class ProductDao {
	
	Product getProduct(String prod_seq);
	
	public void createProduct(CreateProductParam param);
	
	public Integer updateProduct(UpdateProductParam param);
	
	Integer deleteProduct(String prod_seq);
	
}
