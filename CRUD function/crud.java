import java.util.*;

public class crud{
  
    private static Map<Integer, Person> personMap = new HashMap<>();
    private static int currentId = 1;
    private static Scanner scan = new Scanner(System.in);


    //CREATE
    public static Person createPerson(String name, int age){
        Person person = new Person(currentId++, name, age);
        personMap.put(person.getId(), person);
        return person;
    }

    //READ
    public static Person getPersonById(int id){
        return personMap.get(id);
    }
    
    //UPDATE
    public static Person updatePerson(int id, String name, int age){
        Person person = personMap.get(id);
        if(person != null){
            person.setName(name);
            person.setAge(age);
        }
        return person;
    }
    
    //DELETE
    public static boolean deletePerson(int id){
        if(personMap.containsKey(id)){
            personMap.remove(id);
            return true;
        }
        return false;
    }

    //METHOD FOR CAPTURING USER INPUT
    public static String getStringInput(String prompt){
        System.out.print(prompt);
        return scan.nextLine();
    }

    public static int getIntInput(String prompt){
        System.out.print(prompt);
        return scan.nextInt();
    }


    public static void main(String args[])
    {

       int choice;
       do {
            System.out.println("\nPerson Management System");
            System.out.println("1. Create Person");
            System.out.println("2. View Person");
            System.out.println("3. update Person");
            System.out.println("4. Delete Person");
            System.out.print("Enter your choice : ");

            choice = scan.nextInt();
            scan.nextLine();

            switch (choice){
                case 1:
                    //CREATE
                    String name = getStringInput("Enter name : ");
                    int age = getIntInput("Enter age : ");

                    System.out.println("Person created successfully!");
            
                case 2:
                    //READ
                    int idToView = getIntInput("Enter ID to view: ");
                    Person personToView = getPersonById(idToView);
                    if(personToView != null){
                        System.out.println(personToView);
                    }
                    else{
                        System.out.println("Person not found!");
                    }
                    break;
                
                case 3:
                    //UPDATE
                    int idToUpdate = getIntInput("Enter ID to update: ");
                    Person personToUpdate = getPersonById(idToUpdate);

                    if(personToUpdate != null){
                        String updatedName = getStringInput("Enter new name: ");
                        int updatedAge = getIntInput("Enter new age: ");
                        updatePerson(idToUpdate, updatedName, updatedAge);
                        System.out.println("Person updated successfully!");
                    }
                    else{
                        System.out.println("Person not found!");
                    }
                    break;

                case 4:
                    //DELETE
                    int idToDelete = getIntInput("Enter ID to delete: ");
                    boolean deleted = deletePerson(idToDelete);
                    if(deleted){
                        System.out.println("Person delete successfully!");
                    }
                    else{
                        System.out.println("Person not found!");
                    }
                    break;

            }
        }
        while(choice != 3);
        {

        }

    }
}


class Person {
    private int id;
    private String name;
    private int age;

    // Constructor
    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // ToString method for printing the object
    @Override
    public String toString() {
        return "Person{id=" + id + ", name='" + name + "', age=" + age + "}";
    }
}