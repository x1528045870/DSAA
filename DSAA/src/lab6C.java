import java.io.*;
import java.util.*;
public class lab6C {
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        String s=in.next();
        int l=s.length();
        int[] next=new int[l];
        next[0]=0;
        int k=0;
        int j=1;
        while (j<l){
            if(s.charAt(j)==s.charAt(k)){
                k++;
                next[j]=k;
                j++;
            }
            else if(k==0){
                next[j]=0;
                j++;
            }
            else {
                k = next[k-1];
            }
        }
        for (int i=0;i<l;i++){
            out.println(next[i]);
        }
        out.close();
    }
}
