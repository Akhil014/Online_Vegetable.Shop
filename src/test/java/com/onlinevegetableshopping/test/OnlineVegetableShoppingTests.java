package com.onlinevegetableshopping.test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.onlinevegetableshopping.OnlineVegetableShoppingApplication;
import com.onlinevegetableshopping.dao.CartRepository;
import com.onlinevegetableshopping.dao.FeedbackRepository;
import com.onlinevegetableshopping.dao.OrderRepository;
import com.onlinevegetableshopping.dao.RaiseComplaintRepository;
import com.onlinevegetableshopping.dao.RegistrationRepository;
import com.onlinevegetableshopping.dao.UserRepository;
import com.onlinevegetableshopping.dao.VegetableRepository;
import com.onlinevegetableshopping.model.Cart;
import com.onlinevegetableshopping.model.FeedBack;
import com.onlinevegetableshopping.model.Order;
import com.onlinevegetableshopping.model.RaiseComplaint;
import com.onlinevegetableshopping.model.Registrationform;
import com.onlinevegetableshopping.model.User;
import com.onlinevegetableshopping.model.Vegetable;
import com.onlinevegetableshopping.service.AdminService;
import com.onlinevegetableshopping.service.CustomerSupportService;
import com.onlinevegetableshopping.service.RegistrationServiceImpl;
import com.onlinevegetableshopping.service.UserService;



@SpringBootTest(classes=OnlineVegetableShoppingApplication.class)
public class OnlineVegetableShoppingTests {

		@Autowired
		private CustomerSupportService custServe;
		
		@Autowired
		private AdminService adminServe;
		
		@Autowired
		private UserService userServe;
		
		@MockBean
		private VegetableRepository vegRepo;
		
	    private MockMvc mockMvc;

		
		@MockBean
		private FeedbackRepository feedbackRepo;
		
		@MockBean
		private RaiseComplaintRepository complainRepo;
		
		@MockBean
		private UserRepository userRepo;
		
		@MockBean
		private CartRepository cartRepo;
		
		@MockBean
		private OrderRepository orderRepo;
		
		@MockBean
		private RegistrationRepository regRepo;
		
		
		
		/*
		 * Test cases for Admin
		 */
		
		@Test
		public void getVegetableTest()
		{
			when(vegRepo.findAll())
			.thenReturn(Stream.of(new Vegetable(10,"Fruit",10,1)).collect(Collectors.toList()));
			assertEquals(1, adminServe.getAllVegtable().size());
		}
		
		
		@Test
		public void testViewFeedback() {
			when(feedbackRepo.findAll())
			.thenReturn(Stream.of(new FeedBack(101,"Good")).collect(Collectors.toList()));
			assertEquals(1, adminServe.viewFeedbacks().size());
		}
		
		
		@Test
		public void testDeleteVegetables() {
			int id = 112;
			adminServe.deleteVegetables(112);
			verify(vegRepo, times(1)).deleteById(112);
		}
		
