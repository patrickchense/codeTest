import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;

interface I1 {
   String name = "N1";
   String s1 = "S1";
 }
 interface I2 extends I1{
   String name = "N2";
 }
 class C2 implements I2 {
    public C2() {
        super();

    }
   public static void main(String[] args) {
             System.out.print(I2.name+",");
             System.out.print(I2.s1+",");
             System.out.print(((I1)new C2()).name);

       Date aDate = null;
       try {
           aDate = new SimpleDateFormat("yyyy-mm-dd").parse("2012-01-15");
           Calendar aCalendar = Calendar.getInstance();
           aCalendar.setTime(aDate);
           System.out.print(aCalendar.get(aCalendar.DAY_OF_MONTH)+"," +  aCalendar.get(aCalendar.MONTH));

           DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
           LocalDate bDate = LocalDate.parse("2012-01-15", formatter);
           System.out.print(" " + bDate.getDayOfMonth()+"," +  bDate.getMonthValue());

       } catch (ParseException ex) {System.out.println("ParseException " + ex);
       } catch (DateTimeParseException ex) {System.out.println(" DateTimeParseException " + ex);
       }
       System.out.println();
       System.out.println(Math.nextAfter(10.23, 0.01));
       System.out.println(Math.nextUp(10.22));
       System.out.println(-1 >>> 0);
       System.out.println(-1 >>> 32);
       System.out.println(-1 >> 32);
       System.out.println(-1 >> 1);
           }
}