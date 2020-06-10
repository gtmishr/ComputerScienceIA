package com.group.NewSouthWalesBuildingCompliance.api;

import com.group.NewSouthWalesBuildingCompliance.model.Contractor;
import com.group.NewSouthWalesBuildingCompliance.service.ContractorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@RequestMapping("api/contractor")
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

        try {
            FileWriter fileWriter = new FileWriter("data.json");
            PrintWriter printWriter = new PrintWriter("data.json");
            printWriter.print("{'licenceID': '" + contractor.getLicenceID() +"', 'licenceNumber': '" + contractor.getLicenceNumber() +"', 'businessNames': '" + contractor.getBusinessNames() +"', 'categories': '" + contractor.getCategories() + "', 'classes': '" + contractor.getClasses() +"' , 'licenceName': '" + contractor.getLicenceName() +"', 'licenceType': '" + contractor.getLicenceType() +"', 'licensee': '" + contractor.getLicensee() +"', 'postcode': '" + contractor.getPostcode() +"', 'status': '" + contractor.getStatus() +"', 'suburb': '" + contractor.getSuburb() +"'};");
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
