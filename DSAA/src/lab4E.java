import java.io.*;
import java.util.*;
class nod{
    int num;
    nod next;
    nod previous;
    public nod(int num){
        this.num=num;
    }
}
public class lab4E {
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        int T=in.nextInt();
        for(int t=0;t<T;t++){
            int n=in.nextInt();
            nod head=new nod(-1000000000-1);
            nod cur=head;
            for(int i=0;i<n;i++){
                nod a=new nod(in.nextInt());
                a.previous=cur;
                cur.next=a;
                cur=cur.next;
            }
            nod tail=new nod(1000000000+1);
            cur.next=tail;
            tail.previous=cur;
                cur=head.next;
                while(cur!=tail){
                    boolean change=false;
                    if(cur.num>cur.next.num){
                        nod car=cur;
                        while(car.num>car.next.num){
                            car=car.next;
                        }//cur到car全删
                        cur.previous.next=car.next;
                        car.next.previous=cur.previous;
                        car.next=tail;
                        //cur变成前面那位
                        cur=cur.previous;
                        change=true;
                    }//如果变了的话,就得重新测试，先不往下走
                    if(!change){
                    cur=cur.next;}
                }
            cur=head.next;
            while(cur!=tail){
                out.print(cur.num+" ");
                cur=cur.next;
            }
            out.println("");
        }
        out.close();
    }
}
