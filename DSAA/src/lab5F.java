import java.io.*;
import java.util.*;
class Mm{
    int num;
    int place;
    public Mm(int num,int place){//构造链表
        this.num=num;
        this.place=place;
    }
}
public class lab5F {
        static int k;
        static int n;
        static Mm[] num;
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out =new QWriter();
        k=in.nextInt();
        n=in.nextInt();
        int maxLength=1;
        num=new Mm[n];
        for(int i=0;i<n;i++) {
            Mm a=new Mm(in.nextInt(),i);
            num[i]=a;
        }
        check(26);
        out.println(check(26));
       /* for (int i=2;i<=n;i++){
            if(check(i)){
                maxLength=i;
            }
        }
       int left=1;int right=n;
        while (left<=right){
            int mid=left+(right-left)/2;
            boolean abab=check(mid);
            if (abab){
                //maxLength=mid;
                left=mid;
            }else {
                right=mid-1;
            }
        }
        out.println(maxLength);*/
        out.close();
    }
    public static boolean check(int length){
    ArrayDeque<Mm> max=new ArrayDeque<>();
    ArrayDeque<Mm> min=new ArrayDeque<>();
    max.add(num[0]);
    min.add(num[0]);
    for(int i=1;i<n;i++){
        if (max.size()!=0&&(i-max.getFirst().place)>=length){
            max.removeFirst();
        }
        while (max.size()!=0&&num[i].num>max.getLast().num){
            max.removeLast();
        }
        max.addLast(num[i]);
        if(min.size()!=0&&(i-min.getFirst().place)>=length){
            min.removeFirst();
        }
        while (min.size()!=0&&num[i].num<min.getLast().num){
            min.removeLast();
        }
        min.addLast(num[i]);
        if(max.getFirst().num-min.getFirst().num<=k&&((max.getLast().place-max.getFirst().place)==length-1
                ||(max.getLast().place-min.getFirst().place)==length-1)){
            //System.out.println(max.getFirst().num);
            //System.out.println(max.getLast().num);
            //System.out.println(min.getFirst().num);
            return true;
        }
    }
return false;
    }
}
