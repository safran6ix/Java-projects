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

    }
}