import java.util.Arrays;
import java.io.*;
import java.util.*;
public class lab3B {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n=in.nextInt();
        long m;
        long[] a=new long[n];
        for (int i=0;i<n;i++){
            a[i]=in.nextLong();
        }
        mergeSort(a,0,n-1);
        //quickSort(a,0,n-1);
        if(n%2==1){
            m=2*a[(n+1)/2-1];
        }
        else{
            m=a[n/2-1]+a[n/2+1-1];
        }
        out.println(m);
        out.close();
    }
    //并
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
    public static void quickSort(long[] a,int low,int high){
        int i,j;
        long rand;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        rand=a[i];
        while(i<j){
            //向左找比基准数小的数
            while (rand<=a[j]&&i<j){
                j--;
            }
            //向右找比基准数大的数
            while (rand>=a[i]&&i<j){
                i++;
            }
            //交换
            if(i<j){
                long t;
                t=a[j];
                a[j]=a[i];
                a[i]=t;
            }

        }
        //将天选之数放到它该去的地方
        a[low]=a[i];
        a[i]=rand;
        //左边也这样
        quickSort(a, low, i-1);
        //右边也这样
        quickSort(a,i+1,high);
    }
}
