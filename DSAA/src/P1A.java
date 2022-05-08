import java.util.Arrays;
import java.util.Scanner;
public class P1A {
    public static void main(String[] args) {
         Scanner in=new Scanner(System.in);
         int n1=in.nextInt();
         int[] A=new int[n1];
         for(int i=0;i<n1;i++){
             A[i]=in.nextInt();
         }
         Arrays.sort(A);
         int n2=in.nextInt();
         int[] B=new int[n2];
         for(int j=0;j<n2;j++){
             B[j]=in.nextInt();
             int a= Arrays.binarySearch(A,B[j]);
             if(a>0){
                 System.out.println("yes");
             }
             else{System.out.println("no");}
         }
    }
}
