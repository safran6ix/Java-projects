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

class Course{
    private String courseCode;
    private String courseTitle;

    public Course(String courseCode, String courseTitle){
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
    }

    public void displayCourseDetails(){
        System.out.println("Course Code: " + courseCode + ", Title: " + courseTitle);
    }
}

class Student extends Person{
    private String major;
    private ArrayList<Course> courses;

    public Student(String name, String id, String major){
        super(name, id);
        this.major = major;
        this.courses = new ArrayList<>();
    }

    public void enrollCourse(Course course){
        if(courses.size() < 3){
            courses.add(course);
        }
        else{
            System.out.println("Cannot enroll in more than 3 courses.");
        }
    }

    @Override
    public void displayPersonDetails() {
        super.displayPersonDetails();
        System.out.println("Major: " + major);
        System.out.println("Enrolled Courses:");
        for(Course course : courses){
            course.displayCourseDetails();
        }
    }

    public ArrayList<Course> getCourses(){
        return courses;
    }
}

class Department {
    private String departmentName;
    private ArrayList<Professor> professors;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.professors = new ArrayList<>();
    }

    public void addProfessor(Professor prof) {
        professors.add(prof);
    }

    public void displayDepartmentDetails() {
        System.out.println("Department: " + departmentName);
        for (Professor prof : professors) {
            prof.displayPersonDetails();
            System.out.println("------------------");
        }
    }
}

class Printer {
    public void printCourseList(ArrayList<Course> courses) {
        System.out.println("Printing Course List:");
        for (Course course : courses) {
            course.displayCourseDetails();
        }
    }
}

public class UniversityApp{
    public static void main(String[] args)
    {



    }
}