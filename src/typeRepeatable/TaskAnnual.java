package typeRepeatable;

import java.time.LocalDateTime;

public class TaskAnnual extends SimpleTask{
    @Override
    public boolean nextDate(LocalDateTime dateTime, LocalDateTime inputDate) {
        return inputDate.getDayOfMonth()==dateTime.getDayOfMonth()&&inputDate.getMonth() == dateTime.getMonth();

    }
}
