package com.niit.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.OrderDetail;
@Repository("OrderDetailDao")
public class OrderDetailDaoImpl implements OrderDetailDao {
@Autowired
SessionFactory sessionfactory;
@Transactional
	@Override
	public boolean ConfirmOrderDetail(OrderDetail orderDetail) {
	try
	{
		sessionfactory.getCurrentSession().save(orderDetail);
		return true;
	}
	catch(Exception e)
	{
		System.out.println("Exception arised:"+e);
		return false;
	}

	}

}
