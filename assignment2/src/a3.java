import java.math.BigInteger;
import java.util.Scanner;
public class a3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        BigInteger c=in.nextBigInteger(2).add(in.nextBigInteger(2));
      System.out.print(c.toString(2));
    }
}
