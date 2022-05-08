package lab8;
import java.util.Scanner;
import java.lang.StringBuilder;
public class ex4 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        StringBuilder bb=new StringBuilder(in.nextLine());
        for(int i=0;i<bb.length()-1;i++){
            int i1=bb.lastIndexOf(String.valueOf(bb.charAt(i)));
            if (i1!=i){
            bb.deleteCharAt(i1);
            i=i-1;}
            if(bb.charAt(i)==' '){
              bb.deleteCharAt(i);
                 i=i-1;    }
        }
        System.out.println(bb);


    }
}
