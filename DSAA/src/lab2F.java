import java.util.Scanner;
public class lab2F {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int T=in.nextInt();
        int[] N=new int[T];
        long[] M=new long[T];
        for(int i=0;i<T;i++){
            N[i]=in.nextInt();
            M[i]=in.nextLong();
        }
        long paiMing;long paiMing2;
        for(int k=0;k<T;k++){
            long min=findMin(N[k]);
            long max=findMax(N[k]);
            while (min<=max){
                long mid=min+(max-min)/2;
                paiMing=num(mid,N[k]);
                paiMing2=num2(mid,N[k]);
                if(M[k]>=paiMing&&M[k]<=paiMing2){
                    if(exist(mid,N[k])){
                        System.out.println(mid);break;
                    }
                    else{
                        System.out.println(bigger(mid,N[k]));break;
                    }
                }
                else if(M[k]<paiMing){
                    max=mid-1;
                }
                else {
                    min=mid+1;
                }
            }


        }


    }
   public static boolean exist(long x,int N){
       boolean exist=false;
       for(long j=1;j<=N;j++){
           long l=1;long r=N;
           while (l<=r){
               long mid=l+(r-l)/2;
               long x2=mid*mid+12345*mid+j*j-j*12345+mid*j;
               if(x2==x){
                   exist=true;break;
               }
               if(x2<x){
                   l=mid+1;
               }
               else {
                   r=mid-1;
               }
           }
           if(exist){
               break;
           }
       }
       return exist;
   }
   //求出这个点的排名
    public static long num(long x,int N){
        long num=0;
        for(long j=1;j<=N;j++){
            long l=1;long r=N;
            while (l<=r){
                long mid=l+(r-l)/2;
                long x2=mid*mid+12345*mid+j*j-j*12345+mid*j;
                if(x2<x){
                    l=mid+1;
                }
                else {
                    r=mid-1;
                }
            }
            if(r>0){
                num+=r;}
        }
        return num+1;
    }
    public static long num2(long x,int N){
        long num=0;
        for(long j=1;j<=N;j++){
            long l=1;long r=N;
            while (l<=r){
                long mid=l+(r-l)/2;
                long x2=mid*mid+12345*mid+j*j-j*12345+mid*j;
                if(x2<=x){
                    l=mid+1;
                }
                else {
                    r=mid-1;
                }
            }
                num+=l-1;}

        return num;
    }
    public static long bigger(long x,int N){
        long min=findMax(N);
        for(long j=1;j<=N;j++){
            long l=1;long r=N;
            while (l<=r){
                long mid=l+(r-l)/2;
                long x2=mid*mid+12345*mid+j*j-j*12345+mid*j;
                if(x2<=x){
                    l=mid+1;
                }
                else {
                    if(min>x2){
                        min=x2;
                    }
                    r=mid-1;
                }
            }
        }
        return min;
    }
    //最小的只存在于i最小的某种情况
    public static long findMin(int N){
        long min=1+12345+1-12345+1;
        for(int j=2;j<=N;j++){
            long t=1+12345+ (long) j *j- 12345L *j+j;
            if(t<min){
                min=t;
            }
        }
        return min;
    }
    //最大的只存在于i最大的某种情况
    public static long findMax(int N){
        long max= (long) N *N+ 12345L *N+1-12345+N;
        for(int j=2;j<=N;j++){
            long t= (long) N *N+ 12345L *N+ (long) j *j- 12345L *j+ (long) j *N;
            if(t>max){
                max=t;
            }
        }
        return max;
    }
}
