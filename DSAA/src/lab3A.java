import java.io.*;
import java.util.*;

class lab3A {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int num= in.nextInt();
        int[] outNum=new int[num];
        long[] outPairs=new long[num];
        for (int i=0;i<num;i++){
            int n=in.nextInt();
            int m=in.nextInt();
            long[] a=new long[n];
            long[] b=new long[m];
            for(int j=0;j<n;j++){
                  a[j]=in.nextLong();
            }
            for (int j=0;j<m;j++){
                b[j]=in.nextLong();
            }
            long[] c=new long[n+m];
            int k=0;int j=0;int l=0;long nuum=0;
            while(k<n&&j<m){
                if(a[k]<=b[j]){
                    c[l]=a[k];
                    l++;k++;
                }
                else{
                    nuum+=n-k;
                    c[l]=b[j];
                    l++;j++;
                }
            }
            if(k==n){
                for(int y=l;y<n+m;y++){
                    c[y]=b[j];
                    j++;
                }
            }
            else if(j==m){
                for(int y=l;y<n+m;y++){
                    c[y]=a[k];
                    k++;
                }
            }
            out.println(nuum);
            for(int z=0;z<n+m;z++){
                out.print(c[z]+" ");
            }
            out.println("");
        }
        out.close();
    }
}
















class QReader {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer tokenizer = new StringTokenizer("");

    private String innerNextLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    public boolean hasNext() {
        while (!tokenizer.hasMoreTokens()) {
            String nextLine = innerNextLine();
            if (nextLine == null) {
                return false;
            }
            tokenizer = new StringTokenizer(nextLine);
        }
        return true;
    }

    public String nextLine() {
        tokenizer = new StringTokenizer("");
        return innerNextLine();
    }

    public String next() {
        hasNext();
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }
}

class QWriter implements Closeable {
    private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public void print(Object object) {
        try {
            writer.write(object.toString());
        } catch (IOException e) {
            return;
        }
    }

    public void println(Object object) {
        try {
            writer.write(object.toString());
            writer.write("\n");
        } catch (IOException e) {
            return;
        }
    }

    @Override
    public void close() {
        try {
            writer.close();
        } catch (IOException e) {
            return;
        }
    }
}
