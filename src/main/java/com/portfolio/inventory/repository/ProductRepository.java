package com.portfolio.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.inventory.entity.Product;

// JpaRepository<要操作的實體類別, 該類別主鍵的資料型別>
public interface ProductRepository extends JpaRepository<Product, Long>{

}
