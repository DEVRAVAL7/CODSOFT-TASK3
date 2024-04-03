import java.util.Scanner;
class BankAccount {
    double balance;

    public BankAccount(double balance) 
    {
        this.balance = balance;
    }

    public void deposit(double amount) 
    {
        if (amount > 0) 
        {
            balance += amount;
            System.out.println("Deposit successful. Remaining balance: " + balance);
        } 
        else 
        {
            System.out.println("Deposit failed. Invalid amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) 
        {
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: " + balance);
        } 
        else {
            System.out.println("Withdrawal failed. Insufficient funds.");
        }
    }
    public double checkBalance() 
    {
        return balance;
    }
}

class ATM {
    BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
    public void deposit(double amount) {
        bankAccount.deposit(amount);
    }
     public void withdraw(double amount) {
        bankAccount.withdraw(amount);
    }
    public void checkBalance() {
        System.out.println("Your balance is: " + bankAccount.checkBalance());
    }
}

public class task3 {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1000);
        ATM atm = new ATM(bankAccount);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Enter deposit amount:");
                    double depositAmount = sc.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 2:
                    System.out.println("Enter withdrawal amount:");
                    double withdrawalAmount = sc.nextDouble();
                    atm.withdraw(withdrawalAmount);
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}