
import java.util.Scanner;

class Calculator{
    int num1;
    int num2;
    String operator;

    void add(){
        if(operator.equals("+")) {
            int total = num1 + num2;
            System.out.println("Your add Total : " + total);
        }
        else{
            System.out.println("Select the correct operator !!!");
        }
    }

    void multi(){
        if(operator.equals("*")) {
            int total = num1 * num2;
            System.out.println("Your multi Total : " + total);
        }
        else {
            System.out.print("Select the correct operator !!!");
        }
    }

    void devide(){
        if(operator.equals("/")){
            int total = num1 / num2;
            System.out.println("Your devide Total : " + total);
        }
        else {
            System.out.print("Select the correct operator !!!");
        }
    }

    void sub(){
        if(operator.equals("-")){
            int total = num1 - num2;
            System.out.print("Your sub Total : " + total);
        }
        else{
            System.out.print("Select the correct operator !!!");
        }
    }

    void example(int a, int b){
        int total = a + b;
        System.out.print(total);
    }
}

public class Main{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        Calculator cal = new Calculator();

        System.out.print("Enter the operator : ");
        cal.operator = scan.nextLine();

        System.out.print("Enter the first number : ");
        cal.num1 = scan.nextInt();

        System.out.print("Enter the second number : ");
        cal.num2 = scan.nextInt();

        //OUTPUTS
        if(cal.operator.equals("+")){
            cal.add();
        }
        else if(cal.operator.equals("*")){
            cal.multi();
        }
        else if(cal.operator.equals("/")){
            cal.devide();
        }
        else if(cal.operator.equals("-")){
            cal.sub();
        }

        cal.example(30, 40);

    }
}