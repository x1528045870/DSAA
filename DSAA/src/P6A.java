import java.util.Scanner;
public class P6A {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int num=in.nextInt();
        String[]s=new String[num];
        for (int i=0;i<num;i++){
            s[i]=in.next();
        }
        for (int i=0;i<num;i++){
            if(s[i].contains("1")||s[i].contains("2")||s[i].contains("3")||s[i].contains("4")||s[i].contains("5")||s[i].contains("6")
            ||s[i].contains("7")||s[i].contains("8")||s[i].contains("9")){
                System.out.println("no");
            }
            else {
                System.out.println("yes");
            }
        }


    }
}
