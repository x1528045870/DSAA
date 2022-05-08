import java.io.*;
import java.util.*;
class stu{//自己写链表
    int num;//记录次序
    stu next;//新建内存空间
    public stu(int num){//构造链表
        this.num=num;
    }
}
public class lab4B {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n = in.nextInt();
        int m = in.nextInt();
        int remainNum=n;
        stu head = new stu(1000000000 + 1);
        stu cur = head;
        for (int i = 0; i < n; i++) {
            //新建一个节点来接到后边
            stu a = new stu(i+1);
            //使a连在链表的尾部
            cur.next = a;
            //cur再移到a的位置，向后转移
            cur = cur.next;
        }
        stu tail=new stu(-10000000 - 1);
        cur.next=tail;
        while(remainNum>0){
            cur=head;int t=0;int i=1;int mm=m;
           while(i<=remainNum){
               i++;
               if(mm==m&&cur.next!=tail){
                   out.print(cur.next.num+" ");
                   cur.next=cur.next.next;
                   mm=0;
                   t++;}
                else{cur=cur.next;}

                mm++;}
            remainNum-=t;
        }
        out.close();
    }
}
