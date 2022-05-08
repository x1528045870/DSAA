import java.util.Scanner;
public class P2A {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n1=in.nextInt();
        String B[]=new String[n1];
        for (int i=0;i<n1;i++){
            int a=in.nextInt();
            double b=0;
            int c=1;
            while (b<=a){
                b=b+Math.pow(3,c);
                c++;
            }
            c--;
            b=b-Math.pow(3,c);
            a=a-(int)b-1;
            double out=0;
            String result="";
            while (c>0){
                b=a%3;
                if(b==0){
                    result=2+result;
                }
                else if (b==1){
                    result=3+result;
                }
                else {
                    result=6+result;
                }
                a=a/3;
                c--;
            }
           B[i]=result;
        }
        for (String output:B){
            System.out.println(output);
        }

    }


}
