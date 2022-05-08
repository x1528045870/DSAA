package lab7;

import java.util.Scanner;

public class User {
    private String account;
    private String password;
    private double money;
    public void introduce() {
        System.out.printf("%s's account has a balance of %.2f dollar\n",account,money);
    }
    public String getUser() { return account; }
    public void setUser(String account) { this.account = account; }
    public String getPassword(String password) { return password; }
    public void setPassword(String password) { this.password = password; }
    public double getMoney(double money) { return money; }
    public void setMoney(double money) { this.money = money; }
    public double income(double value) {
        money+=value;
        System.out.printf("Got %.2f as income,balance is %.2f\n",value,money);
        return money;
    }

    public double expense(double value,Scanner in) {
        if(money<value){
            System.out.printf("Plan to expense %.2f dollar but no sufficient funds",value);}
        else{System.out.printf("plan to expense %.2f dollar\nx",value);
            System.out.println("Please input your password");
            String password1=in.next();
            if(password1.equals(password)){
                money-=value;
            System.out.printf("Expense is %.2f dollar and balance %.2f dollar\n",money,value);
            }}

        return money;
    }
}
