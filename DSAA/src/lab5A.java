import java.io.*;
import java.util.*;
public class lab5A {
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out =new QWriter();
        int T=in.nextInt();
        String[] food=new String[T];
        String[] student=new String[T];
        int topFood=-1;int rearStudent=-1;int frontStudent=0;
        int foodNum=0;
        int studentNum =0;
        for(int i=0;i<T;i++){
            String what=in.nextLine();
            if("NewFood".equals(what.substring(0,7))){
                    food[++topFood]=what.substring(8);
                    foodNum++;
                }
            else if ("NewComer".equals(what.substring(0,8))){
                    student[++rearStudent]=what.substring(9);
                    if(rearStudent==T-1){
                        rearStudent=-1;
                    }
                    studentNum++;
                }
            else if(studentNum!=0&&foodNum!=0){
                    if(student[frontStudent].equals(food[topFood])){
                        studentNum--;
                        foodNum--;
                        student[frontStudent++]="";
                        food[topFood--]="";
                        if(frontStudent==T){
                            frontStudent=0;
                        }
                    }
                    else {
                        if(rearStudent==T-1){
                            rearStudent=-1;
                        }
                        student[++rearStudent]=student[frontStudent];
                        student[frontStudent++]="";
                        if(frontStudent==student.length){
                            frontStudent=0;
                        }
                    }
                }
            }
        int j=studentNum;
        while(studentNum>0&&foodNum>0&&j>0){
            if(student[frontStudent].equals(food[topFood])){
                studentNum--;
                j=studentNum;
                foodNum--;
                student[frontStudent++]="";
                food[topFood--]="";
                if(frontStudent==student.length){
                    frontStudent=0;
                }
            }
            else {
                j--;
                if(rearStudent==student.length-1){
                    rearStudent=-1;
                }
                student[++rearStudent]=student[frontStudent];
                student[frontStudent++]="";
                if(frontStudent==student.length){
                    frontStudent=0;
                }
            }
        }
        if (studentNum==0){
            out.println("Qi Fei!");
        }
        else {
            out.println(studentNum);
        }
        out.close();
    }
}
