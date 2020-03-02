import java.util.Comparator;

public class Contractor{

  private String licenceID;
  private String licenceNumber;

  public String getLicenceID() {
    return licenceID;
  }

  public String getLicenceNumber() {
    return licenceNumber;
  }

  public String businessNames;
  public String categories;
  public String classes;
  public String licenceName;
  public String licenceType;
  public String licensee;
  public String postcode;
  public String status;
  public String suburb;

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

  void listContractorSpecifications() {
    System.out.println("Licence ID: " + getLicenceID() + ", Licence Number: " + getLicenceNumber() + ", Business names: " + businessNames + ", Categories: " + categories + ", Classes: " + classes +  ", Licence Name: " + licenceName + ", Licence Type: " + licenceType + ", Licensee: " + licensee + ", Postcode: " + postcode + ", Status: " + status + ", Suburb: " + suburb);
  }

}
