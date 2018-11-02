package com.niit.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.niit.dao.CategoryDao;
import com.niit.dao.productDao;
import com.niit.model.Category;
import com.niit.model.product;

@Controller
public class ProductController {
	@Autowired
	CategoryDao categorydao;
	@Autowired
	productDao productdao;
	private Object path;
	@RequestMapping("/product")
	public String showProductPage(Model m)
	{
		product p=new product();
		m.addAttribute(p);
	    m.addAttribute("catlist",this.listCategories());
	    return "InsertingProduct";
	    
	    		
	}
	@RequestMapping(value="/InsertProduct",method=RequestMethod.POST)
	public String addProduct(@ModelAttribute("product")product product,Model m,@RequestParam("pimage") MultipartFile filedet)
	{
		product p=new product();
		m.addAttribute(p);
		productdao.addproduct(product);
		String imagePath="G:\\New folder\\frontend\\src\\main\\webapp\\img\\";
		imagePath=imagePath+String.valueOf(product.getProductId())+".jpg";
	    File image=new File(imagePath);
	    if(!filedet.isEmpty())
		{

			try {
				byte[] fileBuffer=filedet.getBytes();	
				FileOutputStream fos=new FileOutputStream(image);
				BufferedOutputStream bs=new BufferedOutputStream(fos);
				bs.write(fileBuffer);
				bs.close();

			}
			
			catch (Exception e)
			{
				System.out.println("Exception Arised:"+e);
				e.printStackTrace();
			}
			
		}
		else
		{
			System.out.println("Problem Occured in File Uploading");
		}
		
		m.addAttribute("catlist",this.listCategories());
		return "productpage";	
	}
	@RequestMapping(value="/productPage",method=RequestMethod.GET)
	public String showProductsPage(Model m)
	{
		List<product> listproducts=productdao.listproducts();
		m.addAttribute("listproducts",listproducts);
		return "productpage";
	}
	
	@RequestMapping(value="/productDesc/{productId}",method=RequestMethod.GET)
	public String showProductDesc(@PathVariable("productId")int productId,Model m)
	{
		product product=productdao.getproduct(productId);
		String categoryName=categorydao.getCategory(product.getCategoryId()).getCategoryName();
		m.addAttribute("ProductInfo",product);
		m.addAttribute("categoryName",categoryName);
		return "productDesc";
	}


	public LinkedHashMap<Integer,String> listCategories()
	{
		List<Category> listCategories=categorydao.getCategories();
		LinkedHashMap<Integer,String> catlist=new LinkedHashMap<Integer,String>();
		for(Category category:listCategories)
		{
			catlist.put(category.getCategoryId(),category.getCategoryName());
		}
		return catlist;
	}
	
}
