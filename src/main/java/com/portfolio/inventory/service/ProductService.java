package com.portfolio.inventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.inventory.entity.Product;
import com.portfolio.inventory.repository.ProductRepository;

@Service	// 宣告標記它是一個服務
public class ProductService {
	
	// 依賴注入 允許spring loC容器自動將符合類型的Bean裝配到標注的成員變數、Setter方法或建構子中
	// 把依賴管理交給容器，簡化代碼降低物件間的耦合度
	@Autowired	
	private ProductRepository productRepository;
	
	public Product addProduct (Product product){
		return productRepository.save(product);
		
	}
}
