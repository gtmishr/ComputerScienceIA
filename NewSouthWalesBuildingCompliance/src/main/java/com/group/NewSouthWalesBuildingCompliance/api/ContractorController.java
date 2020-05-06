package com.group.NewSouthWalesBuildingCompliance.api;

import com.group.NewSouthWalesBuildingCompliance.model.Contractor;
import com.group.NewSouthWalesBuildingCompliance.service.ContractorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/contractor")
@RestController
public class ContractorController {

    private final ContractorService contractorService;

    @Autowired
    public ContractorController(ContractorService contractorService) {
        this.contractorService = contractorService;
    }

    @PostMapping
    public void addContractor(@NonNull @RequestBody Contractor contractor) {
        contractorService.addContractor(contractor);
    }

    @GetMapping
    public List<Contractor> getAllContractors() {
        return contractorService.getAllContractors();
    }

    @GetMapping(path = "{ID}")
    public Contractor getContractorByID(@PathVariable("ID") String licenceID) {
        return contractorService.getContractorByID(licenceID)
                .orElse(null);
    }

    @DeleteMapping(path = "{ID}")
    public void deleteContractorByID(@PathVariable("ID") String licenceID) {
        contractorService.deleteContractor(licenceID);
    }

    @PutMapping(path = "{ID}")
    public void updateContractor(@PathVariable("ID") String licenceID, @NonNull @RequestBody Contractor contractorToUpdate) {
        contractorService.updateContractor(licenceID, contractorToUpdate);
    }

}
