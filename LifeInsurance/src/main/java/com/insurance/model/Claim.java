package com.insurance.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "claims")
public class Claim {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne
	    @JoinColumn(name = "policy_id")
	    private Policy policy;

	    private LocalDate claimDate;

	    private double claimAmount;

	    private String status;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Policy getPolicy() {
			return policy;
		}

		public void setPolicy(Policy policy) {
			this.policy = policy;
		}

		public LocalDate getClaimDate() {
			return claimDate;
		}

		public void setClaimDate(LocalDate claimDate) {
			this.claimDate = claimDate;
		}

		public double getClaimAmount() {
			return claimAmount;
		}

		public void setClaimAmount(double claimAmount) {
			this.claimAmount = claimAmount;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		@Override
		public String toString() {
			return "Claim [id=" + id + ", policy=" + policy + ", claimDate=" + claimDate + ", claimAmount="
					+ claimAmount + ", status=" + status + "]";
		}
	    
		
	    
	    
}
