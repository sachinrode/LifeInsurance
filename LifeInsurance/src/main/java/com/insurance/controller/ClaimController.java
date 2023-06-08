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

import com.insurance.model.Claim;
import com.insurance.service.ClaimService;

@RestController
@RequestMapping("Claims")
public class ClaimController {
	
	@Autowired
	ClaimService claimService;
	
	@PostMapping("/addClaim")
	public ResponseEntity<Claim> addClaim(@RequestBody Claim claim) {
		Claim cl = claimService.addClaim(claim);
		return ResponseEntity.ok().body(cl);
	}

	@GetMapping("/getAllClaim")
	public ResponseEntity<List<Claim>> getAllClaim() {
		List<Claim> cl = claimService.getAllClaim();
		return ResponseEntity.ok().body(cl);
	}

	@GetMapping("/getClaimById/{id}")
	public ResponseEntity<Claim> getClaimById(@PathVariable long id) {
		Claim cl = claimService.getClaimById(id);
		return ResponseEntity.ok().body(cl);

	}

	@PutMapping("/updateClaim/{id}")
	public ResponseEntity<Claim> updateClaim(@RequestBody Claim claim, @PathVariable("id") long id) {
		Claim cl = claimService.updateClaim(claim, id);
		return ResponseEntity.ok().body(cl);
	}

	@DeleteMapping("deleteClaim/{id}")
	public ResponseEntity<Claim> deleteClaim(@PathVariable("id") long id) {
		Claim cl = claimService.deleteClaim(id);
		return ResponseEntity.ok().body(cl);
	}


}
