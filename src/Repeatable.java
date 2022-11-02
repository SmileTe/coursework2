import java.time.LocalDateTime;
import java.util.Map;

public interface Repeatable {
boolean nextDateRepeatable(LocalDateTime date);

boolean nextDateRepeatableForDaily(LocalDateTime date);

boolean nextDateRepeatableForWeekly(LocalDateTime date);

boolean nextDateRepeatableForMonthly(LocalDateTime date);

boolean nextDateRepeatableForAnnual(LocalDateTime date);
}
