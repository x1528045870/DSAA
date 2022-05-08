import java.io.*;
import java.util.*;
public class lab6D {
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        String str=in.nextLine();
        String t=in.nextLine();
        int m = str.length();
        int t1=t.length();
        if(m==t1){
        int x = 0;
        int[] nuum=new int[m];
        int[][] arr = new int[m][26];
        ArrayList<Integer> letters = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int num = str.charAt(i) - 97;
            arr[i][num] = i + 1;
            nuum[i]=num;
            if (!letters.contains(num)) {
                letters.add(num);
            }
        }
        for (int j = 1; j < m; j++) {

            for (int i : letters) {
                if (i==nuum[j]) {
                    arr[j][i]=j+1;
                } else {
                    arr[j][i] = arr[x][i];
                }

            }
            x = arr[x][nuum[j]];
        }
        int place=0;
        int round=0;
        int i=0;
        while(place<m&&round<2){
            int num=t.charAt(i)-97;
            place=arr[place][num];
            if(i==m-1){
                i=0;round++;
            }
            else {
                i++;
            }
        }
        if(place==m){
            out.println("Yes");
        }else {
            out.println("No");
        }
        }else {
            out.println("No");
        }


        out.close();
    }
}
