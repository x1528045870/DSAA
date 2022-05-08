package lab5;
import java.util.Scanner;
public class ex1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Float[] score = new Float[10];
        Float t=0f;
        Float b=100f;
        Float total=0f;
        for (int i = 0; i < 10; i++) {
            score[i]=in.nextFloat();
            if (score[i]<b){
                b=score[i];
            }
             if(score[i]>t){
                t=score[i];
            }


        }for(Float num:score){
            total+=num;
        }total=total-t-b;
        Float average=total/8;
        System.out.printf("%.2f\n",average);
    }
}
