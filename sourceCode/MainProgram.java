import java.util.*;
import java.net.URLConnection;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.net.URL;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Month;

public class MainProgram {

    public static void main(String[] args) throws Exception {

      Contractor sampleContractor1 = new Contractor("234567", "345678", "CGS", "Smart", "Maths HL", "Ziling Ouyang", "All-round sensation", "Gautam Mishra", "2603", "Stressed over IAs", "Red Hill");
      Contractor sampleContractor2 = new Contractor("345678", "456789", "CGS", "Smart", "Maths HL", "Ziling Ouyang", "All-round sensation", "Gautam Mishra", "2603", "Stressed over IAs", "Red Hill");

      ArrayList<Contractor> sampleContractorList = new ArrayList<Contractor>();
      sampleContractorList.add(sampleContractor1);
      sampleContractorList.add(sampleContractor2);

      TodoItem sampleTask1 = new TodoItem("sample sample sample", LocalDate.now(), LocalDate.of(2020, 10, 9), "Incomplete");
      TodoItem sampleTask2 = new TodoItem("sample sample sample", LocalDate.now(), LocalDate.of(2020, 11, 9), "Incomplete");

      ArrayList<TodoItem> sampleTodoList = new ArrayList<TodoItem>();
      sampleTodoList.add(sampleTask1);
      sampleTodoList.add(sampleTask2);

      ConstructionProject mishraHouse = new ConstructionProject("Rajesh Mishra", "18 Trumble Street", "Pearce", "Currently in development", "sampleHouse.jpg", sampleContractorList, sampleTodoList);

//      sampleContractor1.listContractorSpecifications();
//      sampleContractor2.listContractorSpecifications();

//      sampleTask1.listTodoItemSpecifications();
//      sampleTask2.listTodoItemSpecifications();

      System.out.println(sampleContractorList);

//      mishraHouse.listSpecifications();
//      mishraHouse.listClientName();

//      mishraHouse.listContractors();
//      mishraHouse.listTodoItems();

    }
}
