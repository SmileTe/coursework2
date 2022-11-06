import typeRepeatable.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TaskService {
    private static Map<Integer, Task> listTask = new HashMap<>();

    public static void inputTask(Scanner scanner) {

        System.out.print("Введите название задачи: ");
        String taskName = scanner.next();

        System.out.print("Введите описание задачи: ");
        String taskDescription = scanner.next();

        System.out.print("Введите дату задачи в формате dd.mm.yyyy: ");
        String date = scanner.next();
        LocalDate dateTask= LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        System.out.print("Введите время задачи в формате HH:mm: ");
        String time = scanner.next();
        LocalTime timeTask= LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));
        LocalDateTime dateTimeTask = LocalDateTime.of(dateTask,timeTask);

        List<Task.TypeTask> listTypeTask = new ArrayList<>();
        listTypeTask.add(Task.TypeTask.WORK);
        listTypeTask.add(Task.TypeTask.PRIVATE);

        //todo можно еще цикл сделать
        System.out.print("Выберите тип задачи: 1-рабочая 2-личная: ");
        int taskTypeTask = scanner.nextInt();

        System.out.print("Выберите тип повторения: 1-однократная 2-ежедневная 3-еженедельная 4-ежемесячная 5-ежегодная: ");
        int taskTypeRepeatable = scanner.nextInt();

        Task.TypeTask typeTask =  listTypeTask.get(taskTypeTask-1);

        switch (taskTypeRepeatable) {
            case 1:
                Task newTask =  new SimpleTask(taskName, taskDescription, typeTask,dateTimeTask);
                listTask.put(newTask.getId(), newTask);
                break;
            case 2:
                Task newTask1 = new TaskDaily(taskName, taskDescription, typeTask,dateTimeTask);
            listTask.put(newTask1.getId(), newTask1);
            break;
            case 3:
                Task newTask2= new TaskWeekly(taskName, taskDescription, typeTask,dateTimeTask);
            listTask.put(newTask2.getId(), newTask2);
            break;
            case 4:
                Task newTask3 = new TaskMonthly(taskName, taskDescription, typeTask,dateTimeTask);
            listTask.put(newTask3.getId(), newTask3);
            break;
            case 5:
                Task newTask4 = new TaskAnnual(taskName, taskDescription, typeTask,dateTimeTask);
            listTask.put(newTask4.getId(), newTask4);
            break;
        }

    }

    public  static void deleteTask(Scanner scanner) {
        System.out.print("Введите id задачи: ");
        Integer taskId = scanner.nextInt();
        if (listTask.containsKey(taskId)) {
            listTask.remove(taskId);
        } else {
            System.out.println("Введено некорректное значение id");
        }
    }

    public Collection<Task> getListTask( LocalDateTime localDate) {
        //получить день
        //получить задачи на указанный день

        List<Task> listTasks = new ArrayList<>();
        for (Map.Entry<Integer, Task> entry : listTask.entrySet()) {
            Task task = entry.getValue();
            boolean isThere = task.isAvailableForDate(localDate);
            if (isThere) {
                listTasks.add(task);
            }

        }
        return  listTasks;
    }
}
