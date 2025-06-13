import java.util.Scanner;

class InvalidUserName extends Exception{
    public InvalidUserName(){
        super("The username must be a at least 6 characters long");
    }
}

class InvalidPasswordLength extends Exception{
    public InvalidPasswordLength(){
        super("The password must be at least 8 characters long");
    }
}

public class TryCatchException{
    public static void main(String[] args)
    {

        Scanner scan = new Scanner(System.in);

        try {
            //Prompt user for username
            System.out.print("Enter username: ");
            String username = scan.nextLine();

            //Validate username
            if(username.length() < 6){
                throw new InvalidUserName();
            }
        }
        catch (InvalidUserName e){
            System.out.println("Username Error: " + e.getMessage());
        }
    }
}