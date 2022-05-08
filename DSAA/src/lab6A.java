import java.io.*;
import java.util.*;
public class lab6A {
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        String s=in.next();
        int num=0;
        for(int i=s.length();i>0;i--){
            num+=s.length()-i+1;
            String[] sub=new String[s.length()-i+1];
            for(int j=0;j<s.length()-i+1;j++){
                sub[j]=s.substring(j,i+j);
                for(int k=0;k<j;k++){
                    if(sub[j].equals(sub[k])){
                        num--;
                        break;
                    }
                }
            }
        }
        out.println(num);
        out.close();
    }
}
