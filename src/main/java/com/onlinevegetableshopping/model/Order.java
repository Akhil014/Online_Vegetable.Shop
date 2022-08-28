package com.onlinevegetableshopping.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The Class Order is the Entity representing Order table in database
 * 
 * @author Kavya
 *
 * 
 * 
 * 
 */
@Entity
@Table(name = "order_details")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private long orderId;
    @NotBlank(message = "deliverStatus is mandatory to mention")
	@Column(name = "deliver_status")
	private String deliverStatus;
	@Column(name = "payment_status")
	private String paymentStatus;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(targetEntity = Cart.class)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "cart_id")
	private Cart cart;

	/**
	 * Order default constructor
	 */
	public Order() {
		super();

	}

	/**
     * Order constructor with fields as parameters
     *
     * @param orderId       the order Id
     * @param deliverStatus the status of order
     * @param paymentStatus the status of payment
     * @param cart          the cart of order
     */
	public Order(long orderId, String deliverStatus, String paymentStatus, Cart cart) {
		super();
		this.orderId = orderId;
		this.deliverStatus = deliverStatus;
		this.paymentStatus = paymentStatus;
		this.cart = cart;
	}

	/**
     * gets the Order Id
     *
     * @return
     */
	public long getOrderId() {
		return orderId;
	}

	/**
     * setters for the order Id
     *
     * @param orderId
     */
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	/**
     * gets the deliverstatus of order
     *
     * @return
     */
	public String getDeliverStatus() {
		return deliverStatus;
	}

	/**
     * setters for the deliverstatus
     *
     * @param deliverstatus
     */
	public void setDeliverStatus(String deliverStatus) {
		this.deliverStatus = deliverStatus;
	}

	/**
     * gets the paymentstatus of order
     *
     * @return
     */
	public String getPaymentStatus() {
		return paymentStatus;
	}

	/**
     * setters for the paymentstatus of order
     *
     * @param paymentstatus
     */
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	/**
     * gets the cart of order
     *
     * @return
     */
	public Cart getCart() {
		return cart;
	}

	/**
     * setters for the cart of order
     *
     * @param cart
     */
	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", deliverStatus=" + deliverStatus + ", paymentStatus=" + paymentStatus
				+ ", cart=" + cart + "]";
	}

}
