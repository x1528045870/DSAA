import java.io.*;
import java.util.*;
public class lab3D {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n=0;
        int num=in.nextInt();
        long[] a=new long[num];
        for(int i=0;i<num;i++){
            a[i]=in.nextLong();
        }
        int i=0;long t;
        while(n<num){
            if(i==0){
                if(2*a[i]==(a[1]+a[num-1])){
                    t=a[i];
                    a[i]=a[1];
                    a[1]=t;
                    n=0;
                }
                else {
                    n++;
                }
            i++;}
            else if(i==num-1){
                if(2*a[num-1]==a[0]+a[num-2]){
                    t=a[num-1];
                    a[num-1]=a[0];
                    a[0]=t;
                    n=0;
                }
                else {n++;}
                i=0;}
            else {if(2*a[i]==(a[i-1]+a[i+1])){
                t=a[i];
                a[i]=a[i+1];
                a[i+1]=t;
                n=0;
            }
            else {
                n++;
            }
            i++;
            }
        }
        for(int j=0;j<num;j++){
            out.print(a[j]+" ");
        }
        out.println("");
        out.close();
    }
}
