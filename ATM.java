package MyATMProject;


import java.util.ArrayList;
import java.util.Scanner;

public class ATM {

    String name;
    int pin;
    Account account;
    int choice;

    Scanner scanner = new Scanner(System.in);
    ArrayList<User> users = new ArrayList<>();

     void start(){

         while(true){
             System.out.println("Open your new Account ");
             System.out.print("Create a user name : ");
             name = scanner.nextLine();

             System.out.print("Create your PIN : ");
             pin = scanner.nextInt();
             scanner.nextLine();

             System.out.print("Create your account number : ");
             int accountNumber = scanner.nextInt();

             System.out.print("How much balance in the do you have : ");
             double balance = scanner.nextDouble();
             scanner.nextLine();

             users.add(new User(name,pin,new Account(accountNumber,balance)));

             System.out.println("Do you want add another user ? (yes/no)");
             String choice = scanner.nextLine();

             if(!choice.equalsIgnoreCase("yes")){
                 break;
             }

             System.out.println("\n Accounts create successful !");
         }

    }

    void login(){
        System.out.println("Welcome to ATM Machine");
        System.out.print("Enter your PIN :");

        int attempts=3;

        while(attempts>0){

            int inputPin = scanner.nextInt();


            for(User user:users){
                if(user.checkPin(inputPin)){

                    System.out.println("Log in successful "+user.getName());
                    showMenu(user);
                    return;
                }
                
            }
            attempts --;
                System.out.println("Wrong PIN, Attempts left "+attempts);
        
        }
        System.out.println("Card Block");

    }
    void showMenu(User user){

         do {
             System.out.println("Welcome to ATM main menu ");
             System.out.println("1. Deposit ");
             System.out.println("2. Withdraw money");
             System.out.println("3. Check Balance");
             System.out.println("4. Check your account number");
             System.out.println("5. Exist");
             choice = scanner.nextInt();
             scanner.nextLine();

             switch (choice) {

                 case 1 -> {
                     System.out.println("Enter your Deposit amount:");
                     double deposit = scanner.nextDouble();
                     user.getAccount().deposit(deposit);
                 }
                 case 2 -> {
                     System.out.println("Enter your withdraw amount");
                     double withdraw = scanner.nextDouble();
                     user.getAccount().withdraw(withdraw);
                 }
                 case 3 -> System.out.println("Checking balance " +user.getAccount().getBalance());
                 case 4 -> System.out.println("Checking your account "+user.getAccount().getAccountNumber());
                 case 5 -> System.out.println("exiting ");

                 default -> System.out.println("Invalid");
             }

         }while (choice!=5);
    }

    scanner.close();
}
