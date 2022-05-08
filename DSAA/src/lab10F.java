import java.io.*;
import java.util.*;
/**
 * 判断最小获得哪些边，图是强连通图
 * 这儿还有dfs
 */
class Bala{
    int num;
    ArrayList<Bala> children=new ArrayList<>();
    boolean isVisited=false;
    public Bala(int num){
        this.num=num;
    }
    int group=0;
}
class Gv{
    int num;
    int enterDegree=0;
    int outDegree=0;
    public Gv(int num){
        this.num=num;
    }
}
public class lab10F {
    static Stack<Integer> cs=new Stack<>();
    static Stack<Integer> firstDfs=new Stack<>();
    static Bala[] cities;
    static int[] roadX;
    static int[] roadY;
    static int n;
    static int m;
    static int group=0;
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        n = in.nextInt();
        cities = new Bala[n + 1];
        for (int i = 1; i <= n; i++) {
            Bala x = new Bala(i);
            cities[i] = x;
        }
         m = in.nextInt();
        roadX = new int[m + 1];
        roadY = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            roadX[i] = in.nextInt();
            roadY[i] = in.nextInt();
        }
        scc();
        Gv[] gV=new Gv[group+1];
        for(int i=1;i<=group;i++){
            Gv wu=new Gv(i);
            gV[i]=wu;
        }
        for(int i=1;i<=n;i++){
            for (Bala x:cities[i].children){
                if(x.group!=cities[i].group){;
                gV[x.group].enterDegree++;
                gV[cities[i].group].outDegree++; }
            }
        }
        int enter=0;
        int outer=0;
        for(int i=1;i<=group;i++){
            if(gV[i].enterDegree==0){
                enter++;
            }
            if(gV[i].outDegree==0){
                outer++;
            }
        }
        if(group==1){
            out.println(0);
        }else {
        out.println(Math.max(enter, outer));}
        out.close();
    }
    /**
     *Scc找强连通分量
     */
    static void scc(){
        //reverseOrder dfs
        for(int i=1;i<=m;i++){
            int x=roadX[i];
            int y=roadY[i];
            cities[y].children.add(cities[x]);
        }
        dfs();
        resetIt();
        for(int i=1;i<=m;i++){
            int x=roadX[i];
            int y=roadY[i];
            cities[x].children.add(cities[y]);
        }
        dfsPart();
    }
    /**
     *DFS
     * dfs栈实现
     */
    static void dfs(){
        for (int i=1;i<=n;i++){
            if(!cities[i].isVisited){
                cities[i].isVisited=true;
                firstDfs.push(i);
            }
            while (!firstDfs.empty()){
                int k=firstDfs.peek();
                boolean check=false;
                for (Bala x:cities[k].children){
                    if (!x.isVisited){
                    x.isVisited=true;
                    firstDfs.push(x.num);
                    check=true;
                    break;}
                }
                if(check){
                    continue;
                }
                cs.add(firstDfs.pop());
            }
        }
    }
    /**
     *dfs找强连通分量，并缩点
     */
    static void dfsPart(){
        while (!cs.isEmpty()){
            int i=cs.pop();
            if(!cities[i].isVisited){
                group++;
                cities[i].isVisited=true;
                cities[i].group=group;
                firstDfs.push(i);
            }else {
                continue;
            }
            while (!firstDfs.empty()){
                int k=firstDfs.peek();
                boolean check=false;
                for (Bala x:cities[k].children){
                    if (!x.isVisited){
                        x.isVisited=true;
                        x.group=group;
                        firstDfs.push(x.num);
                        check=true;
                        break;}
                }
                if(check){
                    continue;
                }
                firstDfs.pop();
            }
        }
    }
    static void resetIt(){
        for(int i=1;i<=n;i++){
            cities[i].children.clear();
            cities[i].isVisited=false;
        }
    }
}
