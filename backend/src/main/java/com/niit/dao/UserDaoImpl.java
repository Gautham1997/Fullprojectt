package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.User;

@Transactional
@EnableTransactionManagement
@Repository("UserDao")
public class UserDaoImpl implements UserDao {
	@Autowired
	SessionFactory sessionfactory;
 @Transactional
	@Override
	public boolean addUser(User user) {
	 try
		{
		sessionfactory.getCurrentSession().save(user);
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
	public boolean deleteUser(User user) {
	 try
		{
			sessionfactory.getCurrentSession().delete(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
		
		return false;
	}
 }

	@Override
	@Transactional
	public boolean updateUser(User user) {
		try
		{
			sessionfactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception arised:"+e);
			return false;
		}
		
	}
	@Override
	public User getUser(int userId) {
		Session session=sessionfactory.openSession();
		User user=(User)session.get(User.class, userId);
		session.close();
		return user;
	}

	@Override
	public List<User> getUser() {
		Session session=sessionfactory.openSession();
		Query query=session.createQuery("from User");
		List<User> listUser=(List<User>)query.list();
		return listUser;

	}
@Transactional
	@Override
	public boolean isValidUser(String username, String password) {
	System.out.println("dao impl");
	String hql ="from User where username= '" + username + "' and " + " password ='" + password + "'";
	Query query = sessionfactory.getCurrentSession().createQuery(hql);
	@SuppressWarnings("unchecked")
	List<User> list = (List<User>) query.list();
	if(list != null && !list.isEmpty())
	{
	
		return true;
	}
	return false;

}

	@Transactional
	@Override
	public boolean save(User user) {
		try {
			 Session session = sessionfactory.getCurrentSession();
			
		 user.setRole("ROLE_USER");
		user.setEnabled(true);
		
		
//			    CartItem newCart = new CartItem();
//		        newCart.setUser(user);
//		        user.setCartItem(newCart);
//		        session.saveOrUpdate(user);
//		        session.saveOrUpdate(newCart);

		        session.flush();
			
			return true;

		}
		catch(Exception e)
		{
			
			e.printStackTrace();
			return false;
		}

	   }
		
	
@Transactional
	@Override
	public User get(String username) {
		String hql = "from User where username= "+" '" +username+ "'";
		Query query =sessionfactory.getCurrentSession().createQuery(hql);
		List<User> list = query.list();
		if(list == null || list.isEmpty())
		{
			return null;
		}
		else
		{
			return list.get(0);
		}
	}
	}
	


