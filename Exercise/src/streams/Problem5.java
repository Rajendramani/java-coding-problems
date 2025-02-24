package streams;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
Program to identify digits starting with 1 using the Stream API (sort them in asc)..
I/p: [22,45,89,18, 17, 9, 77, 88, 1]
OP: 1, 17, 18
 */
public class Problem5 {
    public static void main(String[] args) {
        int[] inputArray = {22, 45, 89, 18, 17, 9, 77, 88, 1};
       Arrays.stream(findStartWith1AccendingOrder(inputArray)).forEach((e -> System.out.println("AccendingOrder Output: " + e)));
       Arrays.stream(findStartWith1DescendingOrder(inputArray)).forEach((e -> System.out.println("DescendingOrder Output: " + e)));

    }

    private static int[] findStartWith1AccendingOrder(int[] inputArray){
        return Arrays.stream(inputArray)
                .filter( e -> String.valueOf(e).startsWith("1"))
                .sorted()
                .toArray();
    }

    private static int[] findStartWith1DescendingOrder(int[] inputArray){
        return Arrays.stream(inputArray)
                .filter( e -> String.valueOf(e).startsWith("1"))
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
