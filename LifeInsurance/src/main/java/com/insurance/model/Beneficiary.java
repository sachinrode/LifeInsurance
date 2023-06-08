package com.insurance.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "beneficiaries")
public class Beneficiary {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne
	    @JoinColumn(name = "policy_id")
	    private Policy policy;

	    private String name;

	    private String email;

	    private String relationship;

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

		public String getRelationship() {
			return relationship;
		}

		public void setRelationship(String relationship) {
			this.relationship = relationship;
		}

		@Override
		public String toString() {
			return "Beneficiary [id=" + id + ", policy=" + policy + ", name=" + name + ", email=" + email
					+ ", relationship=" + relationship + "]";
		}
	    
	    
	
}
