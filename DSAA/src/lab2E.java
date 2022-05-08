import java.util.Scanner;
public class lab2E {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int T=in.nextInt();
        long[] a=new long[n];
        long[] b=new long[n];
        int[] l=new int[T];
        int[] r=new int[T];
        long[] result=new long[T];
        for(int i=0;i<n;i++){
            a[i]=in.nextLong();
        }
        for(int i=0;i<n;i++){
            b[i]=in.nextLong();
        }
        for (int i=0;i<T;i++){
            l[i]=in.nextInt()-1;
            r[i]=in.nextInt()-1;
        }
      for(int i=0;i<T;i++){
            int al=l[i];int bl=l[i];
            int ar=r[i];int br=r[i];
            while(al<=ar&&bl<=br) {
                int amid=al+(ar-al+1)/2;
                int bmid=br-(br-bl+1)/2;
                if(al==ar){
                    if(a[amid]<b[bmid]){
                        result[i]=a[amid];
                    }
                    else {
                        result[i]=b[bmid];
                    }
                    break;
                }
                else if(amid==ar){
                    result[i]=findSecMin(a[amid],b[bmid],a[al],b[br]);
                   break;
                }
                if(a[amid]==b[bmid]){
                    result[i]=a[amid];
                    break;
                }
                else if(a[amid]<b[bmid]){
                    al=amid;br=bmid;
                }
                else {
                    ar=amid;bl=bmid;
                }
            }
        }
        for (int i=0;i<T;i++){
            System.out.println(result[i]);
        }
    }
    public static long findSecMin(long a1,long a2,long a3,long a4){
        long min=a1+a2+a3+a4;
        int i=1;
        if(a1<min){
            min=a1;i=1;
        }
        if (a2<min){
            min=a2;i=2;
        }
        if(a3<min){
            min=a3;i=3;
        }
        if(a4<min){
            i=4;
        }
        long min2=a1+a2+a3+a4;
        if(a1<min2&&i!=1){
            min2=a1;
        }
        if(a2<min2&&i!=2){
            min2=a2;
        }
        if(a3<min2&&i!=3){
            min2=a3;
        }
        if(a4<min2&&i!=4){
            min2=a4;
        }
        return min2;
    }
}
