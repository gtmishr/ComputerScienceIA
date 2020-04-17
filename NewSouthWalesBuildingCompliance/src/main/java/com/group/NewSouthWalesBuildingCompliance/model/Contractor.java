package com.group.NewSouthWalesBuildingCompliance.model;

public class Contractor {

    // Private for encapsulation
    private static String licenceID;
    private static String licenceNumber;
    private static String businessNames;
    private static String categories;
    private static String classes;
    private static String licenceName;
    private static String licenceType;
    private static String licensee;
    private static String postcode;
    private static String status;
    private static String suburb;

    public static String getLicenceID() {
        return licenceID;
    }

    public static String getLicenceNumber() {
        return licenceNumber;
    }

    public static String getBusinessNames() {
        return businessNames;
    }

    public static String getCategories() {
        return categories;
    }

    public static String getClasses() {
        return classes;
    }

    public static String getLicenceName() {
        return licenceName;
    }

    public static String getLicenceType() {
        return licenceType;
    }

    public static String getLicensee() {
        return licensee;
    }

    public static String getPostcode() {
        return postcode;
    }

    public static String getStatus() {
        return status;
    }

    public static String getSuburb() {
        return suburb;
    }

    // All of the attributes that are mentioned on the NSW API website

    public Contractor(String licenceID, String licenceNumber, String businessNames, String categories, String classes, String licenceName, String licenceType, String licensee, String postcode, String status, String suburb) {
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

    // Print out Contractor specifiations as mentioned previously
    void listContractorSpecifications() {
        System.out.println("Licence ID: " + getLicenceID() + ", Licence Number: " + getLicenceNumber() + ", Business names: " + businessNames + ", Categories: " + categories + ", Classes: " + classes +  ", Licence Name: " + licenceName + ", Licence Type: " + licenceType + ", Licensee: " + licensee + ", Postcode: " + postcode + ", Status: " + status + ", Suburb: " + suburb);
    }

}
