
import java.util.Date;
import java.util.Objects;

public class EqualsTest{
    public static void main(String[] args) {
        String str01 = "aaa";
        String str02 = null;
        String str03 = "aaa";

        boolean b01 = Objects.equals(str01, str02);
        boolean b02 = Objects.equals(str01, str03);
        //System.out.println(b01);
        //System.out.println(b02);

        Date date = new Date();
        long l01 = date.getTime();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        Date sqlDate02 = new java.sql.Date(date.getTime());
        boolean bD = date.equals(sqlDate);
        System.out.println(date.getClass());
        System.out.println("dD: "+bD);
        System.out.println(sqlDate.getClass());
        boolean bD02= sqlDate.equals(date);
        boolean bD03 = sqlDate02.equals(date);
        boolean bD04 = sqlDate02.equals(sqlDate);
        System.out.println("dD02: "+bD02);
        System.out.println("bD03: "+bD03);
        System.out.println("bD04: "+bD04);
    }
}