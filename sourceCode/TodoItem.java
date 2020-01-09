import java.time.LocalDate;

public class TodoItem {

  public String itemName;
  LocalDate dateAdded = LocalDate.now();
  LocalDate dateToCompleteBy = LocalDate.now();
  public String status;

  public TodoItem(String itemName, LocalDate dateAdded, LocalDate dateToCompleteBy, String status) {
    this.itemName = itemName;
    this.dateAdded = dateAdded;
    this.dateToCompleteBy = dateToCompleteBy;
    this.status = status;
  }

  void listTodoItemSpecifications() {
    System.out.println(itemName + " was added " + dateAdded + " and needs to be completed by " + dateToCompleteBy + " and is currently " + status);
  }

}
