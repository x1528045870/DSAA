import java.io.*;
import java.util.*;

/**
 * prim法求最小生成树
 * undirected weighted Graphs
 */
class Point{
    ArrayList<Point>neighbor=new ArrayList<>();
    HashMap<Integer, Long> weight = new HashMap<>();
    Point before=null;
    int place;
    int num;
    int numX;
    int numY;
    int pointWeight=Integer.MAX_VALUE;
    long dist=Long.MAX_VALUE;
    boolean isVisited=false;
    public Point(int numX,int numY,int num){
        this.numX=numX;
        this.numY=numY;
        this.num=num;
    }
}
public class lab10D {
    static Point[][] vertex;
    static Point[] heap;
    static long minLength=0;
    static int n;
    static long minW=Long.MAX_VALUE;
    static Point minU;
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        n=in.nextInt();
        vertex=new Point[2*n+1+2][2*n+1+2];
        heap=new Point[3*n*n+3*n+2];
        int k=0;
        //建点集，建堆
        for (int i=0;i<2*n+3;i++){
            for(int j=0;j<2*n+3;j++) {
                vertex[i][j] = new Point(i,j,k);
                k++;
            }
        }
        //读入每个点的重量
        int x;
        k=1;
        for(int i=1;i<=2*n+1;i++){
            if(i<=n+1){
                for(int j=1;j<=n+i;j++){
                    x=in.nextInt();
                    vertex[i][j].pointWeight=x;
                    heap[k]=vertex[i][j];
                    heap[k].place=k;
                    k++;
                }
            }else {
                for(int j=-n+i;j<=2*n+1;j++){
                    x=in.nextInt();
                    vertex[i][j].pointWeight=x;
                    heap[k]=vertex[i][j];
                    heap[k].place=k;
                    k++;
                }
            }
        }
        k--;
        for(int i=1;i<=2*n+1;i++){
            if(i<=n+1){
                for(int j=1;j<=n+i;j++){
                    findNear(i,j);
                }
            }else {
                for(int j=-n+i;j<=2*n+1;j++){
                    findNear(i,j);
                }
            }
        }
        toPrim(minU,k);
        out.println(minLength);
        out.close();
    }

    /**
     *生成最小生成树
     */
    static void findNear(int i,int j){
        int x=vertex[i][j].pointWeight;
        vertex[i][j].neighbor.add(vertex[i-1][j-1]);
        long y=(long)vertex[i-1][j-1].pointWeight*x;
        if(minW>y){
            minW=y;
            minU=vertex[i][j];
        }
        vertex[i][j].weight.put(vertex[i-1][j-1].num,y);
        vertex[i][j].neighbor.add(vertex[i-1][j]);
        y=(long)vertex[i-1][j].pointWeight*x;
        if(minW>y){
            minW=y;
            minU=vertex[i][j];
        }
        vertex[i][j].weight.put(vertex[i-1][j].num,y);
        vertex[i][j].neighbor.add(vertex[i][j-1]);
        y=(long)vertex[i][j-1].pointWeight*x;
        if(minW>y){
            minW=y;
            minU=vertex[i][j];
        }
        vertex[i][j].weight.put(vertex[i][j-1].num,y);
        vertex[i][j].neighbor.add(vertex[i][j+1]);
        y=(long)vertex[i][j+1].pointWeight*x;
        if(minW>y){
            minW=y;
            minU=vertex[i][j];
        }
        vertex[i][j].weight.put(vertex[i][j+1].num,y);
        vertex[i][j].neighbor.add(vertex[i+1][j]);
        y=(long)vertex[i+1][j].pointWeight*x;
        if(minW>y){
            minW=y;
            minU=vertex[i][j];
        }
        vertex[i][j].weight.put(vertex[i+1][j].num,y);
        vertex[i][j].neighbor.add(vertex[i+1][j+1]);
        y=(long)vertex[i+1][j+1].pointWeight*x;
        if(minW>y){
            minW=y;
            minU=vertex[i][j];
        }
        vertex[i][j].weight.put(vertex[i+1][j+1].num,y);
    }
    static void toPrim(Point minU,int num){
        minU.dist=0;
        up(minU);
        int j=num;
        while(j>0){
            Point y=deleteMin(j);
            j--;
            y.isVisited=true;
            if (y.before!=null){
                minLength+=y.weight.get(y.before.num);
            }
            for (Point x:y.neighbor){
                //选的边比原来短，且不能和已经用过的节点相连
                if(!x.isVisited&&x.dist>y.weight.get(x.num)){
                    x.dist=y.weight.get(x.num);
                    x.before=y;
                    up(x);
                }
            }
        }
    }
    public static void up(Point num){
        //end是新插入的位置
        int place=num.place;
        while(place>1&&heap[place].dist<heap[place/2].dist){
            Point t=heap[place];
            heap[place]=heap[place/2];
            heap[place/2]=t;
            heap[place/2].place=place/2;
            heap[place].place=place;
            place=place/2;
        }
    }
    public static Point deleteMin(int end){
        Point min=heap[1];
        heap[1]=heap[end];
        heap[1].place=1;
        heap[end]=null;
        down(1,end);
        return min;
    }
    public static void down(int i,int end){
        int left=2*i;
        int right=2*i+1;
        int min=i;
        if(left<end&&heap[left].dist<heap[min].dist){
            min=left;
        }
        if(right<end&&heap[right].dist<heap[min].dist){
            min=right;
        }
        if(min==i){
            return;
        }
        Point t=heap[min];
        heap[min]=heap[i];
        heap[i]=t;
        heap[i].place=i;
        heap[min].place=min;
        down(min,end);
    }
}
