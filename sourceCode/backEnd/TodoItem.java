import java.time.LocalDate;

// Class for giving TodoItem attributes
public class TodoItem {

  public String itemName;
  LocalDate dateAdded = LocalDate.now(); // Using Java's LocalDate functions
  LocalDate dateToCompleteBy = LocalDate.now(); // Using Java's LocalDate functions
  public String status;

  public TodoItem(String itemName, LocalDate dateAdded, LocalDate dateToCompleteBy, String status) {
    this.itemName = itemName;
    this.dateAdded = dateAdded;
    this.dateToCompleteBy = dateToCompleteBy;
    this.status = status;
  }

  // Print out TodoItem specifiations as mentioned previously
  void listTodoItemSpecifications() {
    System.out.println(itemName + " was added " + dateAdded + " and needs to be completed by " + dateToCompleteBy + " and is currently " + status);
  }

}
