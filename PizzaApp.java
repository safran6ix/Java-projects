import java.util.Scanner;

class PizzaOrder{
    private String orderID;
    private String customerName;
    private String size;
    private int toppingCount;
    private boolean isDelivery;

    public PizzaOrder(){
        this.orderID = "N/A";
        this.customerName = "Unknown";
        this.size = "Small";
        this.toppingCount = 0;
        this.isDelivery = false;
    }

    public PizzaOrder(String orderID, String customerName){
        this.orderID = orderID;
        this.customerName = customerName;
        this.size = "Small";
        this.toppingCount = 0;
        this.isDelivery = false;
    }

    public PizzaOrder(String orderID, String customerName, String size, int toppingCount, Boolean isDelivery){
        this.orderID = orderID;
        this.customerName = customerName;
        this.size = size;
        this.toppingCount = toppingCount;
        this.isDelivery = isDelivery;
    }

    public String getOrderID(){
        return orderID;
    }
    public String getCustomerName(){
        return customerName;
    }
    public String getSize(){
        return size;
    }
    public int getToppingCount(){
        return toppingCount;
    }
    public boolean getIsDelivery(){
        return isDelivery;
    }

    public void setSize(String size){
        if(size.equalsIgnoreCase("small") || size.equalsIgnoreCase("Medium") || size.equalsIgnoreCase("Large")){
            this.size = size;
        }
        else{
            System.out.println("Invalid Size... Default size is 'small' ");
            this.size = "Small";
        }
    }

    public double getBasePrice(){
        switch(size.toLowerCase()){
            case "medium":
                return 10.00;
            case "large":
                return 12.00;
            default:
                return 8.00;
        }
    }

    public double calculateTotalPrice(){
        double total = getBasePrice();
        total += toppingCount * 1.50;
        if(isDelivery){
            total += 5.00;
        }
        return total;
    }

    public double calculateTotalPrice(double discountPercentage){
        double total = calculateTotalPrice();
        double discountAmount = (discountPercentage / 100.0) * total;
        return total - discountAmount;
    }

    public void displayOrderDetails(){
        System.out.println("Order ID      : " + orderID);
        System.out.println("Customer Name : " + customerName);
        System.out.println("Pizza Size    : " + size);
        System.out.println("Toppings      : " + toppingCount);
        System.out.println("Delivery      : " + (isDelivery ? "Yes" : "No"));
        System.out.printf("Total price : $%.2f\n", calculateTotalPrice());
        System.out.println("---------------------------------");
    }

}

public class PizzaApp{
    public static void main(String[] args)
    {

      PizzaOrder order1 = new PizzaOrder();
      order1.setSize("Extra Large");
      order1.displayOrderDetails();

      PizzaOrder order2 = new PizzaOrder("0102", "John");
      order2.setSize("Medium");
      order2.displayOrderDetails();

      PizzaOrder order3 = new PizzaOrder("0103", "alice", "Large", 3 ,true);
      order3.displayOrderDetails();

      System.out.printf("Discount price for %s: $%.2f\n", order3.getCustomerName(), order3.calculateTotalPrice(10.0));
      System.out.println("------------------------------------------------------------");
    }
}