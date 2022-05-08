import java.io.*;
import java.util.*;
class City{
    int nu;
    ArrayList<City> neighbor=new ArrayList<>();
    boolean isVisited=false;
    boolean  isGou=false;
    int depth=0;
    public City(int nu){
        this.nu=nu;
    }
}
public class lab7F {
    static City[] cities;
    static int max;
    static int balabala;
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        int T=in.nextInt();
        for (int i=0;i<T;i++){
            int n=in.nextInt();
            int k=in.nextInt();
             cities=new City[n+1];
            for (int j=1;j<n+1;j++){
                City c=new City(j);
                cities[j]=c;
            }
            for(int j=1;j<n;j++){
                int u=in.nextInt();
                int v=in.nextInt();
                cities[u].neighbor.add(cities[v]);
                cities[v].neighbor.add(cities[u]);
            }
            int[] place=new int[k];
            for(int j=0;j<k;j++){
                int x=in.nextInt();
                cities[x].isGou=true;
                place[j]=x;
            }
                 max=0;
            //bfs(place[0]);
            findLength(place[0],place[0],0);
            reSet(n);
            if(k>=2){
            //bfs(balabala);
                findLength(balabala,balabala,0);
                }
            out.println((max+1)/2);
        }
        out.close();
    }
    public static void reSet(int n){
        for(int i=1;i<=n;i++){
            cities[i].isVisited=false;
            cities[i].depth=0;
        }
    }
    public static void findLength(int firstPlace,int place,int length){
        cities[place].isVisited=true;
        if(place!=firstPlace&&cities[place].isGou){
            if(length>max){
                max=length;balabala=cities[place].nu;
            }
        }
        else {
            for(City city:cities[place].neighbor){
                if(!city.isVisited){
            findLength(firstPlace,city.nu,length+1);}
        }
        }
    }

    public static void bfs(int place){
        Queue<City> step=new LinkedList<>();
        step.add(cities[place]);
        cities[place].isVisited=true;
        while (!step.isEmpty()){
            City palace=step.poll();
            for(City city:palace.neighbor){
                if(city!=null){
                if(!city.isVisited){
                    city.depth=palace.depth+1;
                    step.add(city);
                    city.isVisited=true;
                }
                if(city.isGou&&city.nu!=place){
                    if(city.depth>max){
                        max=city.depth;
                        balabala=city.nu;
                    }
                }

            }}
        }
    }
}
