package com.niit.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.productDao;
import com.niit.model.product;

public class productTest {
public static void main(String arg[])
{
AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
context.scan("com.niit");
context.refresh();
productDao productDao=(productDao)context.getBean("productDao");
product p=new product();
p.setProductId(1);
p.setCategoryId(1);
p.setProductPrice(230);
p.setProductQuantity(2);
p.setProdutDesription("good product");
p.setProdutName("food");
p.setSupplierId(1234);
productDao.addproduct(p);
}
}
