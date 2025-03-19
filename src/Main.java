//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
import java.time.LocalDate;
public class Main {
    private static Worker[] workers = new Worker[5];
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        workers[0] = new Worker("Пышницкий К.М.", "Старший преподаватель", LocalDate.of(1991,9,1), 80000);
        workers[1] = new Worker("Бурмистров Д.С.", "Техник", LocalDate.of(2024,9,1), 17000);
        workers[2] = new Worker("Рябкова А.Л.", "Староста", LocalDate.of(2022,9,1), 33000);
        workers[3] = new Worker("Ершов Е.В.", "Глава кафедры", LocalDate.of(1987,9,1), 135000);
        workers[4] = new Worker("Гонтарева И.Б.", "Доцент", LocalDate.of(1990,9,1), 75000);
        Choose();
    }
        public static void Choose() {
            System.out.println("Здравствуйте, выберите, пожалуйста, запрос для информации, которую вы бы хотели получить: ");
            System.out.println("1. Список работников, стаж которых превосходит заданное число лет: ");
            System.out.println("2. Список работников, зарплата которых превосходит заданную: ");
            System.out.println("3. Список работников с заданной должностью: ");
            System.out.println("4. Полный список работников");
            if (!scanner.hasNextInt()) {
                System.out.println("Неправильный ввод");
                scanner.next();
                Choose();
                return;
            }
            int choice = scanner.nextInt();
            if (choice <1 || choice >4) {
                System.out.println("Вы ввели неправильную цифру. Попробуйте ещё раз");
                Choose();
                return;
            }
        switch (choice) {
            case 1:
                System.out.println("Введите минимальный стаж (в годах):");
                int givenExpirienceYears = scanner.nextInt();
                int givenExpirienceMonths = givenExpirienceYears * 12;
                System.out.println("\nРаботники со стажем более " + givenExpirienceYears + " лет:");
                for (Worker worker : workers) {
                    if (worker.getTotalMonthExperience() >= givenExpirienceMonths) {
                        worker.show();
                    }
                }
                break;
            case 2:
                System.out.println("Введите минимальую зарплату: ");
                int givenSalary = scanner.nextInt();
                System.out.println("\nРаботники с зарплатой более " + givenSalary + ":");
                for (Worker worker : workers) {
                    if (worker.getSalary() > givenSalary) {
                        worker.show();
                    }
                }
                break;
            case 3:
                System.out.println("Введите должность для поиска: ");
                scanner.nextLine();
                String givenPosition = scanner.nextLine();
                System.out.println("\nРаботники с должностью " + givenPosition + ":");
                for (Worker worker : workers) {
                    if (worker.getPosition().equalsIgnoreCase(givenPosition)) {
                        worker.show();
                    }
                }
                break;
            case 4:
                System.out.println("\nПолный список работников:");
                for (Worker worker : workers) {
                    worker.show();
                }
                break;
        }
            Choose();
    }
}