import java.io.*;
import java.util.*;
public class lab7C {
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            long num=in.nextLong();
            double x=Math.log(num)/Math.log(2);
            out.println((long)x+1);
        }
        out.close();
    }
}
