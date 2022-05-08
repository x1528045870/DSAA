import java.io.*;
import java.util.*;
public class lab7D {
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        int n=in.nextInt();
        for(int x=0;x<n;x++){
        long k=1;
        String preOrder=in.nextLine();
        String postOrder=in.nextLine();
        int l=preOrder.length();
        char[] pre=new char[l];
        char[] post=new char[l];
        int[] place=new int[26];
        for (int i=0;i<l;i++){
            pre[i]=preOrder.charAt(i);
            post[i]=postOrder.charAt(l-i-1);
            place[post[i]-65]=i;
        }
        for(int i=0;i<l-1;i++){
            int j=place[pre[i]-65];
            if(j!=l-1&&pre[i+1]==post[j+1]){
                k=k*2;
            }
        }
        out.println(k);}
        out.close();
    }
}
