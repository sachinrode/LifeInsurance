package com.insurance.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.exception.ResourceNotFoundException;
import com.insurance.model.Claim;
import com.insurance.repository.ClaimRepository;

@Service
public class ClaimServiceImpl implements ClaimService{

	@Autowired
	ClaimRepository claimRepository;
	
	@Override
	public Claim addClaim(Claim claim) {
		return claimRepository.save(claim);
	}

	@Override
	public List<Claim> getAllClaim() {
		return claimRepository.findAll();
	}

	@Override
	public Claim getClaimById(long id) {
		return claimRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Claim", "Id", id));
	}

	@Override
	public Claim updateClaim(Claim claim, long id) {
		Claim cl=claimRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Claim", "Id",id));
		cl.setClaimAmount(claim.getClaimAmount());
		cl.setClaimDate(claim.getClaimDate());
		cl.setStatus(claim.getStatus());
		cl.setPolicy(claim.getPolicy());
		return claimRepository.save(cl);
	}

	@Override
	public Claim deleteClaim(long id) {
        Claim cl=claimRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Claim", "Id", id));
		claimRepository.delete(cl);
        return cl;
	}

}
