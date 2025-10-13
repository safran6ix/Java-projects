import java.util.*;

public class PersonCrudApp {

    private static Map<Integer, Person> personMap = new HashMap<>();
    private static int currentId = 1; //ID Generataor
    private static Scanner scanner = new Scanner(System.in);

    // CREATE
    public static Person createPerson(String name, int age) {
        Person person = new Person(currentId++, name, age);
        personMap.put(person.getId(), person);
        return person;
    }

    //READ
    public static Person getPersonById(int id){
        return personMap.get(id);
    }

    // UPDATE
    public static Person updatePerson(int id, String name, int age) {
        Person person = personMap.get(id);
        if (person != null) {
            person.setName(name);
            person.setAge(age);
        }
        return person;
    }

    //DELETE
    public static boolean deletePerson(int id){
        if(personMap.containsKey(id)) {
            personMap.remove(id);
            return true;
        }
        return false;
    }

    //DISPLAY ALL PERSONS
    public static void displayAllPersons(){
        if(personMap.isEmpty()){
             System.out.println("No persons available");
        }
        else{
            for(Person person : personMap.values()){
                System.out.println(person);
            }
        }
    }

    //METHOD FOR CAPTURING USER INPUT
    public static String getStringInput(String prompt){
        System.out.println(prompt);
        return scanner.nextLine();
    }

    public static int getIntInput(String prompt){
        System.out.println(prompt);
        return scanner.nextLine();
    }

    public static void main(String[] args)
    {

        int choice;
        do{
          
            System.out.println("\nPerson Management System");
            System.out.println("1. Create Person");
            System.out.println("2. View Person");
            System.out.println("3. Delete Person");
            System.out.println("4. Delete Person");
            System.out.println("5. View All Persons");
            System.out.println("6. Exit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); //consume newline left-over after nextInt()
            

            switch (choice) {
                case 1:
                     // CREATE
                    String name = getStringInput("Enter name: ");
                    int age = getIntInput("Enter age: ");
                    createPerson(name, age);
                    System.out.println("Person created successfully!");
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