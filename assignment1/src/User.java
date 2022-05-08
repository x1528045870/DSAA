import java.util.Scanner;
public class User {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String x = input.next();
        String s=input.next();
        String result= s.compareTo("11500000")>-1&&s.compareTo("12100000")<1?x+", welcome to Baoneng City!":s;
        System.out.println(result);
        input.close();
        }
    }