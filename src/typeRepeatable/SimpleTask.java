package typeRepeatable;


import java.time.LocalDateTime;

public class SimpleTask extends Task {

    public SimpleTask(String title, String description, TypeTask typeTask, LocalDateTime dateTimeTask) {
        super(title, description, typeTask, dateTimeTask);
    }

    @Override
    public boolean isAvailableForDate(LocalDateTime inputDate) {
        LocalDateTime startDate = this.getDateTime().atStartOfDay();
        return  startDate.equals(inputDate);
    }
}
