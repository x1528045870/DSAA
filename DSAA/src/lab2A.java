import java.util.Scanner;
// 二分查找binary search
public class lab2A {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[]array= new int[n];
        for(int i=0;i<n;i++) {
            array[i] = in.nextInt();
        }
        int T=in.nextInt();
        int[]num =new int[T];
        for(int i=0;i<T;i++){
            num[i]=in.nextInt();
        }
        for(int i=0;i<T;i++){
            int t=num[i];
            int left=0;int right=n-1;
            while(right>=left){
                int mid=(left+right)/2;
                if (t==array[mid]){
                    System.out.println("YES");
                    break;
                }
                else if(t<array[mid]){
                    right=mid-1;
                }
                else {
                    left=mid+1;
                }
            }
            if(left>right){
                System.out.println("NO");
            }
        }


    }
}
