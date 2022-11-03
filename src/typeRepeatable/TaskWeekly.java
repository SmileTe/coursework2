package typeRepeatable;

import java.time.LocalDateTime;

public class TaskWeekly extends SimpleTask{
    @Override
    public boolean nextDate(LocalDateTime dateTime, LocalDateTime inputDate) {
        //получить дни недели для обеих задач и сравнить
        return  inputDate.getDayOfWeek() == dateTime.getDayOfWeek();
    }
}
