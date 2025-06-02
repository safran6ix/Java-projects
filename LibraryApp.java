import java.util.Scanner;

class LibraryBook{
    private String bookId;
    private String title;
    private String author;
    private int copiesAvailable;

    public LibraryBook(String bookId, String title, String author, int copiesAvailable){
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    public void lendBook(int copiesRequested){
        if(copiesRequested > copiesAvailable){
            System.out.println("Not enough copies Available, please check back later");
        }
        else{
            copiesAvailable -= copiesRequested;
            System.out.println("Book issued successfully!");
        }
    }

    public void printBookDetails(){
        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Copies Available: " + copiesAvailable);
        System.out.println("-----------------------------");
    }
}


public class LibraryApp{
    public static void main(String[] args)
    {
       Scanner scan = new Scanner(System.in);

       System.out.println("Enter Details for Book 1:");
       System.out.print("Book ID1: ");
       String bookId1 = scan.nextLine();

       System.out.print("Title: ");
       String title1 = scan.nextLine();

       System.out.print("Author: ");
       String author1 = scan.nextLine();

       System.out.print("Copies Available: ");
       int copiesAvailable1 = scan.nextInt();
       scan.nextLine();


    }
}