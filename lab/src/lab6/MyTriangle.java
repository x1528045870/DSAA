package lab6;
import java.util.Scanner;
public class MyTriangle {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Please input three numbers for a,b,c" );
        double a=in.nextDouble();
        while (a!=-1){
            double b=in.nextDouble();
            double c=in.nextDouble();
            if(isValid(a,b,c)) {
                System.out.println(area(a, b, c));
                System.out.println(perimeter(a, b, c));
            }
            else{
                System.out.println("The input is invalid");
            }
            System.out.println("Please input three numbers for a,b,c");
            a=in.nextDouble();
        }
    }
    public static double area(double a,double b,double c){
    double p=(a+b+c)/2;return Math.pow(p*(p-a)*(p-b)*(p-c),0.5);
    }
    public static double area(double bottom,double height){
        return 1/2*bottom*height;
    }
    public static double area(double a,double b,int angleOfAandB){
        return 1/2*a*b*Math.sin(angleOfAandB);
    }
    public static double perimeter(double a,double b,double c){
        return a+b+c;
    }
    public static boolean isValid(double a,double b,double c){
        boolean result=true;
        if(a+b<=c||a+c<=b||b+c<=a){
            result =false;
        }
        return result;
    }
}
