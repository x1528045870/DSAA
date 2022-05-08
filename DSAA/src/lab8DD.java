import java.io.*;
import java.util.*;
//哈夫曼树
public class lab8DD {
    //建个小顶堆
        static long[] num;
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        int n=in.nextInt();
        num=new long[n+1];
        int rear=0;
        long total=0;
        for (int i=1;i<n+1;i++){
            insert(in.nextInt(),i);
            rear++;
        }
        if(n>1){
            for(int i=1;i<n;i++){
                long min1=deleteMin(rear);
                rear--;
                long min2=deleteMin(rear);
                rear--;
                long sum=min1+min2;
                rear++;
                insert(sum,rear);
                total+=sum;
            }
            }else {
            total=0;
        }
        out.println(total);
        out.close();
    }
    public static void insert(long number,int i){
        num[i]=number;
        while(i>1&&num[i]<num[i/2]){
            long t=num[i];
            num[i]=num[i/2];
            num[i/2]=t;
            i=i/2;
        }
    }
    public static long deleteMin(int i){
        long min=num[1];
        num[1]=num[i];
        num[i]=0;
        int j=1;
        while ((num[2*j]!=0&&num[j]>num[2*j]||num[2*j+1]!=0&&num[j]>num[2*j+1])){
            long t=num[j];
            if(num[2*j+1]!=0&&num[2*j]>num[2*j+1]){
                num[j]=num[2*j+1];
                num[2*j+1]=t;
            }else {
                num[j]=num[2*j];
                num[2*j]=t;
            }

        }
        return min;
    }
}
