import java.io.*;
import java.util.*;
class node2{//自己写链表
    int weight;//记录weight
    boolean hasConnected=false;
    node2 next;//新建内存空间
    public node2(int weight){//构造链表
        this.weight=weight;
    }
}
public class lab4C {
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        int n=in.nextInt();
        int p=in.nextInt();
        int q=in.nextInt();
        node2[] w=new node2[n];
        node2[] tail=new node2[n];
        for(int i=0;i<n;i++){
           w[i]=new node2(in.nextInt());
           tail[i]=w[i];
        }
        for(int i=0;i<p;i++){
            int a=in.nextInt();
            int b=in.nextInt();
            w[b-1].hasConnected=true;
            tail[a-1].next=w[b-1];
            tail[a-1]=tail[a-1].next;
        }
        for(int i=0;i<n;i++){
           if(!w[i].hasConnected){
               node2 cur=w[i];
               for(int j=0;j<q-1;j++){
                   cur=cur.next;
               }
               out.print(cur.weight+" ");
           }
        }
        out.close();
    }
}
