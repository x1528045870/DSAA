import java.util.Scanner;
public class a3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        char [][]chessBoard=new char[n+2][n+2];
        for(int r=1;r<n+1;r++){
            String v=in.next();
            for(int c=1;c<n+1;c++){
                chessBoard[r][c]=v.charAt(c-1);
            }
        }
        for(int r=1;r<n+1;r++){
            for(int c=1;c<n+1;c++){
                if(chessBoard[r][c]=='*'){
                    chessBoard[r][c]='F';
                }
            }
        }
        for(int r=1;r<n+1;r++){
            for(int c=1;c<n+1;c++){
                if(chessBoard[r][c]!='F'){
                    chessBoard[r][c]=check(r,c,chessBoard);
                }
            }}
        for(int r=1;r<n+1;r++){
            for(int c=1;c<n+1;c++){
                System.out.print(chessBoard[r][c]);
            }System.out.println();
        }
    }
    public static char check(int r,int c,char [][]chessBoard){
        int num =0;
                    if(chessBoard[r-1][c]=='F'){
                        num=num+1;
                    }
                    if(chessBoard[r+1][c]=='F'){
                        num=num+1;
                    }
            if(chessBoard[r][c-1]=='F'){
                num=num+1;
            }
            if(chessBoard[r][c+1]=='F'){
                num=num+1;
            }
            if(chessBoard[r-1][c-1]=='F'){
                num=num+1;
            }
            if(chessBoard[r-1][c+1]=='F'){
                num=num+1;
            }
            if(chessBoard[r+1][c-1]=='F'){
                num=num+1;
            }
            if(chessBoard[r+1][c+1]=='F'){
                num=num+1;
            }
        return String.valueOf(num).charAt(0);
    }
}
