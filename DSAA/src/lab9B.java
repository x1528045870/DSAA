import java.io.*;
import java.util.*;

/**
 * BFS
 */
class grid{
    int line;
    int column;
    int length=0;
    boolean isVisited=false;
    public grid(int line,int column){
        this.line=line;
        this.column=column;
    }
}
public class lab9B {
    static grid[][] chessBoard;
    static int[][][][] edges;
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        //建个棋盘
        chessBoard=new grid[9][9];
        for(int i=1;i<=8;i++){
            for(int j=1;j<=8;j++){
                grid x=new grid(i,j);
                chessBoard[i][j]=x;
            }
        }
        edges=new int[9][9][9][9];
        //建大图的edges
        for(int i=1;i<=8;i++){
            for(int j=1;j<=8;j++){
                for(int k=1;k<=8;k++){
                    for(int l=1;l<=8;l++){
                        if((k==i+2||k==i-2)&&(l==j+1||l==j-1)){
                            edges[i][j][k][l]=1;
                        }else if((k==i+1||k==i-1)&&(l==j+2||l==j-2)){
                            edges[i][j][k][l]=1;
                        }
                    }
                }
            }
        }
        int t=in.nextInt();
        int startI;int startJ;
        int endI;int endJ;
        for(int i=0;i<t;i++){
            String a=in.next();
            String b=in.next();
            startI=a.charAt(0)-96;
            startJ=a.charAt(1)-48;
            endI=b.charAt(0)-96;
            endJ=b.charAt(1)-48;
            int length=BFSFindLength(startI,startJ,endI,endJ);
            reset();
            out.println(length);
        }
        out.close();
    }

    /**
     *BFS之后看看改出一个接口
     */
    public static int BFSFindLength(int startI,int startJ,int endI,int endJ){
        Queue<grid> queue=new LinkedList<>();
        int i=startI;
        int j=startJ;
        queue.add(chessBoard[i][j]);
        chessBoard[i][j].isVisited=true;
        while((i!=endI||j!=endJ)&&!queue.isEmpty()){
            grid x=queue.poll();
            i= x.line;j= x.column;
            for(int k=1;k<=8;k++){
                for(int l=1;l<=8;l++){
                    if(edges[i][j][k][l]==1&&!chessBoard[k][l].isVisited){
                        queue.add(chessBoard[k][l]);
                        chessBoard[k][l].isVisited=true;
                        chessBoard[k][l].length=chessBoard[i][j].length+1;
                    }
                }
            }
        }
        return chessBoard[i][j].length;
    }
    public static void reset(){
        for(int i=1;i<=8;i++){
            for (int j=1;j<=8;j++){
                chessBoard[i][j].isVisited=false;
                chessBoard[i][j].length=0;
            }
        }
    }
}
