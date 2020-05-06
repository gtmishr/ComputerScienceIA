package com.group.NewSouthWalesBuildingCompliance.dao;

import com.group.NewSouthWalesBuildingCompliance.model.Contractor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("fakeDao")
public class FakeContractorDataAccessService implements ContractorDao {

    private static List<Contractor> ContractorDB = new ArrayList<>();

    @Override
    public int insertContractor(Contractor contractor) {
        ContractorDB.add(new Contractor(
                contractor.getLicenceID(),
                contractor.getLicenceNumber(),
                contractor.getBusinessNames(),
                contractor.getCategories(),
                contractor.getClasses(),
                contractor.getLicenceName(),
                contractor.getLicenceType(),
                contractor.getLicensee(),
                contractor.getPostcode(),
                contractor.getStatus(),
                contractor.getSuburb()));
        return 1;
    }

    @Override
    public List<Contractor> selectAllContractors() {
        return ContractorDB;
    }

    @Override
    public Optional<Contractor> selectContractorByID(String licenceID) {
        return ContractorDB.stream()
                .filter(contractor -> contractor.getLicenceID().equals(licenceID))
                .findFirst();
    }

    @Override
    public int deleteContractorByID(String licenceID) {
        Optional<Contractor> possibleContractor = selectContractorByID(licenceID);
        if (possibleContractor.isPresent()) {
            ContractorDB.remove(possibleContractor.get());
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int updateContractorByID(String licenceID, Contractor update) {
        return selectContractorByID(licenceID)
                .map(contractor -> {
                    int indexOfContractorToUpdate = ContractorDB.indexOf(contractor);
                    if (indexOfContractorToUpdate >= 0) {
                        ContractorDB.set(indexOfContractorToUpdate, new Contractor(licenceID, update.getLicenceNumber(), update.getBusinessNames(), update.getCategories(), update.getClasses(), update.getLicenceName(), update.getLicenceType(), update.getLicensee(), update.getPostcode(), update.getStatus(), update.getSuburb()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
