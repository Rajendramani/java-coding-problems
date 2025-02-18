package streams;

import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

/*
/*
 ஒவ்வொரு துறையிலும் (department-wise) இரண்டாவது அதிக சம்பளம் பெறுபவர் யார் என்பதை கண்டுபிடிக்க வேண்டும்
 Output:
Name:Mani, Department:HR, Salary:105000.0
Name:ASD, Department:IT, Salary:130000.0
Name:XYS, Department:Finance, Salary:65000.0
 */
public class Problem4 {

    public static void main(String[] args) {
        //Normal approach
        Map<String, Employee> employeeMap = Employee.getEmployeeList().stream()
                .collect(Collectors.groupingBy(Employee::getDept,
                        Collectors.collectingAndThen(Collectors.toList(),
                                list -> {
                                    if (list.size() < 2) return null;
                                    list.sort(Comparator.comparingDouble(Employee::getSalary).reversed());
                                    return list.get(1);
                                })));

        //Best approach
        Map<String, Employee> employeeMap1 = Employee.getEmployeeList().stream()
                .collect(Collectors.groupingBy(Employee::getDept))
                .entrySet().stream()
                        .collect(Collectors.toMap(Map.Entry::getKey,
                                v -> v.getValue().stream()
                                        .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                                        .skip(1)
                                        .findFirst()
                                        .orElse(null)));

        employeeMap1.forEach((k, v) -> System.out.println("Dept: " + k + "- Employee: " + v.toString()));
    }
}
