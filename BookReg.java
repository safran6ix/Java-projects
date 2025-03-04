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
       
    

    
   }
}
