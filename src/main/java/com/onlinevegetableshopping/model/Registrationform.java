package com.onlinevegetableshopping.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * The Class Registration form is the Entity representing Registrationform table
 * in database
 * 
 * @author Inamdar Akhil
 *
 */
@Entity
@Table(name = "registration_details")
public class Registrationform {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "registration_id")
	private long userId;
	@NotBlank(message = "Name is mandatory")
	@Column(name = "user_Name")
	private String userName;
	@Column(name = "user_Password")
	private String userPassword;
	@Column(name = "user_Address")
	private String userAddress;
	@Column(name = "user_City")
	private String userCity;
	@Column(name = "user_State")
	private String userState;

	/**
	 * Registration default constructor
	 */
	public Registrationform() {
		super();

	}
	/**
     * Registrationform constructor with fields as parameters
     *
     * @param registration_id      the registration_id
     *
     */
	public Registrationform(long userId, String userName, String userPassword, String userAddress, String userCity,
			String userState) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userAddress = userAddress;
		this.userCity = userCity;
		this.userState = userState;
	}



	public long getUserId() {
		return userId;
	}
	 /**
     * setters for the  Id
     *
     * @param Id
     */
	public void setUserId(long userId) {
		this.userId = userId;
	}
	/**     * gets the  userName     *      * @return     */


	public String getUserName() {
		return userName;
	}
	/**
     * setters for the  name
     *
     * @param name
     */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
     * gets the Password
     *
     * @return
     */
	public String getUserPassword() {
		return userPassword;
	}
	 /**
     * setters for the  password
     *
     * @param password
     */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	 /**
     * gets the  address
     *
     * @return
     */
	public String getUserAddress() {
		return userAddress;
	}
	/**
     * setters for the  address
     *
     * @param address
     */
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	/**
     * gets the  city
     *
     * @return
     */
	public String getUserCity() {
		return userCity;
	}
	/**
     * setters for the  city
     *
     * @param city
     */
    
	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}
	 /**
     * gets the  state
     *
     * @return
     */
	public String getUserState() {
		return userState;
	}
	/**
     * setters for the  state
     *
     * @param state
     */
	public void setUserState(String userState) {
		this.userState = userState;
	}

	@Override
	public String toString() {
		return "Registrationform [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", userAddress=" + userAddress + ", userCity=" + userCity + ", userState=" + userState + "]";
	}

}
