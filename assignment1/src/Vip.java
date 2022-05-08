import java.util.Scanner;
public class Vip {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        int time = input.nextInt();
        int i=0;
        int amount;int whole=0;int max =0;
        while (i<time) {
            i = i + 1;
            amount = input.nextInt();
            whole = whole + amount;
            if (amount > max) {
                max = amount;
            }
            }
            if(max>=5000||(whole>=3000&&i>=10)){
                System.out.println("Diamond");
            }
            else if(max>=3000||(whole>=2000&&i>=5)){
                System.out.println("Gold");
            }
            else if(max>=1500||(whole>=1000&&i>=3)){
                System.out.println("Silver");
            }
            else{
                System.out.println("Ordinary");
            }

        input.close();

    }
}
