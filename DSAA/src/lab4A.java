import java.io.*;
import java.util.*;
class node{//自己写链表
    int coe;//记录系数
    int exp;//记录指数
    node next;//新建内存空间
    public node(int coe,int exp){//构造链表
        this.coe=coe;
        this.exp=exp;
    }
}
public class lab4A {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n = in.nextInt();
        int m = in.nextInt();
        //构造一个链表头
        node head = new node(1000000000 + 1, 1000000000 + 1);
        //供以承转的中间商节点,也就是整个链表的车
        node cur = head;
        for (int i = 0; i < n; i++) {
            //新建一个节点来接到后边
            node a = new node(in.nextInt(), in.nextInt());
            //使a连在链表的尾部
            cur.next = a;
            //cur再移到a的位置，向后转移
            cur = cur.next;
        }
        //造一个够不到的尾部
        node tail = new node(-10000000 - 1, -100000000 - 1);
        cur.next = tail;
        cur = head;
        for (int i = 0; i < m; i++) {
            int coe2 = in.nextInt();
            int exp2 = in.nextInt();
            while (cur.next.exp >= exp2) {//找到位置，确定位置
                cur = cur.next;
            }
            if (cur.exp == exp2) {//指数相同则直接系数相加
                cur.coe += coe2;
            } else {//指数不同则接进去
                node a = new node(coe2, exp2);
                //中间造个位置
                a.next = cur.next;
                cur.next = a;
            }
        }
        cur = head.next;
        int cnt = 0;
        while (cur != tail) {
            if (cur.coe != 0) {
                cnt++;
            }
            cur = cur.next;
        }
        out.println(cnt);
        cur = head.next;
        while (cur != tail) {
            if (cur.coe != 0) {
                out.println(cur.coe + " " + cur.exp);
            }
            cur = cur.next;//向后移动
        }
        out.close();
    }
}