import java.util.Scanner;
public class a2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[] l1 = new int[m];
        int[] l2 = new int[n];
        int c=0;int h=0;
        for(int a=0;a<m;a++){
            l1[a]=in.nextInt();
        }
        for (int a = 0; a <n; a++ ){
            l2[a]=in.nextInt();
        }
        for (int a = 0; a < m; a++ ){
            for(int i=h;i<n;i++){
                if(l1[a]==l2[i]){
                    h=i+1;
                    c=c+1;
                    break;
                }
            }
        }
        if(c==m){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }
}
