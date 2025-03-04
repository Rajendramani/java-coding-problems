package streams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
இரண்டு கீழ காணும் sorting ஐ பயன்படுத்த வேண்டும்
1. வயது வாரியாக
2. சம்பள வாரியாக
3. இரண்டாவது அதிக சம்பளம் பெரும் employee
 */
public class Problem6 {
    public static void main(String[] args) {
        List<Employee> employeeList = Employee.getEmployeeList().stream()
                .sorted(Comparator.comparingDouble(Employee::getAge).
                        thenComparing(Employee::getSalary))
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        l -> l.stream()
                                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                                .skip(1)
                                .collect(Collectors.toList())));


    employeeList.forEach((e -> System.out.println("Empoyee: " + e.toString())));
    }
}
