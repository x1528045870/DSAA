package lab6;

public class digui {
    public static int di(int n){
        int a=0;int b=1;
        for(int i=2;i<=n;i++){
            int t=b;
            b=a+b;
            a=t;
        }
        return b;
    }
}
