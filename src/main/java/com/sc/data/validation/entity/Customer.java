
package com.sc.data.validation.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
@Entity
public class Customer {
	
	   @Id
	   @Column
	   @GeneratedValue(strategy = GenerationType.AUTO)
	   private int id;
	   
	   private String name;
	   
	   private String email;
	   
	   private String phone;
	   
	   private String ssn;
	   
	   public Customer() {}
	   
	   public Customer(String name, String email, String phone, String ssn) {
		   this.name = name;
		   this.email=email;
		   this.phone=phone;
		   this.ssn=ssn;
				  
				   
	   }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public int getId() {
		return id;
	}
	   
	   

}
