package com.onlinevegetableshopping.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.onlinevegetableshopping.model.FeedBack;

@Service
public interface FeedBackService {
	//method for managing feedbacks given by the Instructor
			public List<FeedBack> getAllFeedbacks();
			
}
