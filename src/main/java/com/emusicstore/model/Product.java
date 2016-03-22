package com.emusicstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Product {

	public Product()
	{
		
	}
	
	
	
	public String getProductStatus() 
	{
		return productStatus;
	}
	public void setProductStatus(String productStatus)
	{
		this.productStatus = productStatus;
	}
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String productId;
	private String productName;
	private String productCategory;
	private String productDescription;
	private int productPrice;
	private String productCondition;
	private String productStatus;
	private int unitInstock;
	private String productManufacturer;
	
	




	public String getProductName() {
		return productName;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductCondition() {
		return productCondition;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productCategory="
				+ productCategory + ", productDescription=" + productDescription + ", productPrice=" + productPrice
				+ ", productCondition=" + productCondition + ", productStatus=" + productStatus + ", unitInstock="
				+ unitInstock + ", productManufacturer=" + productManufacturer + "]";
	}



	public void setProductCondition(String productCondition) {
		this.productCondition = productCondition;
	}
	public int getUnitInstock() {
		return unitInstock;
	}
	public void setUnitInstock(int unitInstock) {
		this.unitInstock = unitInstock;
	}
	public String getProductManufacturer() {
		return productManufacturer;
	}
	public void setProductManufacturer(String productManufacturer) {
		this.productManufacturer = productManufacturer;
	}
	

}
