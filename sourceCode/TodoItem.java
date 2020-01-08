public class TodoItem {

  public String itemName;
  public String dateAdded;
  public String dateToCompleteBy;
  public String status;

  public TodoItem(String itemName, String dateAdded, String dateToCompleteBy, String status) {
    this.itemName = itemName;
    this.dateAdded = dateAdded;
    this.dateToCompleteBy = dateToCompleteBy;
    this.status = status;
  }

  void listTodoItemSpecifications() {
    System.out.println(itemName + " was added " + dateAdded + " and needs to be completed by " + dateToCompleteBy + " and is currently " + status);
  }

}
