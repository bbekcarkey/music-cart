package com.emusicstore.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.emusicstore.daointer.ProductDaoInter;
import com.emusicstore.model.Product;

@Controller
public class AdminController {
	
	@Autowired
	private ProductDaoInter productdao;
	
	@RequestMapping("/admin")
	public String adminPage()
	{
		System.out.println("inside admin");
		return "admin";
	}
	
	@RequestMapping("/admin/productInventory")
	public String adminProductInventory(Model model)
	{
		System.out.println("inside inventory");
		model.addAttribute("products",productdao.getAllProduct());
		return "productInventory";
	}
	
	
	@RequestMapping("/admin/productInventory/deleteProduct{productId}")
	public String deleteProduct(@PathVariable int productId,Model model) throws IOException
	{
		productdao.deleteProduct(productId);
		return "redirect:/admin/productInventory";
		
	}
	
	@RequestMapping("/admin/productInventory/addProduct")
	public String addProduct(Model model)
	
	{
		System.out.println("inside inventory");
		Product product =new Product();
		product.setProductCategory("instrument");
		product.setProductCondition("new");
		product.setProductPrice(0);
		product.setProductStatus("active");
	model.addAttribute("product",product);
		return "addProduct";
	}
	
	
	@RequestMapping(value="/admin/productInventory/addProduct" , method=RequestMethod.POST)
	public String addProductPost(@ModelAttribute("product") Product product)
	
	{
		System.out.println("inside database adding product");

productdao.addProduct(product);

		return "redirect:/admin/productInventory";
	}
	

}
