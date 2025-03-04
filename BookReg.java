import java.util.Scanner;

public class BookReg{

    //Atributes
    private String title;
    private String author;
    private String ISBN;
    private double price;

    //Constructor 01
    public BookReg(String title, String author){
        this.title = title;
        this.author = author;
        this.ISBN = "Not Available!";
        this.price = 0.0;
    }
    
    //Constructor 02
    public BookReg(String title, String author, String ISBN){
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.price = 0.0;
    }

    //Constructor 03
    public BookReg(String title, String author, String ISBN, double price){
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.price = price;
    }

    //Method 01
    public String getBookDetails(){
        return "Title: " + title + "Author: " + author + "ISBN: " + ISBN + "Price : $ " + price;
    }
    
    //Method 02
    public String getBookDetails(String ISBN){
        if(this.ISBN.equals(ISBN)){
            return "Title: " + title + ", Author: " + author + ", ISBN: " + ISBN + ", Price: $" + price; 
        }
        else{
            return "No book found with ISBN: " + ISBN;
        }
    }

    public static void main(String[] args)
   {
       
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter details for Book 01 :- ");
        
        System.out.print("Enter Title : ");
        String title1 = scan.nextLine();

        System.out.println("Enter Author : ");
        String author1 = scan.nextLine();

        //Taking ISBN and Price
        System.out.print("Enter ISBN (leave blank for default) : ");
        String isbn1 = scan.nextLine();

        if(isbn1.isEmpty()){
            isbn1 = "Not Available";
        }
        
        System.out.print("Enter price (enter 0 for default): ");
        double price1 = scan.nextDouble();
        scan.nextLine();
        
        //Create first book object
        BookReg book1;
        if(isbn1.equals("Not Available") && price1 == 0){
            book1 = new BookReg(title1, author1); //Constructor 01
        }
        else if(price1 == 0){
            book1 = new BookReg(title1, author1, isbn1); //Constructor 02
        }
        else{
            book1 = new BookReg(title1, author1, isbn1, price1); //Constructor 03
        }

   }
}
