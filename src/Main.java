import java.text.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
     /* - для тестирования
    public static void main(String[] args) {

        Map<Integer, Task> listTask = new HashMap<>();
        Task task1 = new Task("mm", "jgbcfybt", Task.TypeTask.PRIVATE, TypeRepeatable.DAILY);
        listTask.put(task1.getId(), task1);
    }
      */

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
                            // todo: обрабатываем пункт меню 2
                            //удалить задачу
                            deleteTask(scanner, listTask);
                            break;
                        case 3:
                            // todo: обрабатываем пункт меню 3
                            //получить день
                            //получить задачи на указанный день
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

        List<TypeRepeatable> listTypeRepeatable = new ArrayList<>();
        listTypeRepeatable.add(TypeRepeatable.SINGLE);
        listTypeRepeatable.add(TypeRepeatable.DAILY);
        listTypeRepeatable.add(TypeRepeatable.WEEKLY);
        listTypeRepeatable.add(TypeRepeatable.MONTHLY);
        listTypeRepeatable.add(TypeRepeatable.ANNUAL);

        System.out.print("Выберите тип повторения: 1-однократная 2-ежедневная 3-еженедельная 4-ежемесячная 5-ежегодная: ");
        int taskTypeRepeatable = scanner.nextInt();

        Task newTask = new Task(taskName, taskDescription, listTypeTask.get(taskTypeTask-1), listTypeRepeatable.get(taskTypeRepeatable-1));

        listTasks.put(newTask.getId(), newTask);
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

    private static void getListTask(Scanner scanner, Map<Integer,Task> listTasks)  {
        //получить день
        //получить задачи на указанный день

        System.out.println("Введите дату в формате (день/месяц/год)");
        String tDate = scanner.next();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        // конвертируем String в LocalDate
        LocalDateTime localDate = LocalDate.parse(tDate,formatter).atStartOfDay();

        for (Map.Entry<Integer, Task> entry : listTasks.entrySet()) {
            Task task = entry.getValue();
           boolean isThere =  task.nextDateRepeatable(localDate);
           if (isThere){
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