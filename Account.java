package MyATMProject;

public class Account {

    private int accountNumber;
    private double balance;

    Account(int accountNumber,double balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    double deposit(double deposit){
        if(deposit > 0){
            this.balance +=deposit;
        }
        else {
            System.out.println("Deposit must me grater than 0 ");
        }
      return this.balance;
    }

    double withdraw(double withdraw){
        if(withdraw < this.balance){
            this.balance-=withdraw;
        }
        else {
            System.out.println("Insufficient Balance ");
        }
        return this.balance;
    }

    double getBalance(){
        return this.balance;
    }
    int getAccountNumber(){
        return this.accountNumber;
    }




}
