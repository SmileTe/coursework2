import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public class Task implements Repeatable {
private String title;
private String description;
private TypeTask typeTask;
private LocalDateTime dateTime;
private TypeRepeatable typeRepeatable;
private Integer id;
public int count;

public enum TypeTask{
    PRIVATE("Личная"),
    WORK("Рабочая");
    private String title;

    TypeTask(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

    public Task(String title, String description, TypeTask typeTask, TypeRepeatable typeRepeatable) {

        try {
            check(title, description, typeTask, typeRepeatable);
        } catch (WrongDataException e) {
            System.out.println("Заполните карточку задачи полностью");
        }

        setTitle(title);
        setDescription(description);
        setTypeTask(typeTask);
        setTypeRepeatable(typeRepeatable);
        this.dateTime = LocalDateTime.now();
        this.id = count;
        count++;
    }

    public static void check(String title, String description, TypeTask typeTask, TypeRepeatable typeRepeatable) throws WrongDataException {
        if (title == null || title.isEmpty() || title.isBlank()) {
            throw new WrongDataException();
        }
        if (description == null || description.isEmpty() || description.isBlank()) {
            throw new WrongDataException();
        }
        if (typeTask == null) {
            throw new WrongDataException();
        }
        if (typeRepeatable == null) {
            throw new WrongDataException();
        }
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTypeTask(TypeTask typeTask) {
        this.typeTask = typeTask;
    }

    public void setTypeRepeatable(TypeRepeatable typeRepeatable) {
        this.typeRepeatable = typeRepeatable;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public boolean nextDateRepeatable(LocalDateTime date) {
        if(date.getYear()<dateTime.getYear()){
            return false;
        }
        if (typeRepeatable == TypeRepeatable.DAILY) {
            return nextDateRepeatableForDaily(date);
        } else if (typeRepeatable == TypeRepeatable.WEEKLY) {
            return nextDateRepeatableForWeekly(date);
        } else if (typeRepeatable == TypeRepeatable.MONTHLY) {
            return nextDateRepeatableForMonthly(date);
        } else if (typeRepeatable == TypeRepeatable.ANNUAL) {
            return nextDateRepeatableForAnnual(date);
        }
        return false;
    }



    @Override
    public boolean nextDateRepeatableForDaily (LocalDateTime date) {
    //ежедневная задача выведется для любой даты
        return true;
    }

    @Override
    public boolean nextDateRepeatableForWeekly( LocalDateTime date) {
    //получить дни недели для обеих задач и сравнить
        return date.getDayOfWeek() == dateTime.getDayOfWeek();
    }

    @Override
    public boolean nextDateRepeatableForMonthly( LocalDateTime date) {
        return date.getDayOfMonth()==date.getDayOfMonth();
    }

    @Override
    public boolean nextDateRepeatableForAnnual(LocalDateTime date) {
        return date.getDayOfMonth()==dateTime.getDayOfMonth()&&date.getMonth() == dateTime.getMonth();
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", typeTask=" + typeTask +
                ", dateTime=" + dateTime +
                ", id=" + id +

                '}';
    }
}
