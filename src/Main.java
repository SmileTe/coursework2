import typeRepeatable.*;

import java.text.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
        public static void main(String[] args) {
        Map<Integer, Task> listTask = new HashMap<>();

        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            inputTask(scanner, listTask);
                            break;
                        case 2:
                            break;
                        case 3:
                            getListTask(scanner, listTask);
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
    }

    private static void inputTask(Scanner scanner, Map<Integer,Task> listTasks) {

        System.out.print("Введите название задачи: ");
        String taskName = scanner.next();

        System.out.print("Введите описание задачи: ");
        String taskDescription = scanner.next();

        List<Task.TypeTask> listTypeTask = new ArrayList<>();
        listTypeTask.add(Task.TypeTask.WORK);
        listTypeTask.add(Task.TypeTask.PRIVATE);

        //todo можно еще цикл сделать
        System.out.print("Выберите тип задачи: 1-рабочая 2-личная: ");
        int taskTypeTask = scanner.nextInt();

        System.out.print("Выберите тип повторения: 1-однократная 2-ежедневная 3-еженедельная 4-ежемесячная 5-ежегодная: ");
        int taskTypeRepeatable = scanner.nextInt();

        Task newTask = new Task(taskName, taskDescription, listTypeTask.get(taskTypeTask-1), getTask(taskTypeRepeatable));

        listTasks.put(newTask.getId(), newTask);
    }

    private static SimpleTask getTask(int v) {
        switch (v) {
            case 1:
                return new SimpleTask();
            case 2:
                return new TaskDaily();
            case 3:
                return new TaskWeekly();
            case 4:
                return new TaskMonthly();
            case 5:
                return new TaskAnnual();
        }
        return new SimpleTask();
    }

    private static void deleteTask(Scanner scanner, Map<Integer,Task> listTasks) {
        System.out.print("Введите id задачи: ");
        Integer taskId = scanner.nextInt();
        if (listTasks.containsKey(taskId)) {
            listTasks.remove(taskId);
        } else {
            System.out.println("Введено некорректное значение id");
        }
    }

    private static void getListTask(Scanner scanner, Map<Integer, Task> listTasks) {
        //получить день
        //получить задачи на указанный день

        System.out.println("Введите дату в формате (день/месяц/год)");
        String tDate = scanner.next();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        // конвертируем String в LocalDate
        LocalDateTime localDate = LocalDate.parse(tDate, formatter).atStartOfDay();

        for (Map.Entry<Integer, Task> entry : listTasks.entrySet()) {
            Task task = entry.getValue();
            boolean isThere = task.getTypeRepeatable().nextDate(task.getDateTime(), localDate);
            if (isThere) {
                System.out.println(task);
            }
        }

    }

    private static void printMenu() {
        System.out.println(
                "1. Добавить задачу\n" +
                        "2. Удалить задачу\n" +
                        "3. Получить задачу на указанный день\n" +
                        "0. Выход\n");
    }
}