package streams;

import lombok.*;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Employee {
    private int id;
    private String name;
    private String dept;
    private double salary;
    private int age;
    private String nationality;

    public Employee(int id, String name, String dept, double salary, int age, String nationality) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        this.age = age;
        this.nationality = nationality;
    }


    public static List<Employee> getEmployeeList() {
        // Create a list of employees
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "HR", 50000, 27, "Indian"),
                new Employee(2, "Bob", "IT", 60000, 20, "USA"),
                new Employee(3, "Charlie", "HR", 55000, 27, "UAE"),
                new Employee(4, "David", "IT", 70000, 30, "Indian"),
                new Employee(5, "Eve", "Finance", 65000, 38, "UK"),
                new Employee(5, "MANI", "HR", 65000, 38, "UK"),
                new Employee(7, "AMANI", "Finance", 90000, 31, "Indian"),
                new Employee(8, "PMANI", "IT", 95000, 29, "USA"),
                new Employee(9, "CMANI", "HR", 75000, 36, "USA")
        );
        return employees;
    }
}
