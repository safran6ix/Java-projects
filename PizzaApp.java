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


}

public class PizzaApp{
    public static void main(String[] args)
    {



    }
}