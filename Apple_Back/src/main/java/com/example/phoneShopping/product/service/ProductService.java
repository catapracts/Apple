package com.example.phoneShopping.product.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.phoneShopping.product.dao.ProductDao;
import com.example.phoneShopping.product.domain.Product;
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
public class ProductService 
{
	private final ProductDao dao;
	
	// 상품 추가
	public CreateProductResponse createProduct(CreateProductRequest req) 
	{
		saveProduct(req);
		return new CreateProductResponse(req.getProd_seq());
	}
	
	
	// 상품 추가 method
	private void saveProduct(CreateProductRequest req) 
	{
		CreateProductParam param = new CreateProductParam(req);
		Integer result = dao.createProduct(param);
		
		if (result == 0) 
		{
			throw new ProductException("상품 등록을 실패했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	// 상품 상세 1개
	public Product findByIdProduct(String prod_seq) 
	{
		System.out.println("findByIdProduct 동작");
		System.out.println(prod_seq);
		Product prod = dao.findByIdProduct(prod_seq);
		dao.findByIdProduct(prod_seq).getProdSeq(); 
		dao.findByIdProduct(prod_seq).getProdName(); 
		dao.findByIdProduct(prod_seq).getProdPrice();
		dao.findByIdProduct(prod_seq).getProdCnt();
		dao.findByIdProduct(prod_seq).getHddSeq();
		dao.findByIdProduct(prod_seq).getColorSeq();
		
		return prod;

	}
	
	
	// 상품 목록
	public List<Product> findAllProduct() 
	{
		System.out.println("findAllProduct 동작");
		List<Product> listProd = dao.findAllProduct();
		
		for (int i = 0 ; i < listProd.size(); i++) {
			System.out.println(listProd.get(i));
		}
		
		return listProd;		
	}
	
	
	// 상품 수정
	public UpdateProductResponse updateProduct(UpdateProductRequest req) 
	{
		findByIdProduct(req.getProd_seq());
		updateProductMethod(req);		
		
		return new UpdateProductResponse(req.getProd_seq());
	}
	
	// 상품 수정 Method
	private void updateProductMethod(UpdateProductRequest req) 
	{
		System.out.println("updateProduct 동작");
		UpdateProductParam param = new UpdateProductParam(req.getProd_seq(), req.getProd_name(),
					req.getProd_price(), req.getHdd_seq(), req.getColor_seq(), req.getProd_cnt());
		
		System.out.println(param.getProd_seq());
		
		Integer result = dao.updateProduct(param);
		
		System.out.println(result);
		if (result == 0) 
		{
			throw new ProductException("상품 수정 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// 상품 삭제
	public void deleteProduct(String prod_seq) 
	{
		System.out.println("deleteProduct 동작");
		dao.deleteProduct(prod_seq);
	}
}
