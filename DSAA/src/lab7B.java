import java.io.*;
import java.util.*;
class FL{
    int nu;
    ArrayList<FL> leaves=new ArrayList<>();
    boolean isVisited=false;
    public FL(int nu){
        this.nu=nu;
    }
}
public class lab7B {
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        int n=in.nextInt();
        FL[] nodes=new FL[n+1];
        for(int i=1;i<=n;i++){
            FL node=new FL(i);
            nodes[i]=node;
        }
        for(int i=0;i<n-1;i++){
            int u=in.nextInt();
            int v=in.nextInt();
            nodes[u].leaves.add(nodes[v]);
            nodes[u].isVisited=true;
        }
        ArrayList<Integer> leaves=new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(!nodes[i].isVisited){
                leaves.add(nodes[i].nu);
            }
        }
        int[] asLeaves=new int[leaves.size()];
        for(int i=0;i<leaves.size();i++){
            asLeaves[i]=leaves.get(i);
        }
        mergeSort(asLeaves,0, asLeaves.length-1);
        for (int asLeaf : asLeaves) {
            out.println(asLeaf);
        }
        out.close();
    }
    public static void merge(int[] a,int low,int mid,int high){
        int i=0;
        int l=low;
        int r=mid+1;
        int[] c=new int[high-low+1];
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
    public static void mergeSort(int[] a,int low,int high){
        if(low<high){
            int mid=low+(high-low)/2;
            mergeSort(a,low,mid);
            mergeSort(a,mid+1,high);
            merge(a,low,mid,high);
        }
    }
}
