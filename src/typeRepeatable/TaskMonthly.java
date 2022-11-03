package typeRepeatable;

import java.time.LocalDateTime;

public class TaskMonthly extends SimpleTask{
    @Override
    public boolean nextDate(LocalDateTime dateTime, LocalDateTime inputDate) {
        return inputDate.getDayOfMonth()==dateTime.getDayOfMonth();
    }
}
