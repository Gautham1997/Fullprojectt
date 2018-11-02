package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.dao.CartItemDao;
import com.niit.dao.productDao;
import com.niit.model.CartItem;

@Controller
public class OrderController {
	@Autowired
	productDao productdao;
	
	@Autowired
	CartItemDao cartitemdao;
	
	@RequestMapping("/ConfirmOrder")
	public String ConfirmOrder(HttpSession session,Model m)
	{ 
		String username=(String)session.getAttribute("username");
		List<CartItem> listCartItems=cartitemdao.getCartItems(username);
		m.addAttribute("cartList",listCartItems);
		m.addAttribute("grandTotal",this.grandTotal(listCartItems));
		
		return "Orderconfirm";
	}
	
	public int grandTotal(List<CartItem> listCartItems)
	{
		int grandTotal=0;
		for(CartItem cartItem: listCartItems)
		{
			grandTotal=grandTotal+cartItem.getQuantity()*(productdao.getproduct(cartItem.getProductId()).getProductPrice());
		}	
		return grandTotal;
	}
	
	@RequestMapping("/PaymentConfirm")
	public String PaymentConfirm()
	{ 
		
		
		return "ThankYou";
		
	}
}
