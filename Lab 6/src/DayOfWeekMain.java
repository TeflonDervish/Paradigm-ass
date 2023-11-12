
enum DayOfWeek {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public class DayOfWeekMain {

    public static void main(final String[] args){
        System.out.println(getWorkingHours(DayOfWeek.TUESDAY));
    }

    public static int getWorkingHours(DayOfWeek currentDay) {
        // Общее количество рабочих часов в неделе
        int totalWorkingHoursInWeek = 40;

        // Получаем порядковый номер текущего дня
        int currentDayIndex = currentDay.ordinal();

        // Вычисляем оставшиеся рабочие часы в неделе
        int remainingWorkingHours = totalWorkingHoursInWeek - (currentDayIndex * 8);

        return remainingWorkingHours;
    }
}
