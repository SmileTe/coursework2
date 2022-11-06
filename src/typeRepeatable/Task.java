package typeRepeatable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Task implements Repeatable {
    private String title;
    private String description;
    private TypeTask typeTask;
    private LocalDateTime dateTime;
    private Integer id;
    private static int count;

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

    public Task(String title, String description, TypeTask typeTask, LocalDateTime dateTimeTask) {

        try {
            check(title, description, typeTask);
        } catch (WrongDataException e) {
            System.out.println("Заполните карточку задачи полностью");
        }

        setTitle(title);
        setDescription(description);
        setTypeTask(typeTask);

        this.dateTime = dateTimeTask;
        this.id = count ++;

    }

    public static void check(String title, String description, TypeTask typeTask) throws WrongDataException {
        if (title == null || title.isEmpty() || title.isBlank()) {
            throw new WrongDataException();
        }
        if (description == null || description.isEmpty() || description.isBlank()) {
            throw new WrongDataException();
        }
        if (typeTask == null) {
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

    public Integer getId() {
        return id;
    }


    public LocalDate getDateTime() {
        return dateTime.toLocalDate();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(title, task.title) && Objects.equals(id, task.id);
    }

    @Override
    public boolean isAvailableForDate(LocalDateTime inputDat) {
        return false;
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
