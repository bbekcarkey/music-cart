package com.emusicstore.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.emusicstore.daointer.ProductDaoInter;
import com.emusicstore.model.Product;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String Home()
	{
		System.out.println("inside home Controller, inside home method");
		return "home";
	}
	
	@Autowired
	private ProductDaoInter productdao;


	@RequestMapping("/productlist")
	public String getproductlist(Model model)
	{
		System.out.println("inside home Controller, inside getproductlist method");
		model.addAttribute("products",productdao.getAllProduct());
		return "productList";
		
	}

	

	@RequestMapping("/productlist/viewProduct/{productId}")
	public String viewProduct(@PathVariable int productId,Model model) throws IOException
	{
		model.addAttribute("product",productdao.getProductbyId(productId));
		return "viewproduct";
		
	}

	
	

}
