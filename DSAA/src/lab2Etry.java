import java.util.Scanner;
public class lab2Etry {
    public static void main(String[] args) {
        //读入阶段
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int T=in.nextInt();
        int[] a=new int[n];
        int[] b=new int[n];
        int[] l=new int[T];
        int[] r=new int[T];
        int[] result=new int[T];
        for(int i=0;i<n;i++){
            a[i]=in.nextInt();
        }
        for(int i=0;i<n;i++){
            b[i]=in.nextInt();
        }
        for (int i=0;i<T;i++){
            l[i]=in.nextInt()-1;
            r[i]=in.nextInt()-1;
        }
        for(int k=0;k<T;k++){
            int min;int max;
             min=l[k];max=r[k];
             while(min<=max){
                 int mid=min+(max-min)/2;
                 if(a[mid]==b[mid]){
                     System.out.println(a[mid]);
                 }
             }

        }
         }
         public static int numa(int x,int l,int r,int[] b){
         while(l<=r){
             int mid=l+(r-l)/2;
             if(x>b[mid]){
                 l=mid+1;
             }
             else {r=mid-1;}
         }
         if(r>=0){return r;}
           return -1;
         }
    public static int numb(int x,int l,int r,int[] a){
        while(l<=r){
            int mid=l+(r-l)/2;
            if(x>a[mid]){
                l=mid+1;
            }
            else {r=mid-1;}
        }
        if(r>=0){return r;}
        return -1;
    }

}
