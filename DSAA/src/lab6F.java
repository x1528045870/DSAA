import java.io.*;
import java.util.*;
public class lab6F {
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        char[] duiYing=in.next().toCharArray();
        char[] str=in.next().toCharArray();
        //前半部分转原文
        for(int i=0;i<str.length/2;i++){
           int j=Arrays.binarySearch(duiYing,str[i]);
           str[i]= (char) (j+97);
        }
        String st=String.valueOf(str);
        String  before=st.substring(0,st.length()/2);
        String back=st.substring(st.length()/2);
        out.println(before);
        out.println(back);
        //比较
        int k=0;
        boolean check=false;
        while(k!=-1&&!check){
            int j=back.length()-1;
            k=before.lastIndexOf(back.charAt(j));
            j--;
            k--;
            while (before.lastIndexOf(back.charAt(j))==k){
               k--;j--;

            }
        }




        out.close();
    }
}
