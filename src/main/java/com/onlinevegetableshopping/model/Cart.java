package com.onlinevegetableshopping.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The Class Cart is the Entity representing Cart table in database
 * 
 * @author Salunke, Sanjana
 *
 * 
 * 
 * 
 */

@Entity
@Table(name = "cart_details")
public class Cart implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_id")
	private long cartId;
	@Column(name = "total_bill")
	private long totalBill;
	@Column(name = "invoice")
	private String invoice;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(targetEntity = Vegetable.class)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "vegetable_id")
	private Vegetable vegetable;

	/**
	 * Cart default constructor
	 */

	public Cart() {
		super();

	}

	/**
     * Cart constructor with fields as parameters
     *
     * @param cartuserId      the cart Id
     * @param totalBill      the  total bill of cart
     * @param invoice     the invoice of cart
     * @param vegetables   the vegetables of cart
     */
	public Cart(long cartId, long totalBill, String invoice, Vegetable vegetable) {
		super();
		this.cartId = cartId;
		this.totalBill = totalBill;
		this.invoice = invoice;
		this.vegetable = vegetable;
	}

	/**
	* gets the Cart Id
	*
	* @return
	*/
	public long getCartId() {
		return cartId;
	}

	/**
	* setters for the Cart Id
	*
	* @param cartuserId
	*/
	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	/**
	* gets the cart totalbill
	*
	* @return
	*/
	public long getTotalBill() {
		return totalBill;
	}

	/**
	* setters for the cart totalbill
	*
	* @param totalBill
	*/
	public void setTotalBill(long totalBill) {
		this.totalBill = totalBill;
	}

	/**
	* gets the cart invoice
	*
	* @return
	*/
	public String getInvoice() {
		return invoice;
	}

	/**
	* setters for the cart invoice
	*
	* @param invoice
	*/
	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

	/**
	* gets the cart vegetables
	*
	* @return
	*/
	public Vegetable getVegetable() {
		return vegetable;
	}

	/**
	* setters for the cart vegetables
	*
	* @param vegetables
	*/


	public void setVegetable(Vegetable vegetable) {
		this.vegetable = vegetable;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", totalBill=" + totalBill + ", invoice=" + invoice + ", vegetable="
				+ vegetable + "]";
	}

}
