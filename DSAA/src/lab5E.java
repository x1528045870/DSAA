import java.io.*;
import java.util.*;
import java.util.Collections;
public class lab5E {
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        do{
            int n=in.nextInt();
            int[][] deque=new int[n][100];
            int[][] dequePlace=new int[n][2];
            for(int i=0;i<n;i++){
                dequePlace[i][0]=50;
                dequePlace[i][1]=51;
            }
            int q=in.nextInt();
            for(int i=0;i<q;i++){
                int num=in.nextInt();
                if(num==1){
                    int u=in.nextInt();
                    int w=in.nextInt();
                    int val=in.nextInt();
                    if(w==0){
                        deque[u-1][dequePlace[u-1][0]]=val;
                            dequePlace[u-1][0]--;
                    }
                    else {
                        deque[u-1][dequePlace[u-1][1]]=val;
                            dequePlace[u-1][1]++;
                    }
                }
                else if(num==2){
                    int u=in.nextInt();
                    int w=in.nextInt();
                    if(dequePlace[u-1][0]==dequePlace[u-1][1]){
                        out.println(-1);
                    }else {
                    if(w==0){
                        dequePlace[u-1][0]++;
                        out.println(deque[u-1][dequePlace[u-1][0]]);
                        deque[u-1][dequePlace[u-1][0]]=0;
                    }
                    else {
                            dequePlace[u-1][1]--;
                        out.println(deque[u-1][dequePlace[u-1][1]]);
                        deque[u-1][dequePlace[u-1][1]]=0;
                    }
                }}
                else if(num==3){
                    int u=in.nextInt();
                    int v=in.nextInt();
                    int w=in.nextInt();
                    if(w==0){
                        System.arraycopy(deque[v-1],dequePlace[v-1][0]+1,deque[u-1],dequePlace[u-1][1],dequePlace[v-1][1]-dequePlace[v-1][0]-1);
                        /*while(dequePlace[v-1][0]!=dequePlace[v-1][1]-1){//即掏空了的时候
                            dequePlace[v-1][0]++;
                            dequePlace[u-1][1]++;
                            deque[u-1][dequePlace[u-1][1]]=deque[v-1][dequePlace[v-1][0]];
                            deque[v-1][dequePlace[v-1][0]]=0;
                    }*/
                    }
                    else {
                        while(dequePlace[v-1][0]!=dequePlace[v-1][1]){
                            dequePlace[v-1][1]--;
                            dequePlace[u-1][1]++;
                            deque[u-1][dequePlace[u-1][1]]=deque[v-1][dequePlace[v-1][1]];
                            deque[v-1][dequePlace[v-1][1]]=0;
                        }
                    }
                }
            }
        }while (in.hasNext());
        out.close();
    }
}
