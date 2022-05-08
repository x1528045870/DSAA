import java.io.*;
import java.util.*;
public class lab8A {
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        int n=in.nextInt();
        int[] num=new int[n+1];
        int[] time=new int[n+1];
        for(int j=1;j<n+1;j++){
            num[j]=in.nextInt();
            int i=j;
            while(i>1&&num[i]>num[i/2]){
               int t=num[i];
               num[i]=num[i/2];
               num[i/2]=t;
               time[j]++;
               i=i/2;
            }
        }
        for(int i=1;i<n+1;i++){
            out.print(time[i]+" ");
        }
        out.close();
    }
}
