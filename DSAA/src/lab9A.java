import java.io.*;
import java.util.*;
public class lab9A {
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        int T=in.nextInt();
        for(int t=0;t<T;t++){
            int n=in.nextInt();
            int m=in.nextInt();
            int[][] road=new int[n][n];
            for(int k=0;k<m;k++){
                int i=in.nextInt();
                int j=in.nextInt();
                road[i-1][j-1]+=1;
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    out.print(road[i][j]+" ");
                }
                out.println("");
            }
        }
        out.close();
    }
}
