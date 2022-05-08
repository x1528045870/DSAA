import java.io.*;
import java.util.*;

/**
 * 此处有拓扑排序
 */
class count{
    int a;
    int b;
    int i;
    int enterDegree=0;
    long money=0;
    ArrayList<count>previous=new ArrayList<>();
    ArrayList<count>next=new ArrayList<>();
    public count(int a,int b,int i){
        this.a=a;
        this.b=b;
        this.i=i;
    }
}
public class lab9F {
    static count[] shuZu;
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        int T=in.nextInt();
        for(int k=0;k<T;k++){
            int nodes=in.nextInt();
            int edges=in.nextInt();
            shuZu=new count[nodes+1];
            for(int i=1;i<=nodes;i++){
                int a=in.nextInt();
                int b=in.nextInt();
                count x=new count(a,b,i);
                shuZu[i]=x;
            }
            for(int b=0;b<edges;b++){
                int i=in.nextInt();
                int j=in.nextInt();
                shuZu[i].next.add(shuZu[j]);
                shuZu[j].previous.add(shuZu[i]);
                shuZu[j].enterDegree++;
            }
            tuoPu(1,nodes);
            long sum=0;
            for (int i=1;i<=nodes;i++){
                sum+=shuZu[i].money*shuZu[i].b%((long)Math.pow(10,9)+7);
            }
            sum=sum%((long)Math.pow(10,9)+7);
            out.println(sum);
        }
        out.close();
    }

    /**
     * 拓扑排序
     */
    public static void tuoPu(int start,int end){
        Queue<count>jinJinChuChu=new LinkedList<>();
        for(int i=start;i<=end;i++){
            if(shuZu[i].enterDegree==0){
                jinJinChuChu.add(shuZu[i]);
            }
        }
        while (!jinJinChuChu.isEmpty()){
            count x=jinJinChuChu.poll();
            for (count y:x.next){
                y.enterDegree--;
                y.money+=(x.a%((long)Math.pow(10,9)+7)+x.money%((long)Math.pow(10,9)+7))%((long)Math.pow(10,9)+7);
                if(y.enterDegree==0){
                    jinJinChuChu.add(y);
                }
            }
        }
    }
}
