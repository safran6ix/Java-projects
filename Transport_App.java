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

public class Transport_App{
    public static void main(String[] args)
    {

    }
}