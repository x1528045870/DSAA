import java.util.Scanner;
public class P5A {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String l;String r;
        char[] num={'0','1','6','8','9'};
        String[] line=new String[6];
        int n=0;
        while(sc.hasNext()) {
            l = String.valueOf(sc.next());
            char[] ll=l.toCharArray();
            r = String.valueOf(sc.next());
            char[] rr=r.toCharArray();
            long iMax=0;long rMin=0;
            boolean checkL=true;
            boolean checkR=true;
            String chu="";
            String chu2="";
            //个位数时
            if(Long.parseLong(l)<10){
                checkL=false;
                if(Integer.parseInt(l)>1&&Integer.parseInt(l)<9){
                    chu="8";
                }
                else if(Integer.parseInt(l)==9){
                    chu="11";
                }
                else {
                    chu=l;
                }
            }
            if(Long.parseLong(r)<10){
                checkR=false;
                if(Integer.parseInt(r)>1&&Integer.parseInt(r)<8){
                    chu2="1";
                }
                else if(Integer.parseInt(r)>8&&Integer.parseInt(l)<10){
                    chu2="8";
                }
                else{
                    chu2=r;
                }
            }
            //寻找该位数最大的那个数
            for(int i=0;i<l.length();i++){
                if(i<l.length()/2){
                    iMax=iMax*10+9;
                }
                else if(i==l.length()/2&&l.length()%2==1){
                    iMax=iMax*10+8;
                }
                else {
                    iMax=iMax*10+6;
                }
            }
            //寻找该位数最小的那个数
            for(int i=0;i<r.length();i++){
                if(i==0||i==r.length()-1){
                    rMin=rMin*10+1;
                }
                else {
                    rMin=rMin*10;
                }
            }
            //改位数造数
            if(Long.parseLong(l)>iMax){
                checkL=false;
                StringBuilder a=new StringBuilder();
                for(int i=0;i<l.length()+1;i++){
                    if(i==0||i==l.length()){
                        a.append(1);
                    }
                    else {
                        a.append(0);
                    }
                }
                chu=a.toString();
            }
            if(Long.parseLong(r)<rMin){
                    checkR=false;
                    StringBuilder b=new StringBuilder();
                for(int i=0;i<r.length()-1;i++){
                    if(i<(r.length()-1)/2){
                        b.append(9);
                    }
                    else if(i==((r.length()-1)/2)&&r.length()%2==0){
                        b.append(8);
                    }
                    else {
                        b.append(6);
                    }
                }
                chu2=b.toString();
            }
            if(checkL){
                boolean check=true;
                char[] out=new char[l.length()];
            //找比l大的最小值
            for(int i=0;i<l.length()/2;i++){
                if(check){
                out[i]=check(ll[i],num);
                 if(out[i]>ll[i]){
                    check=false;
                 }
                }
                else{
                    out[i]='0';
                }
            }
                //l奇数中间位判断
                if(l.length()%2==1){
                    if(check)
                    {out[l.length()/2]=check(ll[l.length()/2],num);}
                    else {
                        out[l.length()/2]='0';
                    }
                    if(out[l.length()/2]=='6'){
                        out[l.length()/2]='8';
                    }
                    else if(out[l.length()/2]=='9'){
                        //中间为9时进位
                        out[l.length()/2]='0';
                        for (int i=l.length()/2-1;i>=0;i--){
                            out[i]=stepUp(out[i],num);
                            if (out[i]!='0'){break;}
                        }
                    }
                }
                else {
                    if(check){
                        {out[l.length()/2-1]=check(ll[l.length()/2-1],num);}
                    }
                    if(out[l.length()/2-1]=='9'){
                        //中间为9时进位
                        out[l.length()/2-1]='0';
                        for (int i=l.length()/2-2;i>=0;i--){
                            out[i]=stepUp(out[i],num);
                            if (out[i]!='0'){break;}
                        }
                    }
                }
                //对称下
                for(int i=0;i<l.length();i++){
                    if(out[i]=='6'){
                        out[l.length()-i-1]='9';
                    }
                    else if(out[i]=='9'){
                        out[l.length()-i-1]='6';
                    }
                    else {
                        out[l.length()-i-1]=out[i];
                    }
                }
                String linShi=String.valueOf(out);
                boolean left;
                if(Integer.parseInt(linShi)>Integer.parseInt(l)){
                    left=true;
                }

                //l奇数中间位判断
                if(l.length()%2==1){
                    if(check)
                    {out[l.length()/2]=checkMid(ll[l.length()/2],num);}
                    else {
                        out[l.length()/2]='0';
                    }
                    if(out[l.length()/2]=='6'){
                        out[l.length()/2]='8';
                    }
                    else if(out[l.length()/2]=='9'){
                        //中间为9时进位
                        out[l.length()/2]='0';
                        for (int i=l.length()/2-1;i>=0;i--){
                            out[i]=stepUp(out[i],num);
                            if (out[i]!='0'){break;}
                        }
                    }
                }
                else {
                    if(check){
                        {out[l.length()/2-1]=checkMid(ll[l.length()/2-1],num);}
                    }
                     if(out[l.length()/2-1]=='9'){
                        //中间为9时进位
                        out[l.length()/2-1]='0';
                        for (int i=l.length()/2-2;i>=0;i--){
                            out[i]=stepUp(out[i],num);
                            if (out[i]!='0'){break;}
                        }
                    }
                }
                //对称下
                for(int i=0;i<l.length();i++){
                    if(out[i]=='6'){
                        out[l.length()-i-1]='9';
                    }
                    else if(out[i]=='9'){
                        out[l.length()-i-1]='6';
                    }
                    else {
                        out[l.length()-i-1]=out[i];
                    }
                }
                chu=String.valueOf(out);
            }
            if(checkR){
                char[] bigOut=new char[r.length()];
                boolean check2=true;
            //找比r小的最大值
            for(int i=0;i<r.length()/2;i++){
                if(check2){
                    bigOut[i]=check2(rr[i],num);
                    if(bigOut[i]<rr[i]){
                        check2=false;
                    }
                }
                else{
                    bigOut[i]='9';
                }
            }
            //r判断
            if(r.length()%2==1){
                if(check2){
                bigOut[r.length()/2]=checkMid2(rr[r.length()/2],num);}
                else {
                    bigOut[r.length()/2]='8';
                }
                if(bigOut[r.length()/2]=='6'){
                    bigOut[r.length()/2]='1';
                }
                else if(bigOut[r.length()/2]=='9'){
                    bigOut[r.length()/2]='8';
                }
                else if(bigOut[r.length()/2]=='0'){
                    //中间为0时退位
                    bigOut[r.length()/2]='8';
                    for (int i=r.length()/2-1;i>=0;i--){
                        bigOut[i]=stepDown(bigOut[i],num);
                        if (bigOut[i]!='9'){break;}
                    }
                }

            }
            else {
                if(check2){
                    bigOut[r.length()/2-1]=checkMid2(rr[r.length()/2-1],num);
                }
                if(bigOut[r.length()/2-1]=='0'){
                    //中间为0时退位
                    bigOut[r.length()/2-1]='9';
                    for (int i=r.length()/2-2;i>=0;i--){
                        bigOut[i]=stepDown(bigOut[i],num);
                        if (bigOut[i]!='9'){break;}
                    }
                }
            }
            for(int i=0;i<r.length();i++){
                if(bigOut[i]=='6'){
                    bigOut[r.length()-i-1]='9';
                }
                else if(bigOut[i]=='9'){
                    bigOut[r.length()-i-1]='6';
                }
                else {
                    bigOut[r.length()-i-1]=bigOut[i];
                }
            }

            chu2=String.valueOf(bigOut);
            }
            line[n]=chu+" "+chu2;
            n++;
        }

