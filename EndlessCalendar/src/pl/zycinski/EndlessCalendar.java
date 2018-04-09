package pl.zycinski;

import java.time.LocalDate;

/**
 * @author Dominik Zycinski
 * @version 1.02, 23/03/2018
 * @see java.time.LocalDate
 * @since 1.8
 */

/**Class for sets the day of the week for a particular date.   */
public class EndlessCalendar {


    /**Default constructor*/
    public EndlessCalendar(){};


    /** The metod that sets the day of the week for a particular day, it uses an algorithm Mike Keith.
     *  The values  0 - Sunday, 1 - Monday, 2 - Tuesday, 3 - Wednesday, 4 - Thursday, 5 - Friday, 6 - Saturday *
     *  @param data  is an immutable date-time object that represents a date, often viewed as year-month-day.
     *  @return Day of the week which is an enumerated type*/
    public static DayOfWeek whatDayIsIt(LocalDate data)
    {
        int m = data.getMonthValue();
        int y = data.getYear();
        int d = data.getDayOfMonth();

        int z = m<3 ? data.getYear() -1: data.getYear();
        int c = m<3 ? 0: 2;

        int result = ((23 * m/9) + d + 4 + y + (z/4) - (z/100) + (z/400) - c )%7 ;


        return DayOfWeek.values()[result];
    }


}

