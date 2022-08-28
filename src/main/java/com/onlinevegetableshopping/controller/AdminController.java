package com.onlinevegetableshopping.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinevegetableshopping.exception.OrderIdNotFoundException;
import com.onlinevegetableshopping.exception.UserIdNotFoundException;
import com.onlinevegetableshopping.exception.VegetableIdNotFoundException;
import com.onlinevegetableshopping.model.FeedBack;
import com.onlinevegetableshopping.model.Order;
import com.onlinevegetableshopping.model.RaiseComplaint;
import com.onlinevegetableshopping.model.User;
import com.onlinevegetableshopping.model.Vegetable;
import com.onlinevegetableshopping.service.AdminService;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adServe;

	/*
	 * Controller for the requests related to the Vegetable store
	 */

	// requests the controller to add vegetable in vegetable store

	// http://localhost:8091/onlinevegetableshopping/admin/addveg

	@PostMapping("/addveg")
	public ResponseEntity<Vegetable> addveg(@RequestBody Vegetable vegetable) {
		adServe.addVegetables(vegetable);
		return new ResponseEntity("vegetable added", HttpStatus.OK);

	}

	// requests the controller to delete by vegetable id in vegetable store

	// http://localhost:8091/onlinevegetableshopping/admin/deletebyid/

	@DeleteMapping("/deletebyid/{vegetableId}")
	public ResponseEntity<Vegetable> deleteVegById(@PathVariable("vegetableId") Integer vegetableId) throws VegetableIdNotFoundException {
		adServe.deleteVegetables(vegetableId);
		return new ResponseEntity("Vegetable Deleted", HttpStatus.OK);

	}

	// requests the controller to update vegetable in vegetable store

	// http://localhost:8091/onlinevegetableshopping/admin/update/

	@PutMapping("/update/{vegetableId}")
	public ResponseEntity<Vegetable> updateVegetable(@PathVariable("vegetableId") Integer vegetableId,  @RequestBody Vegetable vegetable ) throws VegetableIdNotFoundException  {
		Vegetable updateveg = adServe.updateVegetables(vegetableId,vegetable);

		return new ResponseEntity("Vegetable updated successfully", HttpStatus.OK);

	}

	// requests the controller to get all vegetable from vegetable store

	// http://localhost:8091/onlinevegetableshopping/admin/allveg

	@GetMapping("/allveg")
	public ResponseEntity<List<Vegetable>> getAllVegetable() {
		List<Vegetable> vegList = adServe.getAllVegtable();
		if (vegList.isEmpty()) {
			return new ResponseEntity("Sorry no vegetable list found!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Vegetable>>(vegList, HttpStatus.OK);

	}

	/*
	 * Controller for the requests related to the Raise Complaint
	 */

	// requests the controller to view all complaint raised by user

	// http://localhost:8091/onlinevegetableshopping/admin/viewallraise

	@GetMapping("/viewallraise")
	public ResponseEntity<List<RaiseComplaint>> viewCompliant() {
		List<RaiseComplaint> raisecomplaint = adServe.viewComplaints();
		return new ResponseEntity<List<RaiseComplaint>>(raisecomplaint, HttpStatus.OK);

	}

	/*
	 * Controller for the requests related to the feedback
	 */
	// requests the controller to view all feedback given by user

	// http://localhost:8091/onlinevegetableshopping/admin/viewfeedback

	@GetMapping("/viewfeedback")
	public ResponseEntity<List<FeedBack>> viewFeedback() {
		List<FeedBack> viewfeedback = adServe.viewFeedbacks();
		return new ResponseEntity(viewfeedback, HttpStatus.OK);

	}

	/*
	 * Controller for the requests related to the Order
	 */
	// requests the controller to view all order by user

	// http://localhost:8091/onlinevegetableshopping/admin/vieworder
	@GetMapping("/vieworder")
	public ResponseEntity<List<Order>> viewOrders() {
		List<Order> viewOrder = adServe.viewOrders();
		return new ResponseEntity(viewOrder, HttpStatus.OK);

	}

	
	/*
	 * Controller for the requests related to the Vegetable
	 */
	// requests the controller to view vegetable by vegetableid
	// localhost:8091/onlinevegetableshopping/user/vegbyid/
	@GetMapping("/vegbyid/{vegetableId}")
	public ResponseEntity getVegById(@PathVariable("vegetableId") int vegetableId) throws VegetableIdNotFoundException {
		Vegetable veg = adServe.getById(vegetableId);
		return new ResponseEntity<Object>(veg, HttpStatus.OK);

	}
	
	/*
	 * Controller for the requests related to the Order
	 */
	// requests the controller to view order by orderid

	// localhost:8091/onlinevegetableshopping/admin/orderbyid/
	@GetMapping("/orderbyid/{ordreId}")
	public ResponseEntity geOrderById(@PathVariable("ordreId") Integer ordreId) throws OrderIdNotFoundException {
		Order order = adServe.getOrderById(ordreId);
		return new ResponseEntity<Object>(order, HttpStatus.OK);

	}

	/*
	 * Controller for the requests related to the User
	 */
	// requests the controller to view user by userid
	// localhost:8091/onlinevegetableshopping/admin/userbyid/
	@GetMapping("/userbyid/{userId}")
	public ResponseEntity geUserById(@PathVariable("userId") Integer userId) throws UserIdNotFoundException{
		User user = adServe.viewUserById(userId);
		return new ResponseEntity<Object>(user, HttpStatus.OK);

	}

}
