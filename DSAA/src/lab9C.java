import java.io.*;
import java.util.*;
class points{
int num;
ArrayList<points> children=new ArrayList<>();
boolean isVisited=false;
int degree=0;
public points(int num){
    this.num=num;
}
}
public class lab9C {
    static points[] bala;
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        int n=in.nextInt();
        int m=in.nextInt();
        int num=0;
        bala=new points[n+1];
        for(int i=1;i<=n;i++){
           points x=new points(i);
           bala[i]=x;
        }
        for(int i=0;i<m;i++){
            int x=in.nextInt();
            int y=in.nextInt();
            bala[x].children.add(bala[y]);
            bala[y].children.add(bala[x]);
            bala[x].degree++;
            bala[y].degree++;
        }
        Queue<points> yes=new LinkedList<>();
        for(int i=1;i<=n;i++){
            if(bala[i].degree<=1){
                num++;
                yes.add(bala[i]);
                bala[i].isVisited=true;
            }
        }
        while (!yes.isEmpty()){
            points x=yes.poll();
            for(points y:x.children){
                y.degree--;
                if(y.degree==1&&!y.isVisited){
                    yes.add(y);
                    y.isVisited=true;
                    num++;
                }
            }
        }
        if(num==n){
            out.println("Good");
        }else {
            out.println("Bad");
        }
        out.close();
    }
}
