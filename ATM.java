import java.io.*;
import java.io.*;
import java.util.*;
import java.util.Scanner;

class UserAccount{
    private String accountNumber;
    private String pin;
    private double balance;

    public UserAccount(String accountNumber, String pin, double balance){
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
    }

    public boolean validatePIN(String inputPin){
        return this.pin.equals(inputPin);
    }

    public void deposit(double amount){
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public boolean withdraw(double amount){
        if(amount > balance) return false;
        balance -= amount;
        System.out.println("Withdrawn: " + amount);
        return true;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String toFileString() {
        return accountNumber + "|" + pin + "|" + balance;
    }
}

class FileManager{
    public static UserAccount loadAccount(String accNum) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("accounts.txt"));
        String line;
        while((line = br.readLine()) != null){
            String[] parts = line.split("\\|");
            if(parts[0].equals(accNum)){
                br.close();
                return new UserAccount(parts[0], parts[1], Double.parseDouble(parts[2]));
            }
        }
        br.close();
        return null;
    }



}

public class ATM{
    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);


    }
}