package lab4;
import java.util.Scanner;
import java.util.Random;
public class Num {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        Random random=new Random();
        int magicNum=random.nextInt(10);
        int inputNum;
        System.out.println("Please input an Integer in{0,1,2,...,9}:");
        inputNum = input.nextInt();
        while (inputNum!=magicNum){
            if(inputNum>magicNum){
                System.out.println("Too big!Please try again:");
            }
            else{
                System.out.println("Too Small!Please try again:");
            }
            inputNum=input.nextInt();
        }
        System.out.println("Congratulations!");
    input.close();}
}
