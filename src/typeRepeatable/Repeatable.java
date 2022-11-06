package typeRepeatable;

import java.time.LocalDateTime;


public interface Repeatable {
    boolean isAvailableForDate(LocalDateTime inputDat);

}
