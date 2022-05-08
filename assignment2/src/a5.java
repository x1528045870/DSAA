import java.util.Scanner;
public class a5 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int []f=new int[n];
        int max=0;int l=1;int right=0;
        for(int i=0;i<n;i++){
            f[i]=input.nextInt();
        }
        for(int i=0;i<n-1;i++){
            if (f[i]<=f[i+1]){
                l=l+1;
                if(l>=max){
                    max=l;right=i+1;
                }
            }
            if(f[i]>f[i+1]){
                l=1;
            }
        }
        for(int i=right-max+1;i<=right;i++){
            System.out.print(f[i]+" ");
        }
    }
}
