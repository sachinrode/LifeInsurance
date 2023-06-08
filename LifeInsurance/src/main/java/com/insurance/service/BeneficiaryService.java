package com.insurance.service;

import java.util.List;

import com.insurance.model.Beneficiary;

public interface BeneficiaryService {

	Beneficiary addBeneficiary(Beneficiary beneficiary);

	List<Beneficiary> getAllBeneficiary();

	Beneficiary getBeneficiaryById(long id);

	Beneficiary updateBeneficiary(Beneficiary beneficiary, long id);

	Beneficiary deleteBeneficiary(long id);

}
