package com.onlinevegetableshopping.model;

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
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * The Class User is the Entity representing User table in database
 * 
 * @author Das, Smrutiranjan
 *
 */
@Entity
@Table(name = "user_details")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private long userId;
    @NotBlank(message = "Name is mandatory")
	@Column(name = "user_name")
	private String userName;
	@Column(name = "user_password")
	private String userPassword;

	@OneToMany(targetEntity = RaiseComplaint.class)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "complaint_id")
	private Set<RaiseComplaint> raiseComplaint;

	@OneToMany(targetEntity = FeedBack.class)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "feedback_id")
	private Set<FeedBack> feedback;

	@ManyToOne(targetEntity = Order.class)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "order_id")
	private Order order;

	/**
	 * User default constructor
	 */
	public User() {
		super();

	}

	/**
     * User constructor with fields as parameters
     *
     * @param Id        the Id of user
     * @param name      the name of user
     * @param password   the password of user
     * @param orders      the orders by user
     */
	public User(long userId, String userName, String userPassword, Set<RaiseComplaint> raiseComplaint,
			Set<FeedBack> feedback, Order order) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.raiseComplaint = raiseComplaint;
		this.feedback = feedback;
		this.order = order;
	}

	 /**
     * gets the Id of user
     *
     * @return
     */
	public long getUserId() {
		return userId;
	}

	/**
     * setters for the Id of user
     *
     * @param id
     */
	public void setUserId(long userId) {
		this.userId = userId;
	}

	/**     * gets the name user     *      * @return     */


	public String getUserName() {
		return userName;
	}

	/**
     * setters for the user name
     *
     * @param name
     */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**     * gets the user password     *      * @return     */


	public String getUserPassword() {
		return userPassword;
	}

	/**
     * setters for the user password
     *
     * @param password
     */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Set<RaiseComplaint> getRaiseComplaint() {
		return raiseComplaint;
	}

	public void setRaiseComplaint(Set<RaiseComplaint> raiseComplaint) {
		this.raiseComplaint = raiseComplaint;
	}

	public Set<FeedBack> getFeedback() {
		return feedback;
	}

	public void setFeedback(Set<FeedBack> feedback) {
		this.feedback = feedback;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", raiseComplaint=" + raiseComplaint + ", feedback=" + feedback + ", order=" + order + "]";
	}

}
