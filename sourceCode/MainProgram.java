import java.util.ArrayList;

public class MainProgram {

    public static void main(String[] args) {

      Contractor zilingOuyang = new Contractor("234567", "345678", "CGS", "Smart", "Maths HL", "Ziling Ouyang", "All-round sensation", "Gautam Mishra", "2603", "Stressed over IAs", "Red Hill");
      ArrayList<Contractor> sampleContractorList = new ArrayList<Contractor>();
      sampleContractorList.add(zilingOuyang);

      TodoItem getThisDone = new TodoItem("sample sample sample", "11/01/2020", "Incomplete");
      ArrayList<TodoItem> sampleTodoList = new ArrayList<TodoItem>();
      sampleTodoList.add(getThisDone);

      ConstructionProject mishraHouse = new ConstructionProject("Rajesh Mishra", "18 Trumble Street", "Pearce", "Currently in development", "sampleHouse.jpg", sampleContractorList, sampleTodoList);

      zilingOuyang.listContractorSpecifications();

      mishraHouse.listSpecifications();
      mishraHouse.listClientName();

      mishraHouse.listContractors();
      mishraHouse.listTodoItems();

    }
}
