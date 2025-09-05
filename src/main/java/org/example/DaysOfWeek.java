package org.example;

public enum DaysOfWeek {
    SUNDAY("sunday"),
    MONDAY("monday"),
    TUESDAY("tuesday"),     // KORREKT: "tuesday"
    WEDNESDAY("wednesday"),
    THURSDAY("thursday"),   // KORREKT: "thursday"
    FRIDAY("friday"),
    SATURDAY("saturday");

    private final String nameOfDay;

    DaysOfWeek(String nameOfDay){
        this.nameOfDay = nameOfDay;
    }

    public static String workDayOrWeekend(DaysOfWeek day){
        if(day == SATURDAY || day == SUNDAY){
            return "Hoch die Hände Wochenende";
        } else {
            return day.nameOfDay;
        }
    }
}