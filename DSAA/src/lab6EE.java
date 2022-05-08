//马拉车法
import java.io.*;
import java.util.*;
public class lab6EE {
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        String str=in.next();
        char[] huiWen=new char[str.length()+str.length()+3];
        int[] maxL=new int[huiWen.length];
        int j=0;
        for(int i=0;i<huiWen.length;i++){
            maxL[i]=0;
            if(i==0){
                huiWen[i]='$';
            }else if(i==huiWen.length-1){
                huiWen[i]='^';
            }
            else if(i%2==1){
                huiWen[i]='#';
            }
            else{
                huiWen[i]=str.charAt(j);
                j++;
            }
        }
        int zhongXin=0;int moWei=0;
        int max=0;
        for (int i=1;i<huiWen.length-1;i++){
                if(moWei>i){
                    int z=2*zhongXin-i;
                    maxL[i]=maxL[z];
                    if(moWei-i<maxL[i]){
                        maxL[i]=moWei-i;
                    }
                }
                while (huiWen[i-maxL[i]-1]==huiWen[maxL[i]+i+1]){
                    maxL[i]++;
                }
                if(i+maxL[i]>moWei){
                    moWei=i+maxL[i];
                    zhongXin=i;
                }
                if(max<maxL[i]){
                    max=maxL[i];
                }

        }
        out.println(max);
        out.close();
    }
}