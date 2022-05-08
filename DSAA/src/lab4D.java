import java.io.*;
import java.util.*;
class nodeQH{//自己写链表
    int weight;//记录指数
    int num;
    nodeQH next;//新建内存空间
    nodeQH previous;
    public nodeQH(int weight,int num){//构造链表
        this.weight=weight;
        this.num=num;
    }
}
public class lab4D {
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        int n=in.nextInt();
        nodeQH[] array=new nodeQH[n];
        nodeQH[] arr=new nodeQH[n];
        for(int i=0;i<n;i++){
            nodeQH a=new nodeQH(in.nextInt(),i);
            array[i]=a;
            arr[i]=a;
        }
        mergeSort(arr,0,n-1);
        nodeQH head = new nodeQH(-1000000000 - 1,-10000000-1);
        nodeQH cur = head;
        for(int i=0;i<n;i++){
            cur.next=arr[i];
            arr[i].previous=cur;
            cur=cur.next;
        }
        nodeQH tail = new nodeQH( 100000000 + 1,100000000+1);
        cur.next = tail;
        tail.previous=cur;
      for(int i=0;i<n-1;i++){
          int a=array[i].previous.weight;
          int b=array[i].weight;
          int c=array[i].next.weight;
          if(array[i].previous==head){
              out.print(c-b+" ");
          }
          else if(array[i].next==tail){
              out.print(b-a+" ");
          }
          else if(b-a>c-b){
              out.print(c-b+" ");
          }
          else if(b-a<=c-b) {
              out.print(b-a+" ");
          }
          array[i].previous.next=array[i].next;
          array[i].next.previous=array[i].previous;
      }

        out.close();
    }
public static void merge(nodeQH[] a,int low,int mid,int high){
        int i=0;
        int l=low;
        int r=mid+1;
        nodeQH[] c=new nodeQH[high-low+1];
        while (l<=mid&&r<=high){
            if(a[l].weight<a[r].weight){
                c[i++]=a[l++];
            }
            else {
                c[i++]=a[r++];
            }
        }
        while (l<=mid){
            c[i++]=a[l++];
        }
        while(r<=high){
            c[i++]=a[r++];
        }
    for (int j=0;j<i;j++){
        a[low+j]=c[j];
    }
}
    public static void mergeSort(nodeQH[] a,int low,int high){
        if(low<high){
            int mid=low+(high-low)/2;
            mergeSort(a,low,mid);
            mergeSort(a,mid+1,high);
            merge(a,low,mid,high);
        }
    }
}
