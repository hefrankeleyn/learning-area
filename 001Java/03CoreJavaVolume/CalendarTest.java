import java.time.DayOfWeek;
import java.time.LocalDate;

public class CalendarTest{
    public static void main(String[] args) {
        currentMonthCalendar();
    }
    private static void currentMonthCalendar(){
        // 创建一个日历对象
        LocalDate date = LocalDate.now();
        // 当前的月份
        int month = date.getMonthValue();
        // 当前的天数
        int today = date.getDayOfMonth();
        // 将日历对象设置为当月的第一天
        date = date.minusDays(today-1);
        // 获取到当月第一天星期几
        DayOfWeek weekday = date.getDayOfWeek();
        int value = weekday.getValue();
        
        System.out.println(String.join(" ", "Mon","Tue","Wed","Thu","Fri","Sat","Sun"));
        for(int i=1; i<value; i++){
            System.out.printf("%4s"," ");
        }
        while (date.getMonthValue() == month) {
            System.out.printf("%3d", date.getDayOfMonth());
            if(date.getDayOfMonth() == today){
                System.out.print("*");
            }else{
                System.out.print(" ");
            }
            date = date.plusDays(1);
            if(date.getDayOfWeek().getValue() == 1) System.out.println();
        }
    }
}