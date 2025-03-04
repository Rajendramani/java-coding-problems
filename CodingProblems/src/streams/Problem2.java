package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
List<Integer> உடன் ஒரே எண்களை (even numbers) மட்டும் filter செய்து,
அதை sorted செய்து, ஒவ்வொன்றுக்கும் 2 மடங்கு (double) செய்ய வேண்டும்
Input: [5, 2, 8, 3, 10, 7]
Output: [4, 16, 20]
 */
public class Problem2 {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(5, 2, 8, 3, 10, 7);

        List<Integer> results = numbers.stream()
                .filter(e -> e % 2 == 0) //ஒரு ஒரு element ஆக எடுத்தது அதை 2 ஆல் வகுத்தால் மீதி 0 கிடைக்கும் எண் இரட்டைபடை(even number) எண்
                .sorted()//கிடைக்கக்கூடிய இரட்டை படை array வை வரிசை படுத்த(sort) வேண்டும்
                .map(n -> n * 2)//பின் மீண்டும் ஒரு ஒரு எண் ஆக எடுத்தது அதை இரண்டால் பெருக்க வேண்டும்.
                .collect(Collectors.toList()); //பின் அதை ஒரு List ஆக மாற்ற வேண்டும்

        results.forEach((e) -> System.out.println(e));

    }
}
