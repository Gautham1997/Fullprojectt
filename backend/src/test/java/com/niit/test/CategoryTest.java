package com.niit.test;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDao;
import com.niit.model.Category;

public class CategoryTest {
public static void main(String arg[])
{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("com.niit");
	context.refresh();
	CategoryDao categoryDao=(CategoryDao)context.getBean("categoryDao");
	Category category=new Category();
	category.setCategoryId(1);
	category.setCategoryName("bucket chiken");
	category.setCategoryDescription("yuummy");
	categoryDao.addCategory(category);
	
}
}
