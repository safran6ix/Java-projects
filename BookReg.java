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


        //Input for the second book
        System.out.println("\nEnter details for Book 2: ");

        System.out.print("\nEnter Title : ");
        String title2 = scan.nextLine();

        System.out.print("Enter Author : ");
        String author2 = scan.nextLine();

        System.out.print("Enter ISBN (leave blank for default) : ");
        String isbn2 = scan.nextLine();
        
        if(isbn2.isEmpty()){
            isbn2 = "Not Available";
        }

        System.out.print("EnterbPrice (Enter 0 for default) : ");
        double price2 = scan.nextDouble();
        scan.nextLine();

        //Create second Book object
        BookReg book2;
        if(isbn2.equals("Not Available") && price2 == 0){
            book2 = new BookReg(title2, author2);
        }
        else if(price2 == 0){
            book2 = new BookReg(title2, author2, isbn2);
        }
        else{
            book2 = new BookReg(title2, author2, isbn2, price2);
        }

        //Display book details
        System.out.println("\nBook 1 details : ");
        System.out.println(book1.getBookDetails());

        System.out.println("\nBook 2 Details : ");
        System.out.println(book2.getBookDetails());

        //Search a book by ISBN
        System.out.print("\nEnter ISBN to search for a book : ");
        String searchISBN = scan.nextLine();

        System.out.println("\nSearch Result : ");
        System.out.println(book1.getBookDetails(searchISBN));
        System.out.println(book2.getBookDetails(searchISBN));
   }
}
