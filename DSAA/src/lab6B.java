import java.util.ArrayList;
import java.util.*;
import java.io.*;

public class lab6B {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out=new QWriter();
        String str = in.nextLine();
        int m = str.length();
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
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 26; j++) {
                out.print(arr[i][j] + " ");
            }
            out.println("");
        }
        out.close();
    }
}
