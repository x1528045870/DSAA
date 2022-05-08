import java.io.*;
import java.util.*;
class pC{
    long nu;
    ArrayList<pC> children=new ArrayList<>();
    ArrayList<Integer> weights=new ArrayList<>();
    boolean isVisited=false;
    long path;
    public pC(int nu){
        this.nu=nu;
    }
}
public class lab7A {
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        int n=in.nextInt();
        int num=in.nextInt();
        int count=0;
        pC[] nodes=new pC[n];
        for(int i=0;i<n;i++){
           pC node=new pC(i);
           nodes[i]=node;
        }
        for(int i=0;i<n-1;i++){
            int u=in.nextInt();
            int v=in.nextInt();
            int w=in.nextInt();
            nodes[u-1].children.add(nodes[v-1]);
            nodes[u-1].weights.add(w);
            nodes[v-1].children.add(nodes[u-1]);
            nodes[v-1].weights.add(w);
        }
        pC[] q=new pC[n];
        int front=0;
        int rear=0;
        q[rear++]=nodes[0];
        nodes[0].path=0;
        nodes[0].isVisited=true;
        while (front!=rear){
            pC temp=q[front++];
            for (int i=0;i<temp.children.size();i++){
                if(!temp.children.get(i).isVisited){
                    temp.children.get(i).isVisited=true;
                    q[rear++]=temp.children.get(i);
                    temp.children.get(i).path=temp.path+temp.weights.get(i);
                }
            }
            if(temp.children.size()==1){
                if(temp.path==num){
                    count++;
                }
            }
        }
        out.println(count);
        out.close();
    }
}
