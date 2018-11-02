package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.CategoryDao;
import com.niit.model.Category;

@Controller
public class CategoryController {
	@Autowired
	CategoryDao categorydao;
	boolean flag=true;
	@RequestMapping("/category")
	public String showCategory(Model m)
	{
	List<Category> listCategories=categorydao.getCategories();
	m.addAttribute("listCategories",listCategories);
	for(Category category:listCategories)
	{
		System.out.println(category.getCategoryName()+",");
	}
		flag=false;
		return "categorypage";
	}
	@RequestMapping(value="/InsertCategory",method=RequestMethod.POST)
	public String insertCategoryData(@RequestParam("catname")String catname,@RequestParam("catdesc")String catdesc,Model m)
	{
		Category c=new Category();
		c.setCategoryName(catname);
		c.setCategoryDescription(catdesc);
		categorydao.addCategory(c);
		List<Category> listCategories=categorydao.getCategories();
		m.addAttribute("listCategories", listCategories);
		flag=false;
		return "categorypage";
		
	}
	@RequestMapping("/deleteCategory/{categoryId}")
	public String DeleteCategory(@PathVariable("categoryId")int categoryId,Model m)
	{
		Category c=categorydao.getCategory(categoryId);
		categorydao.deleteCategory(c);
		List<Category> listCategories=categorydao.getCategories();
		m.addAttribute("listCategories", listCategories);
		flag=false;
		return "categorypage";
		
	}
	@RequestMapping("/updateCategory/{categoryId}")
	public String UpdateCategory(@PathVariable("categoryId")int categoryId,Model m)
	{
		Category c=categorydao.getCategory(categoryId);
		categorydao.updateCategory(c);
		List<Category> listCategories=categorydao.getCategories();
		m.addAttribute("listCategories", listCategories);
		m.addAttribute("categoryInfo",c);
		return "updatecategory";
		
	}
	@RequestMapping(value="/UpdateCategory",method=RequestMethod.POST)
	public String updateCategoryInDB(@RequestParam("catid") int categoryId,@RequestParam("catname") String categoryName,
			@RequestParam("catdesc") String categoryDescription,Model m)
	{
		Category category=categorydao.getCategory(categoryId);
		category.setCategoryName(categoryName);
		category.setCategoryDescription(categoryDescription);
		
		categorydao.updateCategory(category);
		
		List<Category> listCategories=categorydao.getCategories();
		m.addAttribute("listCategories",listCategories);
		
		return "categorypage";
	}

}
