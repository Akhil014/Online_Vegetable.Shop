package com.onlinevegetableshopping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinevegetableshopping.dao.AdminRepository;
import com.onlinevegetableshopping.dao.FeedbackRepository;
import com.onlinevegetableshopping.dao.OrderRepository;
import com.onlinevegetableshopping.dao.RaiseComplaintRepository;
import com.onlinevegetableshopping.dao.UserRepository;
import com.onlinevegetableshopping.dao.VegetableRepository;
import com.onlinevegetableshopping.exception.OrderIdNotFoundException;
import com.onlinevegetableshopping.exception.UserIdNotFoundException;
import com.onlinevegetableshopping.exception.VegetableIdNotFoundException;
import com.onlinevegetableshopping.model.FeedBack;
import com.onlinevegetableshopping.model.Order;
import com.onlinevegetableshopping.model.RaiseComplaint;
import com.onlinevegetableshopping.model.User;
import com.onlinevegetableshopping.model.Vegetable;

@Service
public class AdminServiceImpl implements AdminService{

	

	// connecting the service implementation with the Vegetable repository
	
	@Autowired
	private VegetableRepository vegRepo;
	
	// connecting the service implementation with the RaiseCompliant repository

	@Autowired
	private RaiseComplaintRepository raiseRepo;
	
	// connecting the service implementation with the Feedback repository

	@Autowired
	private FeedbackRepository feedbackRepo;
	
	// connecting the service implementation with the Order repository

	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private UserRepository userRepo;

	// method implementing to add Vegetable in Vegetable Store

	@Override
	public Vegetable addVegetables(Vegetable vegetable) {
		Vegetable veg= vegRepo.saveAndFlush(vegetable);
		return veg;
	}
	// method implementing to delete Vegetable in Vegetable Store

	@Override
	public Vegetable deleteVegetables(int vegetableId) throws VegetableIdNotFoundException {
		try {
		 vegRepo.deleteById(vegetableId);
		return null;
		}catch (Exception e) {
			throw new VegetableIdNotFoundException("Entered Vegetable id is not found");
		}
	}
	
	// method implementing to update Vegetable in Vegetable Store

	@Override
	public Vegetable updateVegetables(int vegetableId,Vegetable vegetable) {
		 Optional<Vegetable> vegetables=vegRepo.findById(vegetableId);
         if(!vegetables.isPresent())throw new  VegetableIdNotFoundException("invalid id found");
         Vegetable veg=vegRepo.getById(vegetableId);
         
         
         if(vegetable.getVegetableName()!=null)
        	 veg.setVegetableName(vegetable.getVegetableName());
         if(vegetable.getVegetablePrice()!=0)
        	 veg.setVegetablePrice(vegetable.getVegetablePrice());
         if(vegetable.getVegetableQuantity()!=0)
        	 veg.setVegetableQuantity(vegetable.getVegetableQuantity());
        	
         Vegetable updatedveg=vegRepo.save(veg);
         
         
         
         return updatedveg;   
     
	}

	// method implementing to get all Vegetable form Vegetable Store

	@Override
	public List<Vegetable> getAllVegtable() {
		
		return vegRepo.findAll();
	}
	
	// method implementing to view all Complaint raised by user

	@Override
	public List<RaiseComplaint> viewComplaints() {
		
		return raiseRepo.findAll();
	}
	
	// method implementing to view all FeedBack given by user

	@Override
	public List<FeedBack> viewFeedbacks() {
		
		return feedbackRepo.findAll();
	}
	
	// method implementing to view all Order details which are ordered by user

	@Override
	public List<Order> viewOrders() {
		
		return orderRepo.findAll();
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

	@Override
	public Order getOrderById(int orderId) throws OrderIdNotFoundException{
		try {
		Optional<Order> orderById=orderRepo.findById(orderId);
		return orderById.get();
		}catch (Exception e) {
			throw new OrderIdNotFoundException("Entered order id is not found");
		}
	}

	@Override
	public User viewUserById(int userId) throws UserIdNotFoundException{
		try {
		Optional<User> user=userRepo.findById(userId);
		return user.get();
		}catch (Exception e) {
			throw new UserIdNotFoundException("Entered user id is not found");
		}
	}

	

	
	
	
	
	
	
}
