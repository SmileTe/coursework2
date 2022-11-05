package typeRepeatable;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TaskAnnual extends Task{
//    @Override
//    public boolean nextDate(LocalDateTime dateTime, LocalDateTime inputDate) {
//        return inputDate.getDayOfMonth()==dateTime.getDayOfMonth()&&inputDate.getMonth() == dateTime.getMonth();
//
//    }

    @Override
    public boolean isAvailableForDate(LocalDateTime inputDate) {
        LocalDateTime startDate = this.getDateTime().atStartOfDay();
        while(startDate.isBefore((inputDate))){
            startDate = startDate.plusYears(1);
        }
        return  startDate.equals(inputDate);
        }

    public TaskAnnual(String title, String description, TypeTask typeTask) {
        super(title, description, typeTask);
    }
}
