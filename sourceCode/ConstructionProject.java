public class ConstructionProject {

  private String clientName;
  public String getClientName() {
    return clientName;
  }

  public String streetAddress;
  public String suburb;
  public String description;
  public String photoAddress;
//    public String[] contractorList;
//    public String[] todoList;

  public ConstructionProject(String clientName, String streetAddress, String suburb, String description, String photoAddress) {
      this.clientName = clientName;
      this.streetAddress = streetAddress;
      this.suburb = suburb;
      this.description = description;
      this.photoAddress = photoAddress;
//        this.todoList[] = new String[todoItem];
//        this.contractorList[] = new String[contractorItem];
    }

  void listSpecifications() {
      System.out.println(getClientName() + "'s house " + streetAddress + " is in " + suburb + ". Notes include..." + description + " and the photo address is " + photoAddress + ".");
  }

  void listClientName() {
    System.out.println("The client for this project is " + getClientName());
  }

}
