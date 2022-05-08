import java.io.*;
import java.util.*;
public class lab6E {
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        String str=in.next();
        int max=0;
        int length=0;
        int numOfS=0;
        char before=0;
        char beforeBefore=0;
        boolean start=false;
        Stack<Character> huiWen=new Stack<>();
        for(int i=0;i<str.length();i++){
            char word=str.charAt(i);
            if(numOfS>2){
                if(!start&&word==beforeBefore){
                 start=true;
                 length+=3;
                 huiWen.pop();
                 huiWen.pop();
                 before=0;beforeBefore=0;
                }else if(!start&&word==before){
                    start=true;
                    length+=2;
                    huiWen.pop();
                    before=0;beforeBefore=0;
                }
                else if(start){
                    if(huiWen.empty()){
                        start=false;
                        if(length>max){
                            max=length;
                        }
                        length=0;
                        numOfS=0;
                    }
                    else if (huiWen.peek()==word){
                        huiWen.pop();
                        length+=2;
                        if(i==str.length()-1){
                            if(length>max){
                                max=length;
                            }
                        }
                    }else {
                        start=false;
                        huiWen.clear();
                        if(length>max){
                            max=length;
                        }
                        length=0;
                        numOfS=0;
                    }
                }
                else {
                    huiWen.push(word);
                    beforeBefore=before;
                    before=word;
                }
            }else if (numOfS==0){
                huiWen.push(word);
                numOfS++;
                before=word;
            }else {
                huiWen.push(word);
                numOfS++;
                beforeBefore=before;
                before=word;
            }
        }
        out.println(max);
        out.close();
    }
}
