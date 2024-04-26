package com.example.phoneShopping.product.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.phoneShopping.product.dao.ProductDao;
import com.example.phoneShopping.product.dto.param.CreateProductParam;
import com.example.phoneShopping.product.dto.param.UpdateProductParam;
import com.example.phoneShopping.product.dto.request.CreateProductRequest;
import com.example.phoneShopping.product.dto.request.UpdateProductRequest;
import com.example.phoneShopping.product.dto.response.CreateProductResponse;
import com.example.phoneShopping.product.dto.response.UpdateProductResponse;
import com.example.phoneShopping.product.exception.ProductException;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {
	
	private final ProductDao dao;
	
	// 상품 추가
	public CreateProductResponse createProduct(CreateProductRequest req) {
		
		saveProduct(req);
		
		return new CreateProductResponse(req.getProd_seq());
	}
	
	// 상품 추가 method
	private void saveProduct(CreateProductRequest req) {
		
		CreateProductParam param = new CreateProductParam(req);
		Integer result = dao.createProduct(param);
		
		if (result == 0) {
			throw new ProductException("상품 등록을 실패했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// 상품 상세 1개
	public void findByIdProduct(String prod_seq) {
		System.out.println("findByIdProduct 동작");
		dao.findByIdProduct(prod_seq);
	}
	
	// 상품 목록
	public void findAllProduct() {
		System.out.println("findAllProduct 동작");
		dao.findAllProduct();
	}
	
	// 상품 수정
	public UpdateProductResponse updateProduct(UpdateProductRequest req) {
		
		findByIdProduct(req.getProd_seq());
		updateProductMethod(req);		
		
		return new UpdateProductResponse(req.getProd_seq());
	}
	
	// 상품 수정 Method
	private void updateProductMethod(UpdateProductRequest req) {
		System.out.println("updateProduct 동작");
		UpdateProductParam param = new UpdateProductParam(req.getProd_seq(), req.getProd_name(),
					req.getProd_price(), req.getProd_hdd(), req.getProd_color(), req.getProd_cnt());
		
		Integer result = dao.updateProduct(param);
		if (result == 0) {
			throw new ProductException("상품 수정 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// 상품 삭제
	public void deleteProduct(String prod_seq) {
		System.out.println("deleteProduct 동작");
		dao.deleteProduct(prod_seq);
	}
}
