package lab4;
import java.util.Scanner;
public class Pai2 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
       double s=input.nextDouble();
       double pi=4;int i=1;
       while (Math.abs(Math.pow((-1),(i))*4/(2*i+1))>=s){
             i=i+1;
             pi=pi+Math.pow((-1),(i-1))*4/(2*i-1);
       }
       System.out.println(pi);
       System.out.println(i-1);
    }
}
