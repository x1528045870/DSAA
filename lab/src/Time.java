import java.util.Scanner;
public class Time {
    public static void main(String[] args) {


        int time;
        int hours;
        int minutes;
        int seconds;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of seconds:");
        time=input.nextInt();
        hours=time/3600;
        minutes=time%3600/60;
        seconds=time%60;
        System.out.printf("The equivalent time is %s hours %s minutes and %s seconds ",hours,minutes,seconds);
        input.close();
    }
}
