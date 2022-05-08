import java.util.Scanner;
public class Eat {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
       int beginh=input.nextInt();
       int beginm=input.nextInt();
       int begins=input.nextInt();
       int endh=input.nextInt();
       int endm=input.nextInt();
       int ends=input.nextInt();
       int s;
       if (ends-begins<0){
            s=ends-begins+60;
           endm = endm-1;
       }
       else {
            s= ends-begins;
       }
       int m =(endh-beginh)*60+endm-beginm;
       if(m==0){
           System.out.println(s+"s");
       }
       else if (s==0){
           System.out.println(m + "m");
       }
       else{
            System.out.println(m + "m" + s + "s");
        }

    }
}
