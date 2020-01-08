import java.util.ArrayList;

public class ConstructionProject {

  private String clientName;
  public String getClientName() {
    return clientName;
  }

  public String streetAddress;
  public String suburb;
  public String description;
  public String photoAddress;

  ArrayList<Contractor> contractorList = new ArrayList<Contractor>();

  public ConstructionProject(String clientName, String streetAddress, String suburb, String description, String photoAddress, ArrayList<Contractor> contractorList) {
      this.clientName = clientName;
      this.streetAddress = streetAddress;
      this.suburb = suburb;
      this.description = description;
      this.photoAddress = photoAddress;
      this.contractorList = contractorList;
//      this.todoList = new ArrayList<TodoItem>();
    }

  void listSpecifications() {
      System.out.println(getClientName() + "'s house " + streetAddress + " is in " + suburb + ". Notes include..." + description + " and the photo address is " + photoAddress + ".");
  }

  void listClientName() {
    System.out.println("The client for this project is " + getClientName());
  }

  void listContractors() {
    for (Contractor contractors : contractorList) {
      System.out.println(contractorList);
    }
  }

}
