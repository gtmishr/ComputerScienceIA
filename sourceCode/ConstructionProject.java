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
  ArrayList<TodoItem> todoList = new ArrayList<TodoItem>();

  public ConstructionProject(String clientName, String streetAddress, String suburb, String description, String photoAddress, ArrayList<Contractor> contractorList, ArrayList<TodoItem> todoList) {
      this.clientName = clientName;
      this.streetAddress = streetAddress;
      this.suburb = suburb;
      this.description = description;
      this.photoAddress = photoAddress;
      this.contractorList = contractorList;
      this.todoList = todoList;
    }

  void listSpecifications() {
      System.out.println(getClientName() + "'s house " + streetAddress + " is in " + suburb + ". Notes include..." + description + " and the photo address is " + photoAddress + ".");
  }

  void listContractors() {
    for (Contractor contractors : contractorList) {
      System.out.println(contractors);
    }
  }

  void listTodoItems() {
    for (TodoItem todos : todoList) {
      System.out.println(todos);
    }
  }

  void listClientName() {
    System.out.println("The client for this project is " + getClientName());
  }

}
