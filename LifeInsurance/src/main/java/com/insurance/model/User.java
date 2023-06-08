package com.insurance.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;

	    private String email;

	    private LocalDate dateOfBirth;

	    private String address;

	    private String policyNumber;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
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

		public LocalDate getDateOfBirth() {
			return dateOfBirth;
		}

		public void setDateOfBirth(LocalDate dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getPolicyNumber() {
			return policyNumber;
		}

		public void setPolicyNumber(String policyNumber) {
			this.policyNumber = policyNumber;
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", name=" + name + ", email=" + email + ", dateOfBirth=" + dateOfBirth
					+ ", address=" + address + ", policyNumber=" + policyNumber + "]";
		}
	    
	    
}
