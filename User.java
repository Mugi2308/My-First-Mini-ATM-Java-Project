package MyATMProject;

import java.util.Scanner;

public class User {

    String name;
    private int pin;
    private Account account;

    User (String name,int pin,Account account){
        this.name = name;
        this.pin = pin;
        this.account = account;
    }


    boolean checkPin(int inputPin){
        return this.pin == inputPin;
    }

    String getName(){
        return this.name;
    }
    Account getAccount(){
        return account;
    }

}
