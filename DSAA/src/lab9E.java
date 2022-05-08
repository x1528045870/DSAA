import java.io.*;
import java.util.*;

/**
 * 这儿也有BFS
 */
class cities{
    ArrayList<cities> next=new ArrayList<>();
    int level=0;
    int place;
    boolean isVisited=false;
    public cities(int place){
        this.place=place;
    }
}
public class lab9E {
    static cities[] cities;
    static int n;
    static int m;
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
         n=in.nextInt();
         m=in.nextInt();
        cities=new cities[n+1];
        for(int i=1;i<=n;i++){
            cities x=new cities(i);
            cities[i]=x;
        }
        for(int k=0;k<m;k++){
            int u=in.nextInt();
            int v=in.nextInt();
            int w=in.nextInt();
            if(w==2){
                cities x=new cities(v);
                cities[u].next.add(x);
                x.next.add(cities[v]);
            }else {
            cities[u].next.add(cities[v]);}
        }
        out.println(BFSFindLength(1,n));
        out.close();
    }

    /**
     * BFS
     */
    public static int BFSFindLength(int start,int end){
        Queue<cities> queue=new LinkedList<>();
        queue.add(cities[start]);
        cities[start].isVisited=true;
        int i=start;
        while(i!=end&&!queue.isEmpty()){
            cities x=queue.poll();
            i=x.place;
            for (cities child:x.next){
                if(!child.isVisited){
                    queue.add(child);
                    child.isVisited=true;
                    child.level=x.level+1;
                }
            }
        }
        if(i!=end){
            return -1;
        }
        return cities[end].level;
    }
}
