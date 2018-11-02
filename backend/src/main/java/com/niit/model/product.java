package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table
public class product {
	@Id
	@GeneratedValue
private int productId;
private String produtName;
private String produtDesription;
private int supplierId;
private int categoryId;
private int productPrice;
private int productQuantity;
private int stock;
@Transient
private MultipartFile pimage;

public MultipartFile getPimage() {
	return pimage;
}
public void setPimage(MultipartFile pimage) {
	this.pimage = pimage;
}
public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public String getProdutName() {
	return produtName;
}
public void setProdutName(String produtName) {
	this.produtName = produtName;
}
public String getProdutDesription() {
	return produtDesription;
}
public void setProdutDesription(String produtDesription) {
	this.produtDesription = produtDesription;
}
public int getSupplierId() {
	return supplierId;
}
public void setSupplierId(int supplierId) {
	this.supplierId = supplierId;
}
public int getCategoryId() {
	return categoryId;
}
public void setCategoryId(int categoryId) {
	this.categoryId = categoryId;
}
public int getProductPrice() {
	return productPrice;
}
public void setProductPrice(int productPrice) {
	this.productPrice = productPrice;
}
public int getProductQuantity() {
	return productQuantity;
}
public void setProductQuantity(int productQuantity) {
	this.productQuantity = productQuantity;
}
public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}



}
