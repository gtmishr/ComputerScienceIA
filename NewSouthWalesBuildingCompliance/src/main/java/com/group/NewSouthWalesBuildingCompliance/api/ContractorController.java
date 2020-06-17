package com.group.NewSouthWalesBuildingCompliance.api;

import com.group.NewSouthWalesBuildingCompliance.model.Contractor;
import com.group.NewSouthWalesBuildingCompliance.service.ContractorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.List;
import org.json.JSONArray;

@RequestMapping("api/contractor")
@RestController
public class ContractorController {

    private final ContractorService contractorService;

    @Autowired
    public ContractorController(ContractorService contractorService) {
        this.contractorService = contractorService;
    }

    @PostMapping
    public void addContractor(@NonNull @RequestBody Contractor contractor) throws IOException {
        contractorService.addContractor(contractor);

        File contractorData = new File("src/main/resources/static/contractorData.txt");
        FileWriter contractorFileWriter = new FileWriter(contractorData, true);
        PrintWriter contractorPrintWriter = new PrintWriter(contractorFileWriter);

        contractorPrintWriter.println("{\"licenceID\": \"" + contractor.getLicenceID() + "\", \"licenceNumber\": \"" + contractor.getLicenceNumber() + "\", \"businessNames\": \"" + contractor.getBusinessNames() + "\", \"categories\": \"" + contractor.getCategories() + "\", \"classes\": \"" + contractor.getClasses() + "\" , \"licenceName\": \"" + contractor.getLicenceName() + "\", \"licenceType\": \"" + contractor.getLicenceType() + "\", \"licensee\": \"" + contractor.getLicensee() + "\", \"postcode\": \"" + contractor.getPostcode() + "\", \"status\": \"" + contractor.getStatus() + "\", \"suburb\": \"" + contractor.getSuburb() +"\"}");
        contractorPrintWriter.close();
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
    public void deleteContractorByID(@PathVariable("ID") String licenceID) throws IOException {
        contractorService.deleteContractor(licenceID);

        File inputFile = new File("src/main/resources/static/contractorData.txt");
        File temporaryFile = new File("src/main/resources/static/temporaryContractorFile.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(temporaryFile));

        String currentLine = reader.readLine();

        while ((currentLine = reader.readLine()) != null) {
            String trimmedLine = currentLine.trim();
            if (trimmedLine.contains(licenceID)) continue;
                writer.write(currentLine + System.getProperty("line.separator"));
        }

        writer.close();
        reader.close();

        boolean deleteSuccessful = temporaryFile.renameTo(inputFile);
        writer.close();
    }

    @PutMapping(path = "{ID}")
    public void updateContractor(@PathVariable("ID") String licenceID, @NonNull @RequestBody Contractor contractorToUpdate) {
        contractorService.updateContractor(licenceID, contractorToUpdate);
    }

}
