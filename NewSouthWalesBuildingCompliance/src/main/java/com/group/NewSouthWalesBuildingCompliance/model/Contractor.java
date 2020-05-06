package com.group.NewSouthWalesBuildingCompliance.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Contractor {

    // Private for encapsulation
    private final String licenceID;
    private final String licenceNumber;
    private final String businessNames;
    private final String categories;
    private final String classes;
    private final String licenceName;
    private final String licenceType;
    private final String licensee;
    private final String postcode;
    private final String status;
    private final String suburb;

    // All of the attributes that are mentioned on the NSW API website

    public Contractor(@JsonProperty("licenceID") String licenceID,
                      @JsonProperty("licenceNumber") String licenceNumber,
                      @JsonProperty("businessNames") String businessNames,
                      @JsonProperty("categories") String categories,
                      @JsonProperty("classes") String classes,
                      @JsonProperty("licenceName") String licenceName,
                      @JsonProperty("licenceType") String licenceType,
                      @JsonProperty("licensee") String licensee,
                      @JsonProperty("postcode") String postcode,
                      @JsonProperty("status") String status,
                      @JsonProperty("suburb") String suburb) {

        this.licenceID = licenceID;
        this.licenceNumber = licenceNumber;
        this.businessNames = businessNames;
        this.categories = categories;
        this.classes = classes;
        this.licenceName = licenceName;
        this.licenceType = licenceType;
        this.licensee = licensee;
        this.postcode = postcode;
        this.status = status;
        this.suburb = suburb;
    }

    public String getLicenceID() {
        return licenceID;
    }
    public String getLicenceNumber() {
        return licenceNumber;
    }
    public String getBusinessNames() {
        return businessNames;
    }
    public String getCategories() {
        return categories;
    }
    public String getClasses() {
        return classes;
    }
    public String getLicenceName() {
        return licenceName;
    }
    public String getLicenceType() {
        return licenceType;
    }
    public String getLicensee() {
        return licensee;
    }
    public String getPostcode() {
        return postcode;
    }
    public String getStatus() {
        return status;
    }
    public String getSuburb() {
        return suburb;
    }

}
