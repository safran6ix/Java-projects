import java.util.ArrayList;

class Office{
    private String officeNumber;
    private int capacity;

    public Office(String officeNumber, int capacity){
        this.officeNumber = officeNumber;
        this.capacity = capacity;
    }

    public void displayOfficeDetails(){

    }
}

class Person{
    protected String name;
    protected String id;

    public Person(String name, String id){
        this.name = name;
        this.id = id;
    }

    public void displayPersonDetails(){
        System.out.println("Name:" + name);
        System.out.println("ID: " + id);
    }
}

class Professor extends Person{
    private String subjectSpecialty;
    private Office office; //Composition

    public Professor(String name, String id, String subjectSpecialty, Office office){
        super(name, id);
        this.subjectSpecialty = subjectSpecialty;
        this.office = office;
    }

    @Override
    public void displayPersonDetails() {
        super.displayPersonDetails();
        System.out.println("Subject Specialty: " + subjectSpecialty);
        office.displayOfficeDetails(); //Composition use
    }
}

public class UniversityApp{
    public static void main(String[] args)
    {



    }
}