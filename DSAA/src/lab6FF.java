import java.io.*;
import java.util.*;
public class lab6FF{
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        int[] a=new int[26];
        for(int i=0;i<26;i++){
            char x=in.next().charAt(0);
            a[x-'a']=i+'a';
        }
        String st=in.next();
        char[] str=new char[st.length()+1];
        int j=0;
        for(int i=0;i<str.length;i++){
          if (i==str.length/2){
              str[i]='*';
          }
          else {
              str[i]=st.charAt(j);
              j++;
          }
        }
        //前半部分转原文
        for(int i=0;i<str.length/2;i++){
            str[i]= (char) (str[i]-'a');
        }
        int n=str.length;
        int[] next=new int[n];
        int i=0;j=1;
        next[0]=0;
        while (j<n){
            if(str[j]==str[i]){
                i++;
                next[j]=i;
                j++;
            }
            else if(i==0){
                next[j]=0;
                j++;
            }
            else {
                i = next[i-1];
            }
        }
        j=n;
        while(next[j-1]>n/2){
            j=next[j-1];
        }
        out.println(n-1-next[j-1]);
        out.close();
    }
}
