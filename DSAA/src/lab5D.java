import java.io.*;
import java.util.*;
public class lab5D {
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        String all=in.next();
        char[] kuoHao=new char[all.length()];
        int top=0;
        int i=0;
        char before=all.charAt(0);
        long score;
        long[] linShiScore=new long[all.length()];
        while(top!=-1&&i<all.length()){
            if(all.charAt(i)=='('){
                kuoHao[top]='(';
                top++;
            }
            else {
                if(before=='('){
                    linShiScore[top-1]=(linShiScore[top-1]+1)%514329;
                }
                else {
                    linShiScore[top-1]=(linShiScore[top-1]+linShiScore[top]*2%514329)%514329;
                    linShiScore[top]=0;
                }
                top--;
                kuoHao[top]=0;
            }
            before=all.charAt(i);
            i++;
        }
        score=linShiScore[0]%514329;
        out.println(score);
        out.close();
    }
}
