import java.util.Scanner;
public class a2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        char[][]chessBoard=new char[n][n];
        int[]ii=new int[n*n];//记录行
        int[]yy=new int[n*n];//记录列
        int cplace=-1;//作为判断和记录位置使用
        int t=0;int p;int b;
        for(int i=0;i<n;i++){
            for(int y=0;y<n;y++){
                chessBoard[i][y]=in.next().charAt(0);
                }
            }
        //以上为录入棋局
        //以下为判断列
        for(int i=0;i<n-4;i++){
            for(int y=0;y<n;y++){
                if(chessBoard[i][y]=='O'){
                    cplace=checkColumn(i,y,n,chessBoard);//判断这个开始下面四个有没有三个O和一个空位或4个O
                    if(cplace!=-1){//如果下面有三个0和一个空位，就。
                        ii[t]=cplace+1;yy[t]=y+1;cplace=-1;t=t+1;
                    }
                }
                if(chessBoard[i][y]=='N'&&chessBoard[i+1][y]=='O'){//判断
                    cplace=checkColumn(i,y,n,chessBoard);
                    if(cplace==i){
                        ii[t]=i+1;yy[t]=y+1;t=t+1;cplace=-1;
                    }
                }
            }
        }
        //以下为判断行
        for(int y=0;y<n-4;y++){
            for(int i=0;i<n;i++){
                if(chessBoard[i][y]=='O'){
                    cplace=checkLine(i,y,n,chessBoard);//判断这个开始后面四个有没有三个O和一个空位或4个O
                    if(cplace!=-1){//如果后面有三个0和一个空位，就。
                        ii[t]=i+1;yy[t]=cplace+1;cplace=-1;t=t+1;
                    }
                }
                if(chessBoard[i][y]=='N'&&chessBoard[i][y+1]=='O'){//判断
                    cplace=checkLine(i,y,n,chessBoard);
                    if(cplace==y){
                        ii[t]=i+1;yy[t]=y+1;t=t+1;cplace=-1;
                    }
                }
            }
        }
        //以下为判断斜着
        for(int i=0;i<n-4;i++){
            for(int y=0;y<n-4;y++){
                if(chessBoard[i][y]=='O'){
                    cplace=checkSlant(i,y,n,chessBoard);//判断这个开始斜着四个有没有三个O和一个空位或4个O
                    if(cplace!=-1){//如果斜着有三个0和一个空位，就。
                        ii[t]=cplace+1;yy[t]=cplace-i+y+1;cplace=-1;t=t+1;
                    }
                }
                if(chessBoard[i][y]=='N'&&chessBoard[i+1][y+1]=='O'){//判断
                    cplace=checkSlant(i,y,n,chessBoard);
                    if(cplace==i){
                        ii[t]=i+1;yy[t]=y+1;t=t+1;cplace=-1;
                    }
                }
            }
        }
        //判断右斜
        for(int i=0;i<n-4;i++){
            for(int y=n-1;y>3;y--){
                if(chessBoard[i][y]=='O'){
                    cplace=checkLslant(i,y,n,chessBoard);//判断这个开始斜着四个有没有三个O和一个空位或4个O
                    if(cplace!=-1){//如果斜着有三个0和一个空位，就。
                        ii[t]=cplace+1;yy[t]=y-cplace+i+1;cplace=-1;t=t+1;
                    }
                }
                if(chessBoard[i][y]=='N'&&chessBoard[i+1][y-1]=='O'){//判断
                    cplace=checkLslant(i,y,n,chessBoard);
                    if(cplace==i){
                        ii[t]=i+1;yy[t]=y+1;t=t+1;cplace=-1;
                    }
                }
            }
        }
        //换顺序
        for(int j=0;j<=t-1;j++){
        for(int i=t-1;i>=j+1;i--){
            if(ii[i]<ii[i-1]){
               p=ii[i];ii[i]=ii[i-1];ii[i-1]=p;
               p=yy[i];yy[i]=yy[i-1];yy[i-1]=p;
            }
            if(ii[i]==ii[i-1]&&yy[i]<yy[i-1]){
                p=yy[i];yy[i]=yy[i-1];yy[i-1]=p;
                p=ii[i];ii[i]=ii[i-1];ii[i-1]=p;
            }
        }}
        //去重
        for(int j=0;j<=t-1;j++){
            for(int i=t-1;i>=j+1;i--){
                if(ii[i]==ii[i-1]&&yy[i]==yy[i-1]){
                    for(int y=i;y<=t-1;y++){
                    yy[y]=yy[y+1];ii[y]=ii[y+1];
                }}
            }}
        for(int i=0;yy[i]>0;i++){
            System.out.println("("+yy[i]+","+ii[i]+")");
        }
        if(t==0){
            System.out.println("No");
        }
    }

    public static  int checkLine(int i,int y,int n,char [][]chessBoard){
        int place =-1;
        int cplace=y;
        int t=0;
        int no=0;
        for(int z=y+1;z<y+5;z++){
            if(chessBoard[i][z]=='O') {
                t = t + 1;
            }
            if(chessBoard[i][z]=='N'){
                cplace=z;
            }
        }
        if(t==3&&cplace>y||t==4){
         place=cplace;
        }
        return place;
    }
    public static  int checkColumn(int i,int y,int n,char [][]chessBoard){
        int place =-1;
        int cplace=i;
        int t=0;
        for(int z=i+1;z<i+5;z++){
            if(chessBoard[z][y]=='O') {
                t = t + 1;
            }
            if(chessBoard[z][y]=='N'){
                cplace=z;
            }
        }
        if(t==3&&cplace>i||t==4){
            place=cplace;
        }
        return place;
    }
    public static  int checkSlant(int i,int y,int n,char [][]chessBoard){
        int place =-1;
        int cplace=i;
        int t=0;
        for(int z=i+1;z<i+5;z++){
            y=y+1;
            if(chessBoard[z][y]=='O') {
                t = t + 1;
            }
            if(chessBoard[z][y]=='N'){
                cplace=z;
            }
        }
        if(t==3&&cplace>i||t==4){
            place=cplace;
        }
        return place;
    }
    public static  int checkLslant(int i,int y,int n,char [][]chessBoard){
        int place =-1;
        int cplace=i;
        int t=0;
        for(int z=i+1;z<i+5;z++){
            y=y-1;
            if(chessBoard[z][y]=='O') {
                t = t + 1;
            }
            if(chessBoard[z][y]=='N'){
                cplace=z;
            }
        }
        if(t==3&&cplace>i||t==4){
            place=cplace;
        }
        return place;
    }
}
