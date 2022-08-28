package com.onlinevegetableshopping.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The Class Vegetable is the Entity representing Vegetables table in database
 * 
 * @author Khan, Saif
 *
 */
@Entity
@Table(name = "vegetable_details")
public class Vegetable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "vegetable_id")
	private int vegetableId;
	@NotBlank(message = "Name is mandatory")
	@Column(name = "vegetable_name")
	private String vegetableName;
	@Column(name = "vegetable_price")
	private double vegetablePrice;
	@Column(name = "vegetable_quantity")
	private int vegetableQuantity;

	/**
	 * Vegetable default constructor
	 */

	public Vegetable() {
		super();

	}

	/**
     * Vegetable constructor with fields as parameters
     *
     * @param id      the vegetable id
     * @param nameame      the  name of vegetable
     * @param price      the price of vegetable
     * @param quantity   the quantity of vegetable
     */
	public Vegetable(int vegetableId, @NotBlank(message = "Name is mandatory") String vegetableName,
			double vegetablePrice, int vegetableQuantity) {
		super();
		this.vegetableId = vegetableId;
		this.vegetableName = vegetableName;
		this.vegetablePrice = vegetablePrice;
		this.vegetableQuantity = vegetableQuantity;
	}

	/**
     * gets the id of vegetable
     *
     * @return
     */
	public int getVegetableId() {
		return vegetableId;
	}

	/**
     * setters for the id of vegetable
     *
     * @param id
     */
	public void setVegetableId(int vegetableId) {
		this.vegetableId = vegetableId;
	}
	/**     * gets the name vegetable     *      * @return     */


	public String getVegetableName() {
		return vegetableName;
	}
	/**
     * setters for the user vegetable
     *
     * @param name
     */
	public void setVegetableName(String vegetableName) {
		this.vegetableName = vegetableName;
	}
	/**
     * gets the vegetable price
     *
     * @return
     */
	public double getVegetablePrice() {
		return vegetablePrice;
	}
	 /**
     * setters for the vegetable price
     *
     * @param price
     */
	public void setVegetablePrice(double vegetablePrice) {
		this.vegetablePrice = vegetablePrice;
	}
	/**
     * gets the vegetable quantity
     *
     * @return
     */
	public int getVegetableQuantity() {
		return vegetableQuantity;
	}
	/**
     * setters for the vegetable quantity
     *
     * @param quantity
     */
	public void setVegetableQuantity(int vegetableQuantity) {
		this.vegetableQuantity = vegetableQuantity;
	}

	@Override
	public String toString() {
		return "Vegetable [vegetableId=" + vegetableId + ", vegetableName=" + vegetableName + ", vegetablePrice="
				+ vegetablePrice + ", vegetableQuantity=" + vegetableQuantity + "]";
	}

	

	

}
