package com.portfolio.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.inventory.entity.Product;
import com.portfolio.inventory.service.ProductService;
/* *
 * 告訴SpringBoot 這是專門回傳資料(通常JSON格式)的控制器
 * */
@RestController	
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	/* *
	 * 如果有人對api發送請求 立刻呼叫createProduct方法來處理
	 * @RequestBody 把前端傳來的JSON文字 自動轉解析並轉換成物件
	 * createProduct方法 把轉換好的物件交給service 讓service呼叫Repository存進資料庫後
	 * service存好資料庫後 產生帶有新ID的實體回傳給前端(springBoot會自動再次轉換成JSON格式)
	 * */
	@PostMapping 
	public Product createProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}
	
	/* *
	 * 發送請求時 呼叫getAllProducts
	 * */
	@GetMapping
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
}
