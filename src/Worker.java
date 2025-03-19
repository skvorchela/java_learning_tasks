import java.time.LocalDate;
import java.time.Period;
public class Worker {
    private String surnameMiddleName;
    private String position;
    private LocalDate yearOfAdmission;
    private int salary;
   //Конструктор
    public Worker(String surnameMiddleName, String position, LocalDate yearOfAdmission, int salary) {
            this.surnameMiddleName=surnameMiddleName;
            this.position=position;
            this.yearOfAdmission=yearOfAdmission;
            this.salary=salary;
    }
    public String getSurnameMiddleName() {
        return surnameMiddleName;
    }
    public void setSurnameMiddleName() {
        this.surnameMiddleName = surnameMiddleName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public LocalDate getYearOfAdmission() {
        return yearOfAdmission;
    }

    public void setYearOfAdmission(LocalDate yearOfAdmission) {
        this.yearOfAdmission = yearOfAdmission;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    public int getTotalMonthExperience () {
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(yearOfAdmission, currentDate);
        return period.getYears() * 12 + period.getMonths();
    }
    public String getExperience() {
       LocalDate currentDate=LocalDate.now();
       Period period=Period.between(yearOfAdmission, currentDate);
       return period.getYears() + " лет " + period.getMonths() + " месяцев ";
    }
    public void show() {
        System.out.println("Фамилия и инициалы: "+ surnameMiddleName);
        System.out.println("Должность: "+ position);
        System.out.println("Год устройства: "+ yearOfAdmission);
        System.out.println("Зарплата: "+ salary);
        System.out.println("Стаж: "+ getExperience());
    }

}
