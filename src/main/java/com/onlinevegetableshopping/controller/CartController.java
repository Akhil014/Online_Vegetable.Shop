package com.onlinevegetableshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinevegetableshopping.model.Order;
import com.onlinevegetableshopping.service.CartService;

@RestController
@CrossOrigin("*")
@RequestMapping("/Cartorderdetails")
public class CartController {

	@Autowired
	private CartService cartServe;
	
	/*
	 *  Controller for the requests related to the Order
	 */
	
	//requests the controller to make Order

	//http://localhost:8091/onlinevegetableshopping/Cartorderdetails/makeorder

	@PostMapping("/makeorder")
	public ResponseEntity<Order> makeOrderOnline(@RequestBody Order order)
	{
		Order listorder = cartServe.makeOrder(order);
		
		return new ResponseEntity("Order is placed Thank you!", HttpStatus.OK);
		
	}
}
