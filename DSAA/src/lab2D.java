import java.util.Arrays;
import java.util.Scanner;
public class lab2D {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        long[] a=new long[n];
        for(int i=0;i<n;i++){
            a[i]=in.nextLong();
        }
        Arrays.sort(a);
        int k=0;
        while(Math.pow(2,k)<=a[n-1]+a[n-1]){
            k++;
        }
        int num=0;
        long[] m=new long[k];
        for(int i=0;i<k;i++){
            m[i]=(long) Math.pow(2,i);
        }
        for(int i=0;i<n-1;i++){
            for(int j=0;j<k;j++){
                long aj=m[j]-a[i];
                if(aj>=a[i]){
                   num+=findNum(a,i,n,aj);
                }
            }
        }
        System.out.println(num);
    }
    public static int findNum(long[] a,int i,int n,long aj){
        int left=i+1;int right=n-1;
        int num=0;
        while (left<=right){
            int mid=left+(right-left)/2;
            if(a[mid]==aj){
                num++;
                int j=mid;
                int k=mid;
                while (j>i+1&&a[j-1]==aj){
                    num++;j--;
                }
                while (k<n-1&&a[k+1]==aj){
                    num++;k++;
                }
                return num;
            }
            else if(a[mid]<aj){
                left=mid+1;
            }
            else {
                right=mid-1;
            }
        }
        return num;
    }
}
