package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.product;
@Repository
public class productDaoImpl implements productDao {
	public productDaoImpl()
	{
		
	}
	@Autowired
	SessionFactory sessionfactory;
	
   @Transactional
	@Override
	public boolean addproduct(product product) {
		try{
			sessionfactory.getCurrentSession().save(product);
			return true;
			
			
		}
		catch(Exception e)
		{
			System.out.println("exception arised"+e);
			return false;
		}
	}

	@Override
	public product getproduct(int productId) {
	Session session=sessionfactory.openSession();
	product p=(product)session.get(product.class, productId);
	session.close();
	return p;
	}

	@Override
	public boolean deleteproduct(product product) {
		try
		{
			sessionfactory.getCurrentSession().delete(product);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("exception arised"+e);
			return false;
		}
	}

	@Override
	public boolean updateproduct(product product) {
		try{
			sessionfactory.getCurrentSession().update(product);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("exception arised"+e);
			return false;
		}
	}

	@Override
	public List<product> listproducts() {
		Session session=sessionfactory.openSession();
		Query query=session.createQuery("from product");
		List<product> listproducts=(List<product>)query.list();
		return listproducts;
	}
	

}
