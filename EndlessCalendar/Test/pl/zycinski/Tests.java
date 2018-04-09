package pl.zycinski;

import org.junit.Assert;

import java.time.LocalDate;


/**
 * @author Dominik Zycinski
 * @version 1.02, 23/03/2018
 */

/**Tests for Endless Calendar which check if the day of the week for a particular day is correct */
class Tests {




    private boolean isDay(LocalDate data) {

        return ((EndlessCalendar.whatDayIsIt(data).ordinal() == data.getDayOfWeek().getValue())    ||
                EndlessCalendar.whatDayIsIt(data).ordinal()  == data.getDayOfWeek().getValue() - 7 );

    }



    private static boolean isLeapYear(int year) {
        if (year % 400 == 0) {

            return true;
        }
        if (year % 100 == 0) {

            return year % 100 == 0;
        }

        return year % 4 == 0;
    }




    @org.junit.jupiter.api.Test
    void dayTest() {


        for(int year = 1683 ; year<=2020; year++)
        {
            for(int month = 1; month<=12; month++)
            {
                if(month ==1 || month ==3||month ==5||month ==7||month==8|month==10|month==12){
                    for(int days = 1; days<=31; days++) {
                        Assert.assertTrue(isDay(LocalDate.of(year, month, days)));
                    }
                }
                if(month ==2){
                    if(isLeapYear(year)) {
                        for (int days = 1; days <= 29; days++) {
                            Assert.assertTrue(isDay(LocalDate.of(year, month, days)));
                        }
                    }
                    else{
                        for (int days = 1; days <= 28; days++) {
                            Assert.assertTrue(isDay(LocalDate.of(year, month, days)));
                        }
                    }
                }

                if(month ==4||month==6||month==9||month==11){
                    for(int days = 1; days<=30; days++) {
                        Assert.assertTrue(isDay(LocalDate.of(year, month, days)));
                    }
                }



            }
        }

    }
}
