package com.portfolio.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
@CrossOrigin //允許所有外部網頁來呼叫API
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
	 * 發送GET請求時 SpringBoot會透過@GetMapping標記捕捉這個請求
	 * 並交給Controller的getAllProducts方法處理，接著會呼叫Service
	 * 層去執行資料庫查詢，最後將「商品列表」回傳給前端
	 * (SpringBoot底層會自動將Java物件轉換成JSON格式)
	 * */
	@GetMapping
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	/* *
	 * 處理PUT請求的標記，設定網址接收一個動態id
	 * 加 @PathVariable標記，讓Spring知道這個id是從上面網址擷取下來的
	 * 加 @RequestBody 標記，把前端傳來的JSON轉換成物件
	 * return 把從網址抓到的id跟從JSON轉換來的商品資料交給大腦處理
	 * */
	@PutMapping("/{id}")
	public Product updateProduct(
			@PathVariable Long id,
			@RequestBody Product productDetails) {
		
		return productService.updateProduct(id, productDetails);
	}
	
	/* *
	 * 處理DELETE請求的標記，設定網址接收一個動態id
	 * 加@PathVariable標記，讓Spring知道這個id是從上面網址擷取下來的
	 * 交給service層處理deleteProduct方法
	 * return "商品刪除成功"
	 * */
	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
		
		return "商品刪除成功";
		
	}
}
