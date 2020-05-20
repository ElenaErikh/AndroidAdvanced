package Lesson_1.HW.HoursCounter;

public enum DayOfWeek {
    Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday;

    private static int oneDayWorkingHours = 8;
    private static int maxWorkingDays = 5;

    private static int workingHours;

    public int getOneDayWorkingHours() {
        return oneDayWorkingHours;
    }

    public int getMaxWorkingDays() {
        return maxWorkingDays;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public static boolean isWorkingDay(DayOfWeek dayOfWeek){
        if (dayOfWeek == DayOfWeek.Saturday || dayOfWeek == DayOfWeek.Sunday) {
            System.out.println("Сегодня выходной");
            return false;
        }
        return true;
    }

    public static int getWorkingHours(DayOfWeek dayOfWeek){
        int hours = 0;
        if (isWorkingDay(dayOfWeek)) {
            for (int i = dayOfWeek.ordinal(); i < maxWorkingDays; i++) {
                hours += oneDayWorkingHours;
            }
        }
        System.out.println("Количество оставшихся рабочих часов до конца недели: ");
        return hours;
    }

}

