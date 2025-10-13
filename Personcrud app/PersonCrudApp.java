import java.util.*;

public class PersonCrudApp {

    private static Map<Integer, Person> personMap = new HashMap<>();
    private static int currentId = 1; //ID Generataor
    private static Scanner Scanner = new Scanner(System.in);


    public static void main(String[] args)
    {

        int choice;
        do{
          
            System.out.println("\nPerson Management System");
            System.out.println("1. Create Person");
            System.out.println("3. View Person");
            

            switch (choice) {
                case 1:
                    //CREATE    

                    break;
            
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

       } while();

    }    
}


class Person{
    private int id;
    private String name;
    private int age;

}