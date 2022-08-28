package com.onlinevegetableshopping.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinevegetableshopping.model.Admin;
import com.onlinevegetableshopping.model.Vegetable;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer>{

}
