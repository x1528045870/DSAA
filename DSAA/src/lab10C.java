import java.io.*;
import java.util.*;

/**
 * prim法求最小生成树
 * undirected weighted Graphs
 */
class Uwg{
    ArrayList<Uwg>neighbor=new ArrayList<>();
    HashMap<Integer, Long> weight = new HashMap<>();
    int before=-1;
    int place;
    int num;
    long dist=Long.MAX_VALUE;
    boolean isVisited=false;
    public Uwg(int num){
        this.num=num;
    }
}
public class lab10C {
    static Uwg[] vertex;
    static Uwg[] heap;
    static long minLength=0;
    static int n;
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        n=in.nextInt();
        int m=in.nextInt();
        vertex=new Uwg[n+1];
        heap=new Uwg[n+1];
        //建点集，建堆
        for (int i=1;i<=n;i++){
            vertex[i]=new Uwg(i);
            heap[i]=vertex[i];
            vertex[i].place=i;
        }
        long minW=Long.MAX_VALUE;
        int minU=0;
        for(int i=0;i<m;i++){
            int u=in.nextInt();
            int v=in.nextInt();
            long w=in.nextLong();
            if (vertex[u].weight.get(v)==null||vertex[u].weight.get(v)>w){
                vertex[u].neighbor.add(vertex[v]);
            vertex[u].weight.put(v,w);}
            if (vertex[v].weight.get(u)==null||vertex[v].weight.get(u)>w){
            vertex[v].neighbor.add(vertex[u]);
            vertex[v].weight.put(u,w);}
            if(w<minW){
                minW=w;
                minU=u;
            }
        }
        toPrim(minU,n);
        out.println(minLength);
        out.close();
    }

    /**
     *生成最小生成树
     */
    static void toPrim(int minU,int num){
        vertex[minU].dist=0;
        up(minU);
        int j=num;
        while(j>0){
            Uwg y=deleteMin(j);
            j--;
            y.isVisited=true;
            if (y.before!=-1){
                minLength+=y.weight.get(y.before);
            }
            for (Uwg x:y.neighbor){
                //选的边比原来短，且不能和已经用过的节点相连
                if(!x.isVisited&&x.dist>y.weight.get(x.num)){
                    x.dist=y.weight.get(x.num);
                    x.before=y.num;
                    up(x.num);
                }
            }
        }
    }
    public static void insert(int num,int end){
        //end是新插入的位置
        heap[end]=vertex[end];
        while(end>1&&heap[end].dist<heap[end/2].dist){
            Uwg t=heap[end];
            heap[end]=heap[end/2];
            heap[end/2]=t;
            heap[end].place=end;
            heap[end/2].place=end/2;
            end=end/2;
        }
    }
    public static void up(int num){
        //end是新插入的位置
        int place=vertex[num].place;
        while(place>1&&heap[place].dist<heap[place/2].dist){
            Uwg t=heap[place];
            heap[place]=heap[place/2];
            heap[place/2]=t;
            heap[place/2].place=place/2;
            heap[place].place=place;
            place=place/2;
        }
    }
    public static Uwg deleteMin(int end){
        Uwg min=heap[1];
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
        Uwg t=heap[min];
        heap[min]=heap[i];
        heap[i]=t;
        heap[i].place=i;
        heap[min].place=min;
        down(min,end);
    }
}
