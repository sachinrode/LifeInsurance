package com.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.model.Policy;
import com.insurance.service.PolicyService;

@RestController
@RequestMapping("policies")
public class PolicyController {

	@Autowired
	PolicyService policyService;

	@PostMapping("/addPolicy")
	public ResponseEntity<Policy> addPolicy(@RequestBody Policy policy) {
		Policy pol = policyService.addPolicy(policy);
		return ResponseEntity.ok().body(pol);
	}

	@GetMapping("/getAllPolicy")
	public ResponseEntity<List<Policy>> getAllPolicy() {
		List<Policy> pol = policyService.getAllPolicy();
		return ResponseEntity.ok().body(pol);
	}

	@GetMapping("/getPolicyById/{id}")
	public ResponseEntity<Policy> getPolicyById(@PathVariable long id) {
		Policy pol = policyService.getPolicyById(id);
		return ResponseEntity.ok().body(pol);

	}

	@PutMapping("/updatePolicy/{id}")
	public ResponseEntity<Policy> updatePolicy(@RequestBody Policy policy, @PathVariable("id") long id) {
		Policy pol = policyService.updatePolicy(policy, id);
		return ResponseEntity.ok().body(pol);
	}

	@DeleteMapping("deletePolicy/{id}")
	public ResponseEntity<Policy> deletePolicy(@PathVariable("id") long id) {
		Policy pol = policyService.deletePolicy(id);
		return ResponseEntity.ok().body(pol);
	}

}
