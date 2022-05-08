import java.util.Scanner;
public class a1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int h=in.nextInt();
        int w=in.nextInt();
        String [][]s=new String[h][w];
        for(int i=0;i<h;i++) {
            for (int f = 0; f < w; f++) {
                s[i][f] = in.next();
            }
        }
        for(int i=0;i<h;i++){
                for(int f=0;f<w;f++){
                    System.out.print(s[i][f]+" ");
                }
                for(int f=0;f<w;f++){
                    System.out.print(s[i][w-f-1]+" ");
                }
                System.out.println();
    }
        for(int i=0;i<h;i++){
            for(int f=0;f<w;f++){
                System.out.print(s[h-i-1][f]+" ");
            }
            for(int f=0;f<w;f++){
                System.out.print(s[h-i-1][w-f-1]+" ");
            }
            System.out.println();
        }
}}
