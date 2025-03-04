package test;

import streams.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TestController {

    public static void main(String[] args) {
        Arrays.stream(getFindElementStartWith1()).forEach((e -> System.out.println("OUTPUT: " +e)));
    }

    private static int[] getFindElementStartWith1(){
        int[] inputArr = {12, 14, 23, 3, 45, 45, 6, 1, 0};
        return Arrays.stream(inputArr)
                .filter( e -> String.valueOf(e).startsWith("1"))
                .sorted()
                .toArray();
    }

}
