package typeRepeatable;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TaskWeekly extends Task{
    @Override
    public boolean isAvailableForDate(LocalDateTime inputDate) {
        LocalDateTime startDate = this.getDateTime().atStartOfDay();
        while(startDate.isBefore((inputDate))){
             startDate = startDate.plusWeeks(1);        }
        return  startDate.equals(inputDate);
    }


    public TaskWeekly(String title, String description, TypeTask typeTask) {
        super(title, description, typeTask);
    }
}
