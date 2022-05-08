import java.util.Scanner;
public class Sort {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int n=10;
        int[] arr = {11,44,23,67,88,65,34,48,9,12};
        mergeSort(arr,0,n-1);
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
    public int Partition(int[] a,int low,int high){
        //选取基准元素
        int pivot=a[low];
        while(low < high){
            while(low < high && a[high] >= pivot) {--high;//先从右往左，找到第一个比基准元素小的，将该元素填入左哨兵的位置
            a[low]=a[high];}
            while(low < high && a[low] <= pivot) {++low;//再从左往右，找到第一个比基准元素大的，将该元素填入右哨兵的位置
            a[high]=a[low];}//右哨兵继续走，直到遇见左哨兵，循环结束
        }
        a[low]=pivot;//将基准元素放到相遇的位置
        return low;
    }

    public void QuickSort(int[] a,int low,int high){
        if(low < high){
            int pivotpos=Partition(a,low,high);
            QuickSort(a,low,pivotpos-1);
            QuickSort(a,pivotpos+1,high);
        }
    }

}


