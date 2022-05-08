import java.util.Scanner;
public class Try {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int type= input.nextInt();
        String vip=input.next();
        double whole;double price;double t;
        whole=0;
        double discount;
        for(int i=0;i<type;i++){
            price= input.nextDouble();
            t=input.nextDouble();
            whole=whole+price*t;
        }
        switch(vip){
            case "Diamond":
                discount=0.7;
                break;
            case "Gold":
                discount=0.8;
                break;
            case "Silver":
                discount=0.9;
                break;
            default:
                discount=1;

        }
        whole=whole*discount;

        System.out.printf("%.1f\n",whole);
    }
}