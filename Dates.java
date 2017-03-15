package homework;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Calendar;

public class Dates{
    public static void howMuchTime(LocalDate birthDay){
        LocalDate today = LocalDate.now();
        Period p = Period.between(birthDay, today);
        System.out.println("You are " + p.getYears() + " years " + p.getMonths() + " months " + p.getDays() + " days old");
    }

    public static void main(String[] args){
        LocalDate birthDay = LocalDate.of(1996, Month.DECEMBER, 16);
        howMuchTime(birthDay);
    }
}
