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


}


public class LibraryApp{
    public static void main(String[] args)
    {

       System.out.println("Hello World");

    }
}