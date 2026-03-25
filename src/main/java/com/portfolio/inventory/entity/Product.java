package com.portfolio.inventory.entity;

import jakarta.persistence.*;

@Entity  // 對應資料庫的實體類別
@Table(name = "products")  // 資料表名稱“products" 
public class Product {

	@Id // 主鍵（Primary Key)必須加上@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 讓資料庫自動流水號遞增
	private Long id;
	
	@Column(nullable = false, unique = true) // sku是商品編號，不能重複
	private String sku;
	
	private String name;
	private Double price;
	private Integer stock;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	
}
