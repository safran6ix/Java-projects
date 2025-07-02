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

    public static void saveAccount(UserAccount user) throws IOException {
        File inputFile = new File("accounts.txt");
        File tempFile = new File("accounts_temp.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\\|");
            if (parts[0].equals(user.getAccountNumber())) {
                writer.write(user.toFileString());
            } else {
                writer.write(line);
            }
            writer.newLine();
        }
        reader.close();
        writer.close();

        inputFile.delete();
        tempFile.renameTo(inputFile);
    }

    public static void logTransaction(String accNum, String message) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("transactions_" + accNum + ".txt", true));
        writer.write(new Date() + " - " + message);
        writer.newLine();
        writer.close();
    }

    public static void showMiniStatement(String accNum) throws IOException {
        File file = new File("transactions_" + accNum + ".txt");
        if (!file.exists()) {
            System.out.println("No transactions found.");
            return;
        }

        List<String> lines = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();

        System.out.println("Mini Statement (last 5 transactions):");
        int start = Math.max(0, lines.size() - 5);
        for (int i = start; i < lines.size(); i++) {
            System.out.println(lines.get(i));
        }
    }
}

public class ATM{
    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);


    }
}