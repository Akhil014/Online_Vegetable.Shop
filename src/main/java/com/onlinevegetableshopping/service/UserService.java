package com.onlinevegetableshopping.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.onlinevegetableshopping.exception.VegetableIdNotFoundException;
import com.onlinevegetableshopping.model.Cart;
import com.onlinevegetableshopping.model.FeedBack;
import com.onlinevegetableshopping.model.Order;
import com.onlinevegetableshopping.model.RaiseComplaint;
import com.onlinevegetableshopping.model.User;
import com.onlinevegetableshopping.model.Vegetable;

@Service
public interface UserService {
	
	public FeedBack giveFeedBack(FeedBack feedback);
	public List<Vegetable> viewAllVegtable();
	public Cart  addvegetableToCart(Cart cart);
	public List<Cart> viewCart();
	public RaiseComplaint raiseCompliant(RaiseComplaint raisecomplaint);
	public Cart deleteVegetablebyId(int vegetableId) throws VegetableIdNotFoundException ;
	public Vegetable getById(int vegetableId) throws VegetableIdNotFoundException;
		
	
	
	

}
