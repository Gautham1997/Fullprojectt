package com.niit.dao;

import java.util.List;

import com.niit.model.product;

public interface productDao {
	public boolean addproduct(product product);
	public product getproduct(int product);
	public boolean deleteproduct(product product);
	public boolean updateproduct(product product);
	public List<product> listproducts();

}