        for(int i=0;i<n;i++){
            System.out.println(line[i]);
        }

    }
    public static char check(char x, char[] num){
        for(int i=0;i<5;i++){
            if(x==num[i]){
                return x;
            }
            else if(x<num[i]){
                return num[i];
            }
        }
        return '9';
    }
    public static char checkMid(char x, char[] num){
        for(int i=0;i<5;i++){
            if(x<num[i]){
                return num[i];
            }
        }
        return '9';
    }
    public static char check2(char x, char[] num){
        for(int i=5;i>0;i--){
            if(x==num[i-1]){
                return x;
            }
            else if(x>num[i-1]){
                return num[i-1];
            }
        }
        return '0';
    }
    public static char checkMid2(char x, char[] num){
        for(int i=5;i>0;i--){
           if(x>num[i-1]){
                return num[i-1];
            }
        }
        return '0';
    }
    public static char stepUp(char x,char[] num){
        if(x=='9'){
            return '0';
        }
        else{
            for(int i=0;i<=4;i++){
                if(x<num[i]){
                    return num[i];
                }
            }
        }
        return '0';
    }
    public static char stepDown(char x,char[] num){
        if(x=='0'){
            return '9';
        }
        else{
            for(int i=4;i>=0;i--){
                if(x>num[i]){
                    return num[i];
                }
            }
        }
        return '9';
    }
}
