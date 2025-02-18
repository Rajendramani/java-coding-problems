package streams;

import java.util.*;
import java.util.stream.Collectors;

/*
 ஒவ்வொரு துறையிலும் (department-wise) அதிக சம்பளம் பெறுபவர் யார் என்பதை கண்டுபிடிக்க வேண்டும்
 Output:
Name:Mani, Department:HR, Salary:105000.0
Name:ASD, Department:IT, Salary:130000.0
Name:XYS, Department:Finance, Salary:65000.0
 */
public class Problem3 {
    public static void main(String[] args) {


        Map<String, Employee> records = Employee.getEmployeeList().stream()
                .collect(Collectors.groupingBy(Employee::getDept,
                        Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Employee::getSalary)), Optional::get)));

        records.forEach((k,v) -> System.out.println("Dept: " + k + " Employee:" + v.toString()));
    }
}
