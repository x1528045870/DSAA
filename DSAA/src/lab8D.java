import java.io.*;
import java.util.*;
//哈夫曼树
public class lab8D {
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        int n=in.nextInt();
        long[] num=new long[n+1];
        long[] sum=new long[n];
        int front1=1;
        int front2=1;
        int rear2=1;
        long total=0;
        for (int i=1;i<n+1;i++){
            num[i]=in.nextLong();
        }
        if(n>1){
        mergeSort(num,1,n);
        for(int i=1;i<n;i++){
            long min1;long min2;
            if((rear2-front2)==0||(front1<n+1&&num[front1]<=sum[front2])){
                min1=num[front1];front1++;
            }else {
                min1=sum[front2];front2++;
            }
            if((rear2-front2)==0||(front1<n+1&&num[front1]<=sum[front2])){
                min2=num[front1];front1++;
            }else {
                min2=sum[front2];front2++;
            }
            sum[rear2]=min1+min2;
            rear2++;
        }

        for(int i=1;i<rear2;i++){
            total+=sum[i];
        }}
        out.println(total);
        out.close();
    }
    public static void merge(long[] a,int low,int mid,int high){
        int i=0;
        int l=low;
        int r=mid+1;
        long[] c=new long[high-low+1];
        while(l<=mid&&r<=high){
            if(a[l]<=a[r]){
                c[i++]=a[l++];
            }
            else {
                c[i++]=a[r++];
            }
        }
        while (l<=mid){
            c[i++]=a[l++];
        }
        while (r<=high){
            c[i++]=a[r++];
        }
        for (int j=0;j<i;j++){
            a[low+j]=c[j];
        }
    }//排序
    public static void mergeSort(long[] a,int low,int high){
        if(low<high){
            int mid=low+(high-low)/2;
            mergeSort(a,low,mid);
            mergeSort(a,mid+1,high);
            merge(a,low,mid,high);
        }
    }
}
