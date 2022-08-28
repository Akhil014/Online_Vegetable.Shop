package com.onlinevegetableshopping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinevegetableshopping.dao.CartRepository;
import com.onlinevegetableshopping.dao.FeedbackRepository;
import com.onlinevegetableshopping.dao.RaiseComplaintRepository;
import com.onlinevegetableshopping.dao.UserRepository;
import com.onlinevegetableshopping.dao.VegetableRepository;
import com.onlinevegetableshopping.exception.VegetableIdNotFoundException;
import com.onlinevegetableshopping.model.Cart;
import com.onlinevegetableshopping.model.FeedBack;
import com.onlinevegetableshopping.model.RaiseComplaint;
import com.onlinevegetableshopping.model.User;
import com.onlinevegetableshopping.model.Vegetable;

@Service
public class UserServiceImpl implements UserService {

	// connecting the service implementation with the Feedback repository

	@Autowired
	private FeedbackRepository feedbackRepo;
	
	// connecting the service implementation with the Vegetable repository

	@Autowired
	private VegetableRepository vegRepo;
	
	// connecting the service implementation with the Cart repository

	@Autowired
	private CartRepository cartRepo;
	
	// connecting the service implementation with the Raise Compliant repository

	@Autowired
	private RaiseComplaintRepository raiseRepo;
	
	
	// method implementing to give feedback

	@Override
	public FeedBack giveFeedBack(FeedBack feedback) {
		
		FeedBack userFeedback = feedbackRepo.saveAndFlush(feedback);
		return userFeedback;
	}

	// method implementing to view all Vegetable

	public List<Vegetable> viewAllVegtable() {
		List<Vegetable> res=vegRepo.findAll();
		return res;
	}

	// method implementing to add vegetable to Cart

	@Override
	public Cart addvegetableToCart(Cart cart) {
		Cart addtocart=cartRepo.saveAndFlush(cart);
		return addtocart;
	}
	
	// method implementing to view Cart

	public List<Cart> viewCart() {
		
		List<Cart> viewCart = cartRepo.findAll();
		return viewCart;
	}
	
	// method implementing to raise Complaint 

	@Override
	public RaiseComplaint raiseCompliant(RaiseComplaint raisecomplaint) {
		RaiseComplaint raise = raiseRepo.saveAndFlush(raisecomplaint);
		return raise;
	}
	
	// method implementing to delete Vegetable by Id

	public Cart deleteVegetablebyId(int vegetableId) throws VegetableIdNotFoundException {
		try {
		cartRepo.deleteById(vegetableId);
		return null;
		}catch (Exception e) {
		
			throw new VegetableIdNotFoundException("Entered Vegetable id is not found");
		}
	}

	@Override
	public Vegetable getById(int vegetableId) throws VegetableIdNotFoundException {
		try {
		Optional<Vegetable> vegetable=vegRepo.findById(vegetableId);
		return vegetable.get();
		}catch (Exception e) {
			throw new VegetableIdNotFoundException("Entered Vegetable id is not found");
		}
	}

	
	

	

	

	

	

	
	

	
	

	
	
	
}
