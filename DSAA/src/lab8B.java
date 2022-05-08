import java.io.*;
import java.util.*;
public class lab8B {
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        int n=in.nextInt();
        int[] num=new int[n+1];
        boolean max=false;
        boolean check=true;
        num[1]=in.nextInt();
        num[2]=in.nextInt();
        if(num[1]>num[2]){
            max=true;
        }
        for(int i=3;i<n+1;i++){
            num[i]=in.nextInt();
            if(max&&num[i]>num[i/2]){
               check=false;
               out.println("Neither");
               break;
            } else if (!max&&num[i]<num[i/2]) {
                check=false;
                out.println("Neither");
                break;
            }
        }
        if(check){
            if (max){
                out.println("Max");
            }else {
                out.println("Min");
            }
        }
        out.close();
    }
}
