import java.util.Scanner;
public class map {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        Integer p=input.nextInt();
        Integer p2=input.nextInt();
        String di= input.next();
        char re= di.charAt(0);
        while (re !='E'){
            if (re =='a') {
                p=p-1;
            }
            else if (re=='d'){
                p=p+1;
                }
            else if(re=='w'){
                p2=p2 +1;
            }
            else if(re=='s'){
                p2=p2-1;
            }
            di=input.next();
            re=di.charAt(0);
        }

        System.out.println(p+" "+p2);
        input.close();


    }
}
