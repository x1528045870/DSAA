import java.io.*;
import java.util.*;
//建小根堆，大根堆
public class lab8E {
    static int[] bigHeap;
    static int[] smallHeap;
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        int N=in.nextInt();
        int[] A=new int[N];
        bigHeap=new int[N+1];
        int bigS=2;
        smallHeap=new int[N+1];
        int smallB=1;
        for (int i=0;i<N;i++){
            A[i]=in.nextInt();
        }
        //建一个大根堆
        bigHeap[1]=A[0];
        out.print(bigHeap[1]+" ");
        for(int i=1;i<N;i++){
            if(A[i]<bigHeap[1]){
                insertBig(A[i],bigS);
                bigS++;
            }else{
                insertSmall(A[i],smallB);
                smallB++;
            }
            if(smallB>bigS){
                smallB--;
                insertBig(deleteMin(smallB),bigS);
                bigS++;

            }else if(smallB<bigS-1){
                bigS--;
                insertSmall(deleteMax(bigS),smallB);
                smallB++;
            }
            out.print(bigHeap[1]+" ");
        }
        out.close();
    }
    public static void insertBig(int num,int end){
        //end是新插入的位置
        bigHeap[end]=num;
        while(end>1&&bigHeap[end]>bigHeap[end/2]){
            int t=bigHeap[end];
            bigHeap[end]=bigHeap[end/2];
            bigHeap[end/2]=t;
            end/=2;
        }
    }
    public static void insertSmall(int num,int end){
        //end是新插入的位置
        smallHeap[end]=num;
        while(end>1&&smallHeap[end]<smallHeap[end/2]){
            int t=smallHeap[end];
            smallHeap[end]=smallHeap[end/2];
            smallHeap[end/2]=t;
            end/=2;
        }
    }
    public  static int deleteMin(int end){
        int min=smallHeap[1];
        smallHeap[1]=smallHeap[end];
        fallingDown(1,end);
        return min;
    }
    public static void fallingDown(int i,int end){
        //与下一位小的递归交换
        int left=2*i;
        int right=2*i+1;
        int min=i;
        if(left<=end&&smallHeap[left]<smallHeap[min]){
            min=left;
        }
        if(right<=end&&smallHeap[right]<smallHeap[min]){
            min=right;
        }
        if(min==i){
            return;
        }
        int t=smallHeap[i];
        smallHeap[i]=smallHeap[min];
        smallHeap[min]=t;
        fallingDown(min,end);
    }
    public static int deleteMax(int end){
        int max=bigHeap[1];
        bigHeap[1]=bigHeap[end];
        fallDown(1,end);
        return max;
    }
    public static void fallDown(int i,int end){
        //与下一位大的递归交换
        int left=2*i;
        int right=2*i+1;
        int max=i;
        if(left<end&&bigHeap[left]>bigHeap[max]){
            max=left;
        }
        if(right<end&&bigHeap[right]>bigHeap[max]){
            max=right;
        }
        if(max==i){
            return;
        }
        int t=bigHeap[i];
        bigHeap[i]=bigHeap[max];
        bigHeap[max]=t;
        fallDown(max,end);
        //代码复制其他修改的时候，记得每个点都要修改
    }
}
