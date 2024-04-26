package com.example.phoneShopping.product.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.phoneShopping.product.domain.Product;
import com.example.phoneShopping.product.dto.param.CreateProductParam;
import com.example.phoneShopping.product.dto.param.UpdateProductParam;

@Mapper
@Repository
public interface ProductDao {
	
	// 상품 추가
	Integer createProduct(CreateProductParam param);
	
	// 상품 상세 1개
	Product findById(String prod_seq);
	
	// 상품 목록
	Product findAll();
	
	// 상품 수정
	Integer updateProduct(UpdateProductParam param);
	
	// 상품 삭제
	Integer deleteProduct(String prod_seq);
	
}
