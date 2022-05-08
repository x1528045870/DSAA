package lab4;
import java.util.Scanner;
public class Pai {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Please input n:");
        int n= in.nextInt();
        double pi=0;
        for(int i=1;i<=n;i++){
             pi=pi+Math.pow((-1),(i-1))*4/(2*i-1);
        }
        float p=(float)pi;
        System.out.println(p);
    }
}
