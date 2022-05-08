package lab6;
import java.util.Scanner;
public class chessboard {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int row=in.nextInt();
        int column=in.nextInt();
        int [][]board=new int[row][column];
        int d=0;
        for(int i=0;i<row;i++){
            for(int n=0;n<column;n++){
                board[i][n]=in.nextInt();
            }
        }
        for(int i=1;i<row-1;i++){
            for(int n=1;n<column-1;n++){
                if(check(board,i,n)){
                  d=d+1;
                }
            }
        }
        System.out.println(d);
    }
    public static boolean check(int[][]board,int row,int column){
        boolean check=false;
        if(board[row][column]==0&&board[row][column-1]==1
        &&board[row-1][column]==1
        &&board[row+1][column]==1
        &&board[row][column+1]==1){
            check=true;
        }
        return check;
    }
}
