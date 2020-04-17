package com.group.NewSouthWalesBuildingCompliance.dao;

import com.group.NewSouthWalesBuildingCompliance.model.Contractor;

import java.util.ArrayList;
import java.util.List;

public class FakeContractorDataAccessService implements ContractorDao {

    private static List<Contractor> ContractorDB = new ArrayList<>();

    @Override
    public int insertContractor(Contractor contractor) {
        ContractorDB.add(new Contractor(Contractor.getLicenceID(), Contractor.getLicenceNumber(), Contractor.getBusinessNames(), Contractor.getCategories(), Contractor.getClasses(), Contractor.getLicenceName(), Contractor.getLicenceType(), Contractor.getLicensee(), Contractor.getPostcode(), Contractor.getStatus(), Contractor.getSuburb()));
        return 1;
    }
}
