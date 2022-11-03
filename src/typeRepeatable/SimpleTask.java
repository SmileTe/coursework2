package typeRepeatable;


import java.time.LocalDateTime;

public class SimpleTask implements Repeatable_ {

    @Override
    public boolean nextDate(LocalDateTime dateTime, LocalDateTime inputDate) {
        return false;
    }
}
