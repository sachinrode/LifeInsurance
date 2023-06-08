package com.insurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.exception.ResourceNotFoundException;
import com.insurance.model.Beneficiary;
import com.insurance.repository.BeneficiaryRepository;

@Service
public class BeneficiaryServiceImlp implements BeneficiaryService{

	@Autowired
	BeneficiaryRepository beneficiaryRepo;
	
	@Override
	public Beneficiary addBeneficiary(Beneficiary beneficiary) {
		return beneficiaryRepo.save(beneficiary);
	}

	@Override
	public List<Beneficiary> getAllBeneficiary() {
		return beneficiaryRepo.findAll();
	}

	@Override
	public Beneficiary getBeneficiaryById(long id) {
		return beneficiaryRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Beneficiary", "Id", id));
	
	}

	@Override
	public Beneficiary updateBeneficiary(Beneficiary beneficiary, long id) {
        Beneficiary ben=beneficiaryRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Beneficiary", "Id", id));
		ben.setName(beneficiary.getName());
		ben.setEmail(beneficiary.getEmail());
		ben.setPolicy(beneficiary.getPolicy());
		ben.setRelationship(beneficiary.getRelationship());
         return beneficiaryRepo.save(ben);
	}

	@Override
	public Beneficiary deleteBeneficiary(long id) {
		Beneficiary ben=beneficiaryRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Beneficiary", "Id", id));
		beneficiaryRepo.delete(ben);
		return ben;
	}

}
