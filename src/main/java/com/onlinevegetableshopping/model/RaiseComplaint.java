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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The Class RaiseComplaint is the Entity representing raisecompliant table in
 * database
 * 
 * @author Konasagar, Vijaykumar
 *
 * 
 * 
 * 
 */
@Entity
@Table(name = "raisecomplaint_details")
public class RaiseComplaint {

	@Id
	
	@Column(name = "complaint_id")
	private long complaintId;
	@Column(name = "complaint_description")
	private String complaintDescription;

	/**
	 * RaiseComplaint default constructor
	 */
	public RaiseComplaint() {
		super();

	}

	/**
     * RaiseComplaint constructor with fields as parameters
     *
     * @param complaintId      the complaint Id
     * @param description      the  description of complaint
     * @param users            the complaint of users
     */
	public RaiseComplaint(long complaintId, String complaintDescription) {
		super();
		this.complaintId = complaintId;
		this.complaintDescription = complaintDescription;
	}
	/**
     * gets the complaint Id
     *
     * @return
     */
	public long getComplaintId() {
		return complaintId;
	}
	/**
     * setters for the complaint Id
     *
     * @param complaintId
     */
	public void setComplaintId(long complaintId) {
		this.complaintId = complaintId;
	}
	/**     * gets the Description of complaint     *      * @return     */


	public String getComplaintDescription() {
		return complaintDescription;
	}
	/**
     * setters for the description
     *
     * @param description
     */
	public void setComplaintDescription(String complaintDescription) {
		this.complaintDescription = complaintDescription;
	}

	@Override
	public String toString() {
		return "RaiseComplaint [complaintId=" + complaintId + ", complaintDescription=" + complaintDescription + "]";
	}

}
