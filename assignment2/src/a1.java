import java.util.Scanner;
public class a1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int t;
        int c ;
        int a=n;
        int b=m;
        while (a%b!=0){
            if(a<b){
                t=a;a=b;b=t;
            }
            c=a%b;
            a=b;b=c;
        }
        n=n/b;
        m=m/b;
        System.out.println(n+" "+m);
    }
}
