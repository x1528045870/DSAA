package lab5;
import java.util.Scanner;
public class ex3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] high = new int[n];
        int  w=0,h1 = 0, h2 = 0, left = 0;
        for(int i=0;i<n;i++){
            high[i] = input.nextInt();
        }
        for (int i = 1; i < n; i++) {
            if(high[i]>high[i-1]&&high[i]>high[i+1]&&left==0||i==1&&high[i]>high[i-1]){
                left=1;h1=i;h2=high[i];
            }
            else if(high[i]>high[i-1]&&high[i]>high[i+1]&&left==1||high[i]>high[i-1]&&i==n-1){
                if(h2>high[i]) {
                    for (int b = h1 + 1; b < i; b++) {
                        w = w + high[i] - high[b];
                    }
                }
                else{
                    for(int b=h1+1;b<i;b++){
                                w=w+h2-high[b];
                            }
                    }
                h1=i;h2=high[i];
            }
            }
        System.out.println(w);

        }
    }
