package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.CartItemDao;
import com.niit.dao.UserDao;
import com.niit.dao.productDao;
import com.niit.model.CartItem;
import com.niit.model.product;

@Controller
public class CartController {
	@Autowired
	UserDao userdao;
	@Autowired
	CartItemDao cartdao;
	@Autowired
	productDao productdao;
	
		
	
	
	@RequestMapping("/addToCart/{productId}")
	public String addCartItem(@PathVariable("productId")int productId,@RequestParam("quantity")int quantity,HttpSession session, Model m)
		{
			CartItem cartItem=new CartItem();
			product product=productdao.getproduct(productId);
			
			String username=(String)session.getAttribute("username");
			cartItem.setProductId(productId);
			cartItem.setQuantity(quantity);
			cartItem.getCartItemId();
		    cartItem.setCartId(1);
			cartItem.setUserName(username);
			cartItem.setPaymentStatus("NP");
			cartItem.setSubTotal(quantity*product.getProductPrice());
		
			cartdao.addCartItem(cartItem);
			
			m.addAttribute("cartList",cartdao.getCartItems(username));
			
			return "Cart";
			
	}
	
	@RequestMapping("/updateCartItem/{cartItemId}")
	public String updateCartItem(@PathVariable("cartItemId") int cartItemId, @RequestParam("qty")int quantity,HttpSession session,Model m)
	{
		 CartItem cartItem=cartdao.getCartItem(cartItemId);
		 product product=productdao.getproduct(cartItem.getProductId());
	     
	     cartItem.setQuantity(quantity);
	     cartItem.setSubTotal(quantity*product.getProductPrice());
	     cartdao.updateCartItem(cartItem);
	     String username= (String)session.getAttribute("username");
		 List<CartItem> listCartItems= cartdao.getCartItems(username);
	     m.addAttribute("cartList",listCartItems);
	     m.addAttribute("grandTotal",this.grandTotal(listCartItems));
	     return "Cart";
		
    }
    
	@RequestMapping("/deleteCartItem/{cartItemId}")
	public String deleteCartItem(@PathVariable("cartItemId") int cartItemId, HttpSession session,Model m)
	{
	     CartItem cartItem=cartdao.getCartItem(cartItemId);
	     
	     
	     cartdao.deleteCartItem(cartItem);
	     
	     String username=(String)session.getAttribute("username");
	     List<CartItem> listCartItems= cartdao.getCartItems(username);
	     m.addAttribute("cartList",listCartItems);
	     m.addAttribute("grandTotal",this.grandTotal(listCartItems));
	     
		 return "Cart";
		
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

}
