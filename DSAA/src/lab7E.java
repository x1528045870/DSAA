import java.util.*;
class Host{
    int nu;
    ArrayList<Host> children=new ArrayList<>();
    Host father;
    boolean isVisited=false;
    boolean isLeave=true;
    int depth=0;
    public Host(int nu){
        this.nu=nu;
    }
}
public class lab7E {
    static Host[] nodes;
    static int length;
    static ArrayList<Integer> path;
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        int n=in.nextInt();
        boolean ttrue=true;
        nodes=new Host[n+1];
        for(int i=1;i<=n;i++){
            Host bala=new Host(i);
            nodes[i]=bala;
        }
        for(int i=1;i<n;i++){
            int u=in.nextInt();
            int v=in.nextInt();
            nodes[u].children.add(nodes[v]);
            nodes[v].children.add(nodes[u]);
            nodes[u].isLeave=false;
        }
        int y=0;
        for(int i=1;i<=n;i++){
            if(nodes[i].isLeave){
                y++;
            }
        }
        int[] inn=new int[y+2];
        inn[0]=1;
        inn[y+1]=1;
        for (int i=1;i<y+1;i++){
            inn[i]=in.nextInt();
        }
        path=new ArrayList<>();
        path.add(1);
        for(int i=0;i<y+1;i++){
           bfs(inn[i],inn[i+1]);
           reSet(n);
           if(length>2*n-2){
               ttrue=false;
               break;
           }
        }
        if(ttrue&&length==2*n-2){
            for (Integer integer : path) {
                out.print(integer + " ");
            }
        }else {
            out.println(-1);
        }
        out.close();
    }
    public static void reSet(int n){
        for(int i=1;i<=n;i++){
            nodes[i].isVisited=false;
            nodes[i].depth=0;
            nodes[i].father=null;
        }
    }/*
    public static ArrayList<Integer> dfs(int begin, int stop){
        nodes[begin].isVisited=true;
        ArrayList<Integer> path=new ArrayList<>();
        if(begin==stop){
            path.add(begin);
        }else if(nodes[begin].isLeave){
            path=null;
        }else {
            for(Host i:nodes[begin].children){
                if(!i.isVisited){
                path.addAll(dfs(i.nu,stop));}
            }
            if(path.size()!=0){
                path.add(begin);
            }
        }
        return path;
    }
    */
    public static void bfs(int place,int stop){
        ArrayList<Integer> newPath=new ArrayList<>();
        Queue<Host> step=new LinkedList<>();
        step.add(nodes[place]);
        nodes[place].isVisited=true;
        while (!step.isEmpty()){
            Host palace=step.poll();
            for(Host city:palace.children){
                if(city!=null){
                    if(!city.isVisited){
                        city.father=palace;
                        city.depth=palace.depth+1;
                        step.add(city);
                        city.isVisited=true;
                    }
                    if(city.nu==stop){
                        length+=city.depth;
                        while (city.father!=null){
                            newPath.add(city.nu);
                            city=city.father;
                        }
                        for(int i=0;i<newPath.size();i++){
                            path.add(newPath.get(newPath.size()-i-1));
                        }
                        return;
                    }

                }}
        }
    }
}