		@Test
		public void testAddVegetable(){
	      Vegetable veg = new Vegetable(8,"potato",30,1);		
			Mockito.when(vegRepo.save(veg)).thenReturn(veg);
			String urlTemplate;
			MockHttpServletRequestBuilder mockRequest = (MockHttpServletRequestBuilder) ((Object) MockMvcRequestBuilders.post(urlTemplate="/addveg")
					.content(asJsonString(veg))
	              .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));	
		}
		public static String asJsonString(final Object obj) {
	      try {
	          return new ObjectMapper().writeValueAsString(obj);
	      } catch (Exception e) {
	          throw new RuntimeException(e);
	      }
	  }

		

		
		
		@Test
		public void testViewOrder() {
			
			Cart cart = new Cart();
			
			when(orderRepo.findAll()).thenReturn(Stream.of(new Order(1211, "Pending", "Success", cart)).collect(Collectors.toList()));
			assertEquals(1, adminServe.viewOrders().size());
		}
		
		
		/*
	     * Test Cases for User
	     */

	    @Test
	    public void testViewAllVegtable() {
	        when(vegRepo.findAll()).thenReturn(Stream.of(new Vegetable(111, "Pumkin", 15, 1)).collect(Collectors.toList()));
	        assertEquals(1, userServe.viewAllVegtable().size());
	    }

	    @Test
	    public void testViewCart() {
	        Vegetable veg = new Vegetable(112, "Cucumber", 10, 2);
	        when(cartRepo.findAll()).thenReturn(Stream.of(new Cart(11, 10, "R234", veg)).collect(Collectors.toList()));
	        assertEquals(1, userServe.viewCart().size());
	    }
	    
	    @Test
		public void testGiveFeedback(){
	    	FeedBack feedback = new FeedBack(3,"good");		
			Mockito.when(feedbackRepo.save(feedback)).thenReturn(feedback);
			String urlTemplate;
			MockHttpServletRequestBuilder mockRequest = (MockHttpServletRequestBuilder) ((Object) MockMvcRequestBuilders.post(urlTemplate="/feedback")
					.content(asJsonString2(feedback))
	              .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));	
		}
		public static String asJsonString2(final Object obj) {
	      try {
	          return new ObjectMapper().writeValueAsString(obj);
	      } catch (Exception e) {
	          throw new RuntimeException(e);
	      }
	  }
	    
		 @Test
			public void testRaiseComplaint(){
			 RaiseComplaint raisecomplaint = new RaiseComplaint(3,"quality is unsatisfaction");		
				Mockito.when(complainRepo.save(raisecomplaint)).thenReturn(raisecomplaint);
				String urlTemplate;
				MockHttpServletRequestBuilder mockRequest = (MockHttpServletRequestBuilder) ((Object) MockMvcRequestBuilders.post(urlTemplate="/raise")
						.content(asJsonString3(raisecomplaint))
		              .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));	
			}
			public static String asJsonString3(final Object obj) {
		      try {
		          return new ObjectMapper().writeValueAsString(obj);
		      } catch (Exception e) {
		          throw new RuntimeException(e);
		      }
		  }
			
			 @Test
			    public void testaddvegetableToCart(){
			        //Cart carts= userServe.addvegetableToCart(cart);
			      Cart carts = new Cart();        
			        Mockito.when(userRepo.save(carts)).thenReturn(userRepo);
			        String urlTemplate;
			        MockHttpServletRequestBuilder mockRequest = (MockHttpServletRequestBuilder) ((Object) MockMvcRequestBuilders.post(urlTemplate="/addcart")
			                .content(asJsonString4(carts)));
			             // .contentType(MediaType.APPLICATION_XML_UTF_8).accept(MediaType.APPLICATION_XML_UTF_8));    
			    }
			    public static String asJsonString4(final Object obj) {
			      try {
			          return new ObjectMapper().writeValueAsString(obj);
			      } catch (Exception e) {
			          throw new RuntimeException(e);
			      }
			  }
	  

		

		/*
	     * Test Cases for Cart
	     */

		
		@Test
		public void testMakeOrder(){
	      Order order = new Order(2025,"Your order is on the way","payment failed", null);		
			Mockito.when(orderRepo.save(order)).thenReturn(order);
			String urlTemplate;
			MockHttpServletRequestBuilder mockRequest = (MockHttpServletRequestBuilder) ((Object) MockMvcRequestBuilders.post(urlTemplate="/makeorder")
					.content(asJsonString(order))
	              .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));	
		}
		public static String asJsonString1(final Object obj) {
	      try {
	          return new ObjectMapper().writeValueAsString(obj);
	      } catch (Exception e) {
	          throw new RuntimeException(e);
	      }
	  }
		
		/*
	     * Test Cases for Registration
	     */
	    @Test
	    public void testAddRegistration(){
	      Registrationform reg = new Registrationform(1,"14th ward subhash nagar","Sandur","Sanjana","sanju@123","Karnataka");        
	        Mockito.when(regRepo.save(reg)).thenReturn(reg);
	        String urlTemplate;
	        MockHttpServletRequestBuilder mockRequest = (MockHttpServletRequestBuilder) ((Object) MockMvcRequestBuilders.post(urlTemplate="/addreg")
	                .content(asJsonString5(reg)));
	                //.contentType(MediaType.APPLICATION_XML_UTF_8).accept(MediaType.APPLICATION_XML_UTF_8));    
	    }
	    public static String asJsonString5(final Object obj) {
	      try {
	          return new ObjectMapper().writeValueAsString(obj);
	      } catch (Exception e) {
	          throw new RuntimeException(e);
	      }
	  }
	    
	

}
