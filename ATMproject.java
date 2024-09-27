/* Create an ATM machine function*/

import java.util.*;

public class ATMproject{
    public static void main(String[] args){

        int pin = 2460;
        int balance = 100;
        int AddAmount = 0;
        int TakeAmount = 0;

        String name;
        Scanner scanner = new Scanner(System.in);
        
        //we have to take an input by an user
        System.out.println("Enter your pin number");
        
        int password = scanner.nextInt();

        if(password == pin)
        {
            System.out.println("Enter your name");
            name = scanner.next();
            System.out.println("Welcome___" + name);

            while (true) {
                System.out.println("Press 1 to check your balance");
                System.out.println("Press 2 to add amount");
                System.out.println("Press 3 to take amount");
                System.out.println("Press 4 to take recipt");
                System.out.println("press 5 to Exit");

                int opt = scanner.nextInt();
                switch(opt)
                {
                    case 1:
                        System.out.println("your current balance is : " + balance);
                        break;

                    case 2:
                        System.out.println("How much amount did you want to ADD to your account");
                        AddAmount = scanner.nextInt();
                        System.out.println("Successfully credited!");
                        balance = AddAmount + balance;
                    break;

                    case 3:
                        System.out.println("How much amount did you want to take");
                        TakeAmount = scanner.nextInt();
                        if(TakeAmount>balance)
                        {
                            System.out.println("Your balance is insufficient");
                            System.out.println("Try less than your available balance");
                        }
                        else
                        {
                            System.out.println("Successfully taken");
                            balance = balance - TakeAmount;
                        }
                        break;

                    case 4:
                        System.out.println("*********************************************************");
                        System.out.println(" ");  
                        System.out.println("---------------RECIPT----------------");
                        System.out.println("Welcome to Codify6ix mini ATM");
                        System.out.println("_____________________________________");
                        System.out.println("Available balance is : " + balance);
                        System.out.println("Amount deposite :      " + AddAmount);
                        System.out.println("Amount taken :         " + TakeAmount);
                        System.out.println("_____________________________________");
                        System.out.println("Thank You!___Come again!");
                        System.out.println(" ");  
                        System.out.println("*********************************************************");
                    break;          
                }
                if(opt == 5)
                {
                    System.out.println("Thank You...!");
                    break;
                }
            }
        }
        else
        {
            System.out.print("Wrong pin number...!");
            System.out.print("");
            System.out.print("Try again...!");
        }
    }
}