class Vehicle{
    protected String brand;
    protected double speed;
    protected Engine engine;

    public Vehicle(String brand, double speed, String engineType){
        this.brand = brand;
        this.speed = speed;
        this.engine = new Engine(engineType);
    }

    public void start(){
        System.out.println("The vehicle is starting...");
    }

    public void displayDetails(){
        System.out.println("Brand: " + brand);
        System.out.println("Speed: " + speed + " km/h");
        engine.displayEngineInfo();
    }
}

class Engine{
    protected String engineType;

    public Engine(String engineType){
        this.engineType = engineType;
    }
    public void displayEngineInfo(){
        System.out.println("Engine Type: " + engineType);
    }
}

class Driver{
    private String name;
    private String licenseNumber;

    public Driver(String name, String licenseNumber){
        this.name = name;
        this.licenseNumber = licenseNumber;
    }
    public void displayDriverInfo(){
        System.out.println("Driver Name: " + name);
        System.out.println("License Number: " + licenseNumber);
    }
}

class Bus extends Vehicle{
    private Driver driver;

    public Bus(String brand, double speed, String engineType, Driver driver){
        super(brand, speed, engineType);
        this.driver = driver;
    }

    public void start(){
        System.out.println("The bus is starting with a smooth roar...");
    }
    public void displayDetails(){
        super.displayDetails();
        driver.displayDriverInfo();
    }
}

class Truck extends Vehicle{
    private Driver driver;

    public Truck(String brand, double speed, String engineType, Driver driver){
        super(brand, speed, engineType);
        this.driver = driver;
    }

    @Override
    public void start() {
        System.out.println("The truck is starting with a powerful rumble...");
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        driver.displayDriverInfo();
    }
}




public class Transport_App{
    public static void main(String[] args)
    {

    }
}