package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.CartItem;
@Repository("CartItemDao")
public class CartItemDaoImpl implements CartItemDao {
	@Autowired
	SessionFactory sessionfactory;
@Transactional
	@Override
	public boolean addCartItem(CartItem cartItem) {
	try{
		sessionfactory.getCurrentSession().save(cartItem);
		return true;
	}
	catch(Exception e)
	{
		System.out.println("Exception arised:"+e);
		return false;
	}
}

	@Override
	public CartItem getCartItem(int cartItemId) {
		try{
			Session session=sessionfactory.openSession();
			CartItem cartItem=(CartItem)session.get(CartItem.class,cartItemId);
			return cartItem;
			}
			
			catch(Exception e){
				return null;
			}
	}
@Transactional
	@Override
	public boolean deleteCartItem(CartItem cartItem) {
		try
		{
			sessionfactory.getCurrentSession().delete(cartItem);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
		
	}
@Transactional
	@Override
	public boolean updateCartItem(CartItem cartItem) {
		try
		{
			sessionfactory.getCurrentSession().update(cartItem);
			return true;
		}
		catch(Exception e){
			System.out.println("exception arised:"+e);
			return false;
		}
	}
@Transactional
	@Override
	public List<CartItem> getCartItems(String username) {
	try
	{
		Session session=sessionfactory.openSession();
//		CartItem cartItem=(CartItem)session.createQuery("form CartItem where username=:username and status=:'NP'");
		Query query=session.createQuery("from CartItem");
		List<CartItem> listCartItem=(List<CartItem>)query.list();
		return listCartItem;
	}
	catch(Exception e){
		System.out.println("exception arised:"+e);
		return null;
	}


	}

}
