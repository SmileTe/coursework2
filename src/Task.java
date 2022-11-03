import typeRepeatable.Repeatable_;
import typeRepeatable.SimpleTask;

import java.time.LocalDateTime;
import java.util.Objects;

public class Task  {
private String title;
private String description;
private TypeTask typeTask;
private LocalDateTime dateTime;
private SimpleTask typeRepeatable;
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

    public Task(String title, String description, TypeTask typeTask, SimpleTask typeRepeatable) {

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

    public static void check(String title, String description, TypeTask typeTask, SimpleTask typeRepeatable) throws WrongDataException {
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

    public void setTypeRepeatable(SimpleTask typeRepeatable) {
        this.typeRepeatable = typeRepeatable;
    }

    public Integer getId() {
        return id;
    }

    public SimpleTask getTypeRepeatable() {
        return typeRepeatable;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

     @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(title, task.title) && Objects.equals(id, task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, id);
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
