package typeRepeatable;

import java.time.LocalDateTime;

public class TaskDaily extends SimpleTask{

    @Override
    public boolean nextDate(LocalDateTime dateTime, LocalDateTime inputDate) {
        return true;
    }
}
