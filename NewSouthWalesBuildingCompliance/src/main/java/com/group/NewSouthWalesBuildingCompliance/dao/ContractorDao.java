package com.group.NewSouthWalesBuildingCompliance.dao;

import com.group.NewSouthWalesBuildingCompliance.model.Contractor;

import java.util.List;
import java.util.Optional;

public interface ContractorDao {

    int insertContractor(Contractor contractor);

    List<Contractor> selectAllContractors();

    Optional<Contractor> selectContractorByID(String licenceID);

    int deleteContractorByID(String licenceID);

    int updateContractorByID(String licenceID, Contractor contractor);
}

