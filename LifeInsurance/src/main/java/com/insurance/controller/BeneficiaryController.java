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

import com.insurance.model.Beneficiary;
import com.insurance.service.BeneficiaryService;

@RestController
@RequestMapping("beneficiaries")
public class BeneficiaryController {

	@Autowired
	BeneficiaryService beneficiaryService;
	
	@PostMapping("/addBeneficiary")
	public ResponseEntity<Beneficiary> addBeneficiary(@RequestBody Beneficiary beneficiary) {
		Beneficiary ben = beneficiaryService.addBeneficiary(beneficiary);
		return ResponseEntity.ok().body(ben);
	}

	@GetMapping("/getAllBeneficiary")
	public ResponseEntity<List<Beneficiary>> getAllBeneficiary() {
		List<Beneficiary> ben = beneficiaryService.getAllBeneficiary();
		return ResponseEntity.ok().body(ben);
	}

	@GetMapping("/getBeneficiaryById/{id}")
	public ResponseEntity<Beneficiary> getBeneficiaryById(@PathVariable long id) {
		Beneficiary ben = beneficiaryService.getBeneficiaryById(id);
		return ResponseEntity.ok().body(ben);

	}

	@PutMapping("/updateBeneficiary/{id}")
	public ResponseEntity<Beneficiary> updateBeneficiary(@RequestBody Beneficiary beneficiary, @PathVariable("id") long id) {
		Beneficiary ben = beneficiaryService.updateBeneficiary(beneficiary, id);
		return ResponseEntity.ok().body(ben);
	}

	@DeleteMapping("deleteBeneficiary/{id}")
	public ResponseEntity<Beneficiary> deleteBeneficiary(@PathVariable("id") long id) {
		Beneficiary ben = beneficiaryService.deleteBeneficiary(id);
		return ResponseEntity.ok().body(ben);
	}

	
}
