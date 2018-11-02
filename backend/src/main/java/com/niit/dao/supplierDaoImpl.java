package com.niit.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.supplier;
@Repository
public class supplierDaoImpl implements supplierDao
{
	public supplierDaoImpl()
	{
		
	}
	@Autowired
	SessionFactory sessionfactory;
	
	
   @Transactional
	public boolean addsupplier(supplier supplier) {
	   try
	   {
		sessionfactory.getCurrentSession().save(supplier);
		return true;
	   }
	   catch(Exception e)
	   {
		   System.out.println("exception arised "+e);
		   return false;
	   }
	}

	public supplier getsupplier(int supplierId) {
		Session session=sessionfactory.openSession();
		supplier supp=(supplier) session.get(supplier.class, supplierId);
		session.close();
		return supp;
	}
	

    @Transactional
	public boolean deletesupplier(supplier supplier) {
    try
    {
    	sessionfactory.getCurrentSession().delete(supplier);
    	return true;
    }
    catch(Exception e)
    {
    	System.out.println("exception arised"+e);
    	return false;
    	
    }
	}

    @Transactional
	public boolean updatesupplier(supplier supplier) {
		try{
		sessionfactory.getCurrentSession().update(supplier);
		return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception arised"+e);
			return false;
		}
	}

	public List<supplier> getsuppliers() {
		Session session=sessionfactory.openSession();
		Query query=session.createQuery("from supplier");
		List<supplier> listsuppliers=(List<supplier>)query.list();
		return listsuppliers;
	}

	
	
	
}