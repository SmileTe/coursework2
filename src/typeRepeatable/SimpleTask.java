package typeRepeatable;


import java.time.LocalDateTime;

public class SimpleTask extends Task {

    public SimpleTask(String title, String description, TypeTask typeTask) {
        super(title, description, typeTask);
    }

    @Override
    public boolean isAvailableForDate(LocalDateTime inputDat) {
        return false;
    }
}
