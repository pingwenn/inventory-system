package com.portfolio.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.inventory.entity.Product;
import com.portfolio.inventory.repository.ProductRepository;

@Service	// 宣告標記它是一個服務
public class ProductService {
	
/* *
 * 依賴注入 允許spring loC容器自動將符合類型的Bean裝配到標注的成員變數、Setter方法或建構子中
 * 把依賴管理交給容器，簡化代碼降低物件間的耦合度
 * */
	@Autowired	
	private ProductRepository productRepository;
	
	/* *
	 * 新增商品
	 * */
	public Product addProduct (Product product){
		return productRepository.save(product);
		
	}
	
	/* *
	 * 查詢商品
	 * 執行方法時 呼叫productRepository執行SQL語法 
	 * 撈出所有資料交給Controller商品實體List
	 * */
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	/* *
	 * 修改商品
	 * 把id交給productRepository去找有沒有這個商品
	 * 如果有就拿出來 並命名為existingProduct
	 * 如果找不到 程式立刻中斷並丟出錯誤訊息
	 * ----
	 * 把舊名稱改成更新的名字
	 * 把舊價錢改成更新的價錢
	 * 把舊庫存改成更新的庫存
	 * ----
	 * 再呼叫productRepository.save()儲存existingProduct
	 * **為什麼是save？**
	 * 當save()一個帶有id的實體，它不會去新增一筆資料
	 * 而是產生UPDATE products SET name=?,price=? WHERE id=?
	 * */
	public Product updateProduct(Long id, Product updateProduct) {
		Product existingProduct = productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("找不到 ID 為 " + id + "的商品！"));
		
		existingProduct.setName(updateProduct.getName());
		existingProduct.setPrice(updateProduct.getPrice());
		existingProduct.setStock(updateProduct.getStock());
		
		return productRepository.save(existingProduct);
	}
}
