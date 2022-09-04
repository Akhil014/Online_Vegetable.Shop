package com.onlinevegetableshopping.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinevegetableshopping.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
