import java.util.Scanner;
public class Cost {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
         int type= input.nextInt();
         String vip=input.next();
         float whole;float price;int t;
         whole=0f;
         float discount;
         for(int i=0;i<type;i++){
             price= input.nextFloat();
             t=input.nextInt();
             whole=whole+price*t;
         }
         if (vip.equals("Diamond")){
             discount=0.7f;
         }
         else if(vip.equals("Gold")){
             discount=0.8f;
         }
         else if(vip.equals("Silver")){
             discount=0.9f;
         }
         else{
             discount=1f;
         }
         whole=whole*discount;
          System.out.printf("%.1f\n",whole);
    }
}
