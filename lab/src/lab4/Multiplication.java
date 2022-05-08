package lab4;
import java.util.Scanner;
public class Multiplication {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n= in.nextInt();
        while (n!=0) {
            if(n<0||n>9){
                continue;
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    //%2d能使其自动补齐，\t使其移动到j*i后面
                    System.out.printf("%d * %d =%2d\t", j, i, j * i);
                }
                System.out.println("Please input a number to print Multiplication Table(0 to terminate)");
                n = in.nextInt();
            }
        }
    }
}
