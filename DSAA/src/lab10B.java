import java.io.*;
import java.util.*;
/**
 * 判断最小获得哪些边，图是强连通图
 * 这儿还有dfs
 */
class Cities{
   int num;
    ArrayList<Cities> children=new ArrayList<>();
   boolean isVisited=false;
   public Cities(int num){
       this.num=num;
   }
}
public class lab10B {
    static Cities[] cities;
    static int[] roadX;
    static int[] roadY;
    static int n;
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        n=in.nextInt();
        cities=new Cities[n+1];
        for(int i=1;i<=n;i++){
            Cities x=new Cities(i);
            cities[i]=x;
        }
        int m=in.nextInt();
         roadX=new int[m+1];
         roadY=new int[m+1];
        for(int i=1;i<=m;i++){
             roadX[i]=in.nextInt();
             roadY[i]=in.nextInt();
        }
        //二分答案，看看到第几个
        int l=1;int r=m;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(!check(mid)){
                l=mid+1;
            }
            else {
                r=mid-1;
            }
            reset();
        }
        if(l<=m&&check(l)){
            out.println(l);
        }else {
            out.println(-1);
        }
        out.close();
    }
    /**
     *建图正反dfs，看看能否遍历全部节点，是不是强连通图。
     * 有问题，需要改，无法进入不连通的点
     */
    static boolean check(int k){
        //建邻接矩阵
        for(int i=1;i<=k;i++){
            int x=roadX[i];
            int y=roadY[i];
            cities[x].children.add(cities[y]);
        }
        //对图dfs看看有无全部遍历
        dfs(1);
        for(int i=1;i<=n;i++){
            if(!cities[i].isVisited){
                return false;
            }
            else {
                cities[i].isVisited=false;
            }
        }
        reset();
        //对反图再做一次dfs，看看反着能否全部达到
        //scc求强连通分量简化版，单判断
        for(int i=1;i<=k;i++){
            int x=roadX[i];
            int y=roadY[i];
            cities[y].children.add(cities[x]);
        }
        dfs(1);
        for(int i=1;i<=n;i++){
            if(!cities[i].isVisited){
                return false;
            }
        }
        return true;
    }

    /**
     *DFS
     * 递归实现
     * 有时间写个栈实现
     */
    static void dfs(int i){
        cities[i].isVisited=true;
        for (Cities x:cities[i].children){
            if(!x.isVisited){
                dfs(x.num);
            }
        }
    }
    static void reset(){
        for(int i=1;i<=n;i++){
            cities[i].children.clear();
            cities[i].isVisited=false;
        }
    }
}
