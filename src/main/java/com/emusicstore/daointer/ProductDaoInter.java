package com.emusicstore.daointer;

import java.util.List;

import com.emusicstore.model.Product;

public interface ProductDaoInter {

	public  void addProduct(Product product);
	public Product getProductbyId(int productId) ;
	public List<Product> getAllProduct();
	public void deleteProduct(int productId);
	
	
	
	
	
	
	
}