public class BookReg{

    private String title;
    private String author;
    private String ISBN;
    private double price;

    public BookReg(String title, String author){
        this.title = title;
        this.author = author;
        this.ISBN = "Not Available!";
        this.price = 0.0;
    }
    
    public BookReg(String title, String author, String ISBN){
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.price = 0.0;
    }

   public static void main(String[] args)
   {
       System.out.println("Hello World");
   }
}
