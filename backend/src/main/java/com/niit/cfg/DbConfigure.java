package com.niit.cfg;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.model.CartItem;
import com.niit.model.Category;
import com.niit.model.OrderDetail;
import com.niit.model.User;
import com.niit.model.product;
import com.niit.model.supplier;
import com.niit.dao.CategoryDao;
import com.niit.dao.CategoryDaoImpl;
import com.niit.dao.productDao;
import com.niit.dao.productDaoImpl;
import com.niit.dao.supplierDao;
import com.niit.dao.supplierDaoImpl;


@Configuration
@ComponentScan("com.niit")
@EnableTransactionManagement
public class DbConfigure {

	@Bean(name="dataSource")
	public DataSource getH2DataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/final");
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");
		
		System.out.println("---Data Source Created---");
		return dataSource;
	}
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		
		Properties hibernateProp=new Properties();
		
		hibernateProp.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProp.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		
		LocalSessionFactoryBuilder factoryBuilder=new LocalSessionFactoryBuilder(getH2DataSource());
		factoryBuilder.addAnnotatedClass(Category.class);
		factoryBuilder.addAnnotatedClass(supplier.class);
		factoryBuilder.addAnnotatedClass(product.class);
		factoryBuilder.addAnnotatedClass(CartItem.class);
		factoryBuilder.addAnnotatedClass(OrderDetail.class);
		factoryBuilder.addAnnotatedClass(User.class);
		factoryBuilder.addProperties(hibernateProp);
		
		System.out.println("Creating SessionFactory Bean");
		return factoryBuilder.buildSessionFactory();
	}
	@Bean(name="categorydao")
	public CategoryDao getCategoryDao()
	{
		System.out.println("----Category DAO Implementation---");
		return new CategoryDaoImpl();
	}
	@Bean(name="supplierdao")
	public supplierDao getsupplierDao()
	{
		System.out.println("supplier Dao implementation");
		return new supplierDaoImpl();
	}
	@Bean(name="productdao")
	public productDao getproductDao()
	{
		System.out.println("produt dao Implementation");
		return new productDaoImpl();
	}
	
	@Bean(name="txManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("---Transaction Manager----");
		return new HibernateTransactionManager(sessionFactory);
	}
		
	}
