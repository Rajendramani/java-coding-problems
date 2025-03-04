package streams;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
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

        Map<String, Employee> records = Employee.getEmployeeList().stream()
                .collect(Collectors.groupingBy(Employee::getDept))
                .entrySet().stream()
                .map( entry -> {
                    Optional<Employee> secondHighestSalary = entry.getValue().stream()
                            .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                            .skip(1)
                            .findFirst();
                    return secondHighestSalary.map(emp -> Map.entry(entry.getKey(), emp));
                })
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        records.forEach((k,v) -> System.out.println("Dept: "+ k + " - " + "Employee: " +v));

    }
}
