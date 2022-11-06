import typeRepeatable.*;

import java.text.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
TaskService taskService = new TaskService();
        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            taskService.inputTask(scanner);
                            break;
                        case 2:
                            taskService.deleteTask(scanner);
                            break;
                        case 3:
                            getTaskByDay(taskService,scanner);
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

    private static void getTaskByDay(TaskService taskService, Scanner scanner){

        System.out.println("Введите дату в формате (день/месяц/год)");
        String tDate = scanner.next();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        // конвертируем String в LocalDate
        LocalDateTime localDate = LocalDate.parse(tDate, formatter).atStartOfDay();

        Collection<Task> listTasks =taskService.getListTask(localDate);
        for (Task task:listTasks) {
            System.out.println(task);
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