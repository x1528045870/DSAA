import java.io.*;
import java.util.*;
class Deque{
    int me;
    Deque next;
    Deque previous;

    public Deque(int me){
        this.me=me;
    }
}
public class lab5EE {
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        do {
            int n=in.nextInt();
            Deque[] dequeHead=new Deque[n];
            Deque[] dequeTail=new Deque[n];
            for (int i=0;i<n;i++){
            Deque head = new Deque(1000000 + i);
            Deque tail = new Deque(-1000000 - i);
            head.next = tail;
            tail.previous=head;
            dequeHead[i]=head;
            dequeTail[i]=tail;}
            int q=in.nextInt();
            for (int i=0;i<q;i++){
                int num=in.nextInt();
                if(num==1){
                    int u=in.nextInt();
                    int w=in.nextInt();
                    int val=in.nextInt();
                    if(w==0){
                        Deque va=new Deque(val);
                        va.next=dequeHead[u-1].next;
                        va.previous=dequeHead[u-1];
                        dequeHead[u-1].next.previous=va;
                        dequeHead[u-1].next=va;
                    }
                    else {
                        Deque va=new Deque(val);
                        va.previous=dequeTail[u-1].previous;
                        va.next=dequeTail[u-1];
                        dequeTail[u-1].previous.next=va;
                        dequeTail[u-1].previous=va;
                    }
                }
                else if(num==2){
                    int u=in.nextInt();
                    int w=in.nextInt();
                    if(dequeHead[u-1].next==dequeTail[u-1]){
                        out.println(-1);
                    }
                    else {
                        if (w == 0) {
                            out.println(dequeHead[u-1].next.me);
                            dequeHead[u - 1].next = dequeHead[u - 1].next.next;
                            dequeHead[u - 1].next.previous = dequeHead[u - 1];
                        } else {
                            out.println(dequeTail[u-1].previous.me);
                            dequeTail[u - 1].previous = dequeTail[u - 1].previous.previous;
                            dequeTail[u - 1].previous.next = dequeTail[u - 1];
                        }
                    }
               }
                else if(num==3){
                    int u=in.nextInt();
                    int v=in.nextInt();
                    int w=in.nextInt();
                    if(w==0){
                        dequeHead[v-1].next.previous=dequeTail[u-1].previous;
                        dequeTail[u-1].previous.next=dequeHead[v-1].next;
                        dequeTail[u-1].previous=dequeTail[v-1].previous;
                        dequeTail[v-1].previous.next=dequeTail[u-1];
                        dequeHead[v-1].next=dequeTail[v-1];
                        dequeTail[v-1].previous=dequeHead[v-1];
                    }
                    else {
                        while (dequeTail[v-1].previous!=dequeHead[v-1]){
                            Deque car=dequeTail[v-1].previous;
                            car.previous.next=dequeTail[v-1];
                            dequeTail[v-1].previous=car.previous;
                            car.next=dequeTail[u-1];
                            car.previous=dequeTail[u-1].previous;
                            dequeTail[u-1].previous.next=car;
                            dequeTail[u-1].previous=car;
                        }
                    }
                }
            }
        }while (in.hasNext());
        out.close();
    }
}

