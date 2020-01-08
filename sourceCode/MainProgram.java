import java.util.ArrayList;

public class MainProgram {

    public static void main(String[] args) {

      ConstructionProject mishraHouse = new ConstructionProject("Rajesh Mishra", "18 Trumble Street", "Pearce", "Currently in development", "sampleHouse.jpg");

      mishraHouse.listSpecifications();
      mishraHouse.listClientName();

    }
}
