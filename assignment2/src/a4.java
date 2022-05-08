import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class a4 {
    public static void main(String[] args) {
        SimpleDateFormat change = new SimpleDateFormat("yyyy-MM-dd");
        Scanner in=new Scanner(System.in);
        String start=in.nextLine();
        String end=in.nextLine();
        String a=start.substring(0,4);
        String b=end.substring(0,4);
        int c=Integer.parseInt(a);
        int d=Integer.parseInt(b);
        boolean wu=true;
        String g=a+"-"+start.substring(4,6)+"-"+start.substring(6,8);//转换成能转换成日期的字符串格式
        String h=b+"-"+end.substring(4,6)+"-"+end.substring(6,8);
        //try catch 用于将字符串转换成日期
        int t=0;
        String bala[]=new String[d-c+1];
        String baba[]=new String[d-c+1];

        String laba[]=new String[d-c+1];
        for(int i=c;i<=d;i++){
            baba[i-c]=String.format("%04d",i);
            bala[i-c]=baba[i-c]+String.valueOf(baba[i-c].charAt(3))+String.valueOf(baba[i-c].charAt(2))+String.valueOf(baba[i-c].charAt(1))+String.valueOf(baba[i-c].charAt(0));

            laba[i-c]=bala[i-c].substring(0,4)+"-"+bala[i-c].substring(4,6)+"-"+bala[i-c].substring(6,8);

        }
        try{ Date dateParseg = change.parse(g);
            Date dateParseh = change.parse(h);
            Date lala[]=new Date[d-c+1];
            for(int i=c;i<=d;i++){
                if(check(laba[i-c])==false){
                    continue;
                }
                lala[i-c]=change.parse(laba[i-c]);
                if(lala[i-c].after(dateParseg)&&lala[i-c].before(dateParseh)){
                    t=t+1 ;
                }
            }
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(t);
    }
    public static boolean check(String str){
        boolean result=true;
        SimpleDateFormat whether = new SimpleDateFormat("yyyy-MM-dd");
        try{whether.setLenient(false);
            whether.parse(str);
        }
        catch(Exception e){
            result=false;
        }
        return result;
    }
}