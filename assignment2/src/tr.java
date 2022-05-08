import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class tr {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            //1、日期转字符串
           /* Calendar calendar = Calendar.getInstance();
            Date date = calendar.getTime();
            String dateStringParse = sdf.format(date);
            System.out.println(dateStringParse);*/
            //2、字符串转日期
            String dateString = "2017-12-20 14:02:08";
            Date dateParse = sdf.parse(dateString);
            System.out.println(dateParse);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
