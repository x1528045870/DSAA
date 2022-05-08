import java.io.*;
import java.util.*;

/**迪杰斯特拉有向正权图最短路径。1-n，
 * 优先队列方式优化了
 */
class Travel{
    ArrayList<Travel>neighbor=new ArrayList<>();
    HashMap<Integer, Long> weight = new HashMap<>();
    int before=-1;
    int place;
    int num;
    long dist=Long.MAX_VALUE;
    boolean isVisited=false;
    public Travel(int num){
        this.num=num;
    }
}
public class lab10A {
    static Travel[] vertex;
    static Travel[] heap;
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        int n=in.nextInt();
        int m=in.nextInt();
        vertex=new Travel[n+1];
        heap=new Travel[n+1];
        //点的初值
        for(int i=1;i<=n;i++){
            Travel x=new Travel(i);
            vertex[i]=x;
        }
        for(int k=1;k<=m;k++){
            int u=in.nextInt();
            int v=in.nextInt();
            long w=in.nextLong();
            vertex[u].neighbor.add(vertex[v]);
            vertex[u].weight.put(v,w);
        }
        //建个优先队列，先放进去
        for(int i=1;i<=n;i++){
            heap[i]=vertex[i];
            vertex[i].place=i;
        }
        //迪杰斯特拉计算每个点到1的最短路径
        dijkstra(1,n,n);
        if(vertex[n].before==-1){
            out.println(-1);
        }else {
        out.println(vertex[n].dist);}
        out.close();
    }
    /**
     * Dijkstra
     */
    static void dijkstra(int start,int end,int num){
        vertex[start].dist=0;
        up(start);
        int j=num;
        while (j>0){
            Travel y=deleteMin(j);
            j--;
            if(y.num==end){
                return;
            }
            y.isVisited=true;
            for (Travel x:y.neighbor){
                if(x.dist>y.dist+y.weight.get(x.num)){
                    x.dist=y.dist+y.weight.get(x.num);
                    x.before=y.num;
                    up(x.num);
                }
            }
        }
    }
    /**
     * x先写一个优先队列吧（小顶堆）
     */
    public static void insert(int num,int end){
        //end是新插入的位置
        heap[end]=vertex[end];
        while(end>1&&heap[end].dist<heap[end/2].dist){
            Travel t=heap[end];
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
            Travel t=heap[place];
            heap[place]=heap[place/2];
            heap[place/2]=t;
            heap[place/2].place=place/2;
            heap[place].place=place;
            place=place/2;
        }
    }
    public static Travel deleteMin(int end){
        Travel min=heap[1];
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
        Travel t=heap[min];
        heap[min]=heap[i];
        heap[i]=t;
        heap[i].place=i;
        heap[min].place=min;
        down(min,end);
    }
}
