import java.io.*;
import java.util.*;
public class lab3E {
    public static long cost=0;
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n=in.nextInt();
        long[] a=new long[n];
        for (int i=0;i<n;i++){
            a[i]=in.nextLong();
        }
        long t;
        mergeSort(a,0,n-1);

        out.println(cost);
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
                    cost+=a[r]*(mid-l+1);

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
