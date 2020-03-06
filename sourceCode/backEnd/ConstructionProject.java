import java.util.ArrayList;

// Class for giving ConstructionProject attributes
public class ConstructionProject {

  // Priavte for encapsulation
  private String clientName;
  public String getClientName() {
    // Encapsulate clientName to not alter accidentally
    return clientName;
  }

  public String streetAddress;
  public String suburb;
  public String description;
  public String photoAddress;

  // ArrayLists used to allow for dynamic contractorList and todoList
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

  // Print out ConstructionProject specifiations as mentioned previously
  void listSpecifications() {
      System.out.println(getClientName() + "'s house " + streetAddress + " is in " + suburb + ". Notes include..." + description + " and the photo address is " + photoAddress + ".");
  }

  // Print out all Contractors
  void listContractors() {
    for (Contractor contractors : contractorList) {
      System.out.println(contractors);
    }
  }

  // Print out all TodoItems
  void listTodoItems() {
    for (TodoItem todos : todoList) {
      System.out.println(todos);
    }
  }

}
