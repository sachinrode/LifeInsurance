package com.insurance.service;

import java.util.List;

import com.insurance.model.Claim;

public interface ClaimService {

	Claim addClaim(Claim claim);

	List<Claim> getAllClaim();

	Claim getClaimById(long id);

	Claim updateClaim(Claim claim, long id);

	Claim deleteClaim(long id);

}
