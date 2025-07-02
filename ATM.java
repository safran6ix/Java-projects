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
    public static void main(String[] args) throws IOException
    {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter account number: ");
        String accNum = sc.nextLine();

        UserAccount user = FileManager.loadAccount(accNum);
        if (user == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.print("Enter PIN: ");
        String pin = sc.nextLine();

        if (!user.validatePIN(pin)) {
            System.out.println("Invalid PIN.");
            return;
        }

        int choice;
        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Mini Statement");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Balance: " + user.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double dep = sc.nextDouble();
                    user.deposit(dep);
                    FileManager.logTransaction(accNum, "Deposited: " + dep);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double wd = sc.nextDouble();
                    if (user.withdraw(wd)) {
                        FileManager.logTransaction(accNum, "Withdrawn: " + wd);
                    } else {
                        System.out.println("Insufficient balance.");
                    }
                    break;
                case 4:
                    FileManager.showMiniStatement(accNum);
                    break;
                case 5:
                    FileManager.saveAccount(user);
                    System.out.println("Session ended. Thank you!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 5);

        sc.close();

    }
}