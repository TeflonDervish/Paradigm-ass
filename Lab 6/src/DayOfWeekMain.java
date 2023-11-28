
enum DayOfWeek {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public class DayOfWeekMain {

    public static void main(final String[] args){
        System.out.println(getWorkingHours(DayOfWeek.WEDNESDAY));
    }

    public static int getWorkingHours(DayOfWeek currentDay) {
        int totalWorkingHoursInWeek = 40;
        int currentDayIndex = currentDay.ordinal();
        int remainingWorkingHours = totalWorkingHoursInWeek - (currentDayIndex * 8);

        return remainingWorkingHours;
    }
}
