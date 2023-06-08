package com.insurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.exception.ResourceNotFoundException;
import com.insurance.model.Policy;
import com.insurance.repository.PolicyRepository;

@Service
public class PolicyServiceImpl implements PolicyService{

	@Autowired
	PolicyRepository policRepository;
	
	@Override
	public Policy addPolicy(Policy policy) {
		return policRepository.save(policy);
	}

	@Override
	public List<Policy> getAllPolicy() {
		return policRepository.findAll();
	}

	@Override
	public Policy getPolicyById(long id) {
	    return policRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Policy", "Id", id));
		
	}

	@Override
	public Policy updatePolicy(Policy policy, long id) {
	Policy pol=policRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Policy", "Id", id));
	pol.setUser(policy.getUser());
	pol.setStartDate(policy.getStartDate());
	pol.setEndDate(policy.getEndDate());
	pol.setPremiumAmount(policy.getPremiumAmount());
	pol.setCoverageAmount(policy.getCoverageAmount());
	pol.setBeneficiaries(policy.getBeneficiaries());
	return policRepository.save(pol);
	}

	@Override
	public Policy deletePolicy(long id) {
        Policy pol=policRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Policy", "Id", id));
		policRepository.delete(pol);
        return pol;
	}

}
