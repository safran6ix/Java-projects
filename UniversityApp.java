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

public class UniversityApp{
    public static void main(String[] args)
    {



    }
}