import java.io.*;
import java.util.*;
//如何建小根堆
class ijHeap{
    long num;
    int i;
    int j;
    public ijHeap(long num,int i,int j){
        this.num=num;
        this.i=i;
        this.j=j;
    }
}
public class lab8C {
    static ijHeap[] heap;
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        int N=in.nextInt();
        int M=in.nextInt();
        int K=in.nextInt();
        int end=N;
        heap=new ijHeap[N+1];
        long[] A=new long[N+1];
        long[] B=new long[M+1];
        for(int i=1;i<=N;i++){
            A[i]=in.nextLong();
        }
        for(int i=1;i<=M;i++){
            B[i]=in.nextLong();
        }
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i=1;i<=N;i++){
            heap[i]=new ijHeap(A[i]*B[1],i,1);
        }
        //建一个小根堆
        for(int k=1;k<=K;k++){
            ijHeap x=deleteMin(end);
            end--;
            out.print(x.num+" ");
            if (x.j+1<=M){
                end++;
            insert(A[x.i]*B[x.j+1],x.i,x.j+1,end);
            }
        }
        out.close();
    }
    public static void insert(long num,int i,int j,int end){
        //end是新插入的位置
        heap[end]=new ijHeap(num,i,j);
        while(end>1&&heap[end].num<heap[end/2].num){
            ijHeap t=heap[end];
            heap[end]=heap[end/2];
            heap[end/2]=t;
            end=end/2;
        }
    }
    public static ijHeap deleteMin(int end){
        ijHeap min=heap[1];
        heap[1]=heap[end];
        heap[end]=null;
        down(1,end);
        return min;
    }
    public static void down(int i,int end){
        int left=2*i;
        int right=2*i+1;
        int min=i;
        if(left<end&&heap[left].num<heap[min].num){
            min=left;
        }
        if(right<end&&heap[right].num<heap[min].num){
            min=right;
        }
        if(min==i){
            return;
        }
        ijHeap t=heap[min];
        heap[min]=heap[i];
        heap[i]=t;
        down(min,end);
    }
}
