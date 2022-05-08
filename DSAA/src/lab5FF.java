import java.io.*;
import java.util.*;
public class lab5FF {
    static int k;
    static int n;
    static Mm[] num;
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out =new QWriter();
        k=in.nextInt();
        n=in.nextInt();
        int maxLength=0;
        num=new Mm[n];
        for(int i=0;i<n;i++) {
            Mm a=new Mm(in.nextInt(),i);
            num[i]=a;
        }
        ArrayDeque<Mm> max=new ArrayDeque<>();
        ArrayDeque<Mm> min=new ArrayDeque<>();
        max.add(num[0]);
        min.add(num[0]);
        int i=0;int j=0;
        while (j<n-1){
            if(min.size()==0||max.size()==0){
                if (j-i+1 > maxLength){
                    maxLength = j-i+1;
                }
                j++;
                while (max.size()!=0&&num[j].num>max.getLast().num){
                    max.removeLast();
                }
                max.addLast(num[j]);
                while (min.size()!=0&&num[j].num<min.getLast().num){
                    min.removeLast();
                }
                min.addLast(num[j]);
            }
            else if (max.getFirst().num-min.getFirst().num<=k){
                if (j-i+1 > maxLength){
                    maxLength = j-i+1;
                }
                j++;
                while (max.size()!=0&&num[j].num>max.getLast().num){
                    max.removeLast();
                }
                max.addLast(num[j]);
                while (min.size()!=0&&num[j].num<min.getLast().num){
                    min.removeLast();
                }
                min.addLast(num[j]);
            }else {i++;
                max.removeFirst();
                min.removeFirst();
            }
            if(min.size()==0||max.size()==0){
                if (j- i + 1 > maxLength) {
                    maxLength = j - i + 1;
                }
            }
            else if (max.getFirst().num-min.getFirst().num<=k) {
                if (j- i + 1 > maxLength) {
                    maxLength = j - i + 1;
                }
            }
        }
            out.println(maxLength);
            out.close();

    }
}
