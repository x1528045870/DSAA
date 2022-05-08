import java.io.*;
import java.util.*;
public class lab3C {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n=in.nextInt();
        long[][] ou=new long[n][];
        String[] o=new String[n];
        int T=0;
        for(int k=0;k<n;k++){
            int num= in.nextInt();
            long[] a=new long[num];
            for (int i=0;i<num;i++){
                a[i]=in.nextLong();
            }
            long[]b=a;
            long swapI=0;
            long swapS=0;
            long t;
            //insertion
            for(int i=1;i<num;i++){
                for(int j=i;j>0;j--){
                    swapI++;
                    if(b[j-1]>b[j]){
                        t=b[j];
                        b[j]=b[j-1];
                        b[j-1]=t;
                        swapI++;
                    }else {
                        break;
                    }
                }
            }
            //selection
            for(int i=0;i<num-1;i++){
                int m=i;
                for(int j=i+1;j<num;j++){
                    swapS++;
                    if(a[m]>a[j]){
                        m=j;swapS++;
                    }
                }
                swapS++;
                if(m!=i){swapS++;
                    t=a[m];
                    a[m]=a[i];
                    a[i]=t;
                }
            }
            ou[T]=a;
            if(swapI>swapS){
                o[T]="Selection Sort wins!";
            }else if(swapI<swapS){
                o[T]="Insertion Sort wins!";
            }
           T++;
        }
        for(int i=0;i<T;i++){
            for(int j=0;j<ou[i].length;j++){
                out.print(ou[i][j]+" ");
            }
            out.println("");
            out.println(o[i]);
        }
        out.close();
    }
}
