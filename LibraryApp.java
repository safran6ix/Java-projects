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

       System.out.println("\nEnter Details for Book 2:");
       System.out.print("Book ID2: ");
       String bookId2 = scan.nextLine();

       System.out.print("Title2: ");
       String title2 = scan.nextLine();

       System.out.print("Author2: ");
       String author2 = scan.nextLine();

       System.out.print("Copies Available2: ");
       int copiesAvailable2 = scan.nextInt();

       LibraryBook book1 = new LibraryBook(bookId1, title1, author1, copiesAvailable1);
       LibraryBook book2 = new LibraryBook(bookId2, title2, author2, copiesAvailable2);

       System.out.println("\nEnter number of copies to borrow for Book1: ");
       int borrow1 = scan.nextInt();
       book1.lendBook(borrow1);

       System.out.print("Enter number of copies to borrow for Book2: ");
       int borrow2 = scan.nextInt();
       book2.lendBook(borrow2);

       System.out.println("\n--- Book Details After Lending ---");
       book1.printBookDetails();
       book2.printBookDetails();

    }
}