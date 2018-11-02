package com.niit.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.supplierDao;
import com.niit.model.supplier;

public class supplierTest {
	public static void main(String arg[])
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		supplierDao supplierdao=(supplierDao)context.getBean("supplierDao");
		supplier s1=new supplier();
		s1.setSupplierId(1);
		s1.setSupplierName("gautham");
		s1.setSupplierAddress("12 illathu pillaimar mela street ,muhavoor");
		supplierdao.addsupplier(s1);
	}

}
