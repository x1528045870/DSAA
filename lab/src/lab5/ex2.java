package lab5;
import java.util.Scanner;
public class ex2 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int length=input.nextInt();
        int[]array1=new int[length];
        int[]array2=new int[length];
        boolean b=true;
        for(int i=0;i<length-1;i++){
            array1[i]=input.nextInt();
        }
        for(int i=0;i<length-1;i++){
            array2[i]=input.nextInt();
        }
        for(int i=0;i<length-1;i++){
            if (array1[i]!=array2[i]){
                b=false;
                break;
            }
        }
        if (b=true){
            System.out.println("same");
        }
        else{
            System.out.println("different");
        }
    }
}
