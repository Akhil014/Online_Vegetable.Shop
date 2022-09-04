package com.onlinevegetableshopping.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.onlinevegetableshopping.dao.CartRepository;
import com.onlinevegetableshopping.dao.FeedbackRepository;
import com.onlinevegetableshopping.dao.RaiseComplaintRepository;
import com.onlinevegetableshopping.dao.VegetableRepository;
import com.onlinevegetableshopping.exception.VegetableIdNotFoundException;
import com.onlinevegetableshopping.model.Cart;
import com.onlinevegetableshopping.model.FeedBack;
import com.onlinevegetableshopping.model.RaiseComplaint;
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
		
		return feedbackRepo.saveAndFlush(feedback);
	}

	// method implementing to view all Vegetable

	public List<Vegetable> viewAllVegtable() {
		return vegRepo.findAll();
	}

	// method implementing to add vegetable to Cart

	@Override
	public Cart addvegetableToCart(Cart cart) {
		return cartRepo.saveAndFlush(cart);
	}
	
	// method implementing to view Cart

	public List<Cart> viewCart() {
		
		return cartRepo.findAll();
	}
	
	// method implementing to raise Complaint 

	@Override
	public RaiseComplaint raiseCompliant(RaiseComplaint raisecomplaint) {
		return raiseRepo.saveAndFlush(raisecomplaint);
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
	public boolean getById(int vegetableId) throws VegetableIdNotFoundException {
		try {
		Optional<Vegetable> vegetable=vegRepo.findById(vegetableId);
		return vegetable.isPresent();
		}catch (Exception e) {
			throw new VegetableIdNotFoundException("Entered Vegetable id is not found");
		}
	}

	
	

	

	

	

	

	
	

	
	

	
	
	
}
