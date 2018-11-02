package com.niit.dao;


	import java.util.List;

	import com.niit.model.User;

	public interface UserDao {
		
		
		public boolean addUser(User user);
		public boolean deleteUser(User user);
		public boolean updateUser(User user);
		public User getUser(int user);
		public List<User> getUser();
		public boolean isValidUser(String username, String password);
		public boolean save(User user);


		public User get(String username);
	}


