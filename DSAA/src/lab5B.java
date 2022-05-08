import java.io.*;
import java.util.*;
public class lab5B{
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        int n=in.nextInt();
        int[] group1=new int[n+1];
        int[] group2=new int[n+1];
        int[] time=new int[n];
        int timer=0;
        int l1=in.nextInt();
        int l2=in.nextInt();
        int[] line1=new int[l1];
        int[] line2=new int[l2];
        int low1=0;int low2=0;
        for(int i=0;i<l1;i++){
            line1[i]=in.nextInt();
            group1[line1[i]]=i;
        }
        for(int i=0;i<l2;i++){
            line2[i]=in.nextInt();
            group2[line2[i]]=i;
        }
        while(low1<l1&&low2<l2){
            while(low1<l1&&line1[low1]==0){
                low1++;
            }
            while(low2<l2&&line2[low2]==0){
                low2++;
            }
            if (low1==l1||low2==l2){
                break;
            }
            timer++;
            if(line1[low1]==line2[low2]){
                time[line1[low1]-1]=timer;
                low1++;
                low2++;
            }
            else {
                time[line1[low1]-1]=timer;
                time[line2[low2]-1]=timer;
                if(group1[line2[low2]]>low1){
                line1[group1[line2[low2]]]=0;}
                if(group2[line1[low1]]>low2){
                line2[group2[line1[low1]]]=0;}
                low1++;
                low2++;
            }
        }
        while(low1<l1){
            while(low1<l1&&line1[low1]==0){
                low1++;
            }
            if (low1==l1){
                break;
            }
            timer++;
            time[line1[low1]-1]=timer;
            low1++;
        }
        while (low2<l2){
            while(low2<l2&&line2[low2]==0){
                low2++;
            }
            if (low2==l2){
                break;
            }
            timer++;
            time[line2[low2]-1]=timer;
            low2++;
        }
        for(int i=0;i<n;i++){
            out.print(time[i]+" ");
        }
        out.close();
    }
}
