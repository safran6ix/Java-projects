import java.util.*;

public class PersonCrudApp {

    private static Map<Integer, Person> personMap = new HashMap<>();
    private static int currentId = 1;  // ID generator
    private static Scanner scanner = new Scanner(System.in);

    // CREATE
    public static Person createPerson(String name, int age) {
        Person person = new Person(currentId++, name, age);
        personMap.put(person.getId(), person);
        return person;
    }

    // READ
    public static Person getPersonById(int id) {
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

    // DELETE
    public static boolean deletePerson(int id) {
        if (personMap.containsKey(id)) {
            personMap.remove(id);
            return true;
        }
        return false;
    }

    // Display all persons
    public static void displayAllPersons() {
        if (personMap.isEmpty()) {
            System.out.println("No persons available.");
        } else {
            for (Person person : personMap.values()) {
                System.out.println(person);
            }
        }
    }

    // Method for capturing user input
    public static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static int getIntInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\nPerson Management System");
            System.out.println("1. Create Person");
            System.out.println("2. View Person");
            System.out.println("3. Update Person");
            System.out.println("4. Delete Person");
            System.out.println("5. View All Persons");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over after nextInt()

            switch (choice) {
                case 1:
                    // CREATE
                    String name = getStringInput("Enter name: ");
                    int age = getIntInput("Enter age: ");
                    createPerson(name, age);
                    System.out.println("Person created successfully!");
                    break;

                case 2:
                    // READ
                    int idToView = getIntInput("Enter ID to view: ");
                    Person personToView = getPersonById(idToView);
                    if (personToView != null) {
                        System.out.println(personToView);
                    } else {
                        System.out.println("Person not found!");
                    }
                    break;

                case 3:
                    // UPDATE
                    int idToUpdate = getIntInput("Enter ID to update: ");
                    Person personToUpdate = getPersonById(idToUpdate);
                    if (personToUpdate != null) {
                        String updatedName = getStringInput("Enter new name: ");
                        int updatedAge = getIntInput("Enter new age: ");
                        updatePerson(idToUpdate, updatedName, updatedAge);
                        System.out.println("Person updated successfully!");
                    } else {
                        System.out.println("Person not found!");
                    }
                    break;

                case 4:
                    // DELETE
                    int idToDelete = getIntInput("Enter ID to delete: ");
                    boolean deleted = deletePerson(idToDelete);
                    if (deleted) {
                        System.out.println("Person deleted successfully!");
                    } else {
                        System.out.println("Person not found!");
                    }
                    break;

                case 5:
                    // View All
                    System.out.println("All Persons:");
                    displayAllPersons();
                    break;

                case 6:
                    // Exit
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 6);

        scanner.close();
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
