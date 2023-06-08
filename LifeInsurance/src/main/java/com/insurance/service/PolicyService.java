package com.insurance.service;

import java.util.List;

import com.insurance.model.Policy;

public interface PolicyService {

	Policy addPolicy(Policy policy);

	List<Policy> getAllPolicy();

	Policy getPolicyById(long id);

	Policy updatePolicy(Policy policy, long id);

	Policy deletePolicy(long id);

}
