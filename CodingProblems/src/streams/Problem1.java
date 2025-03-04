package streams;

import lombok.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
Department வாரியாக மொத்தம் எவ்வளவு சம்பளம் போட படுகிறது என்பதை அறியவும்
Output :
Department:HR,Total Salary:105000.0
Department:IT,Total Salary:130000.0
Department:Finance,Total Salary:65000.0
 */
public class Problem1 {
    public static void main(String[] args) {

        Map<String, Double> records = Employee.getEmployeeList().stream()
                .collect(Collectors.groupingBy(Employee::getDept, //ஒரு ஒரு Department ஐயும்  group பண்ணுதல்
                        Collectors.summingDouble(Employee::getSalary))); // ஒரு ஒரு Department க்கான சம்பளத்தை கூட்டுதல்

        records.forEach((dept, totalSalary) ->
                System.out.println("Department: " + dept + " TotalSalary: " + totalSalary));


    }
}
