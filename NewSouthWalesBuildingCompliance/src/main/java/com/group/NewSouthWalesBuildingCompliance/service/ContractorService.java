package com.group.NewSouthWalesBuildingCompliance.service;

import com.group.NewSouthWalesBuildingCompliance.dao.ContractorDao;
import com.group.NewSouthWalesBuildingCompliance.model.Contractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractorService {

    private final ContractorDao contractorDao;

    @Autowired
    public ContractorService(@Qualifier("postgres") ContractorDao contractorDao) {
        this.contractorDao = contractorDao;
    }

    public int addContractor(Contractor contractor) {
        return contractorDao.insertContractor(contractor);
    }

    public List<Contractor> getAllContractors() {
        return contractorDao.selectAllContractors();
    }

    public Optional<Contractor> getContractorByID(String licenceID) {
        return contractorDao.selectContractorByID(licenceID);
    }

    public int deleteContractor(String licenceID) {
        return contractorDao.deleteContractorByID(licenceID);
    }

    public int updateContractor(String licenceID, Contractor contractor) {
        return contractorDao.updateContractorByID(licenceID, contractor);
    }
}
