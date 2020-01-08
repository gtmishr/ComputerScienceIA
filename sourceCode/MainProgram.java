import java.util.ArrayList;

public class MainProgram {

    public static void main(String[] args) {

      ConstructionProject mishraHouse = new ConstructionProject("Rajesh Mishra", "18 Trumble Street", "Pearce", "Currently in development", "sampleHouse.jpg");

      Contractor zilingOuyang = new Contractor("CGS", "Smart", "Maths HL", "12048", "Ziling Ouyang", "All-round sensation", "Gautam Mishra", "2603", "Stressed over IAs", "Red Hill");

      mishraHouse.listSpecifications();
      mishraHouse.listClientName();

      zilingOuyang.listContractorSpecifications();

    }
}
