
import java.io.*;
public class EmptyChessBoardWriter {
    public static void main(String[] args) throws IOException {
        BufferedReader inputReader=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter chessBoardWriter=new BufferedWriter(new FileWriter("test.txt"));
        int n=Integer.parseInt(inputReader.readLine());
        chessBoardWriter.write(Integer.toString(n));
        chessBoardWriter.write(System.lineSeparator());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chessBoardWriter.write("N");
                if(j!=n-1){
                    chessBoardWriter.write(" ");
                }
            }
            if(i!=n-1){
                chessBoardWriter.write(System.lineSeparator());
            }

        }

        inputReader.close();
        chessBoardWriter.flush();
        chessBoardWriter.close();
    }
}
