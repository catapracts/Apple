package com.example.phoneShopping.product.service;

import com.example.phoneShopping.product.dao.ProductDao;
import com.example.phoneShopping.product.dto.param.CreateProductParam;
import com.example.phoneShopping.product.dto.param.UpdateProductParam;
import com.example.phoneShopping.product.dto.request.CreateProductRequest;
import com.example.phoneShopping.product.dto.request.UpdateProductRequest;
import com.example.phoneShopping.product.dto.response.CreateProductResponse;
import com.example.phoneShopping.product.dto.response.UpdateProductResponse;

public class ProductService {
	
	private final ProductDao dao;
	
	public ProductService(ProductDao dao) {
		this.dao = dao;
	}

	/* 상품 추가 POST */
	public CreateProductResponse createProduct(CreateProductRequest req) {
		CreateProductParam param = new CreateProductParam(req);
		
		dao.createProduct(param);
		
		return new CreateProductResponse(param.getProd_seq());
	}
	
	/* 상품 상세 GET */
	public 
	
	/* 상품 목록 GET */
	
	/* 상품 수정 PATCH */
	public UpdateProductResponse updateProduct(UpdateProductRequest req) {
		UpdateProductParam param = new UpdateProductParam(req);
		
		dao.updateProduct(param);
		
		return new UpdateProductResponse();
	}
	
	/* 상품 삭제 DELETE */
}
