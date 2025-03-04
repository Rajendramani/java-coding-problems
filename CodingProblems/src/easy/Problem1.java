package easy;

/*
 * Find the sum of all even numbers in an array. 
 */
public class Problem1 {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9};	
		System.out.println("Sum of arry:" + findSumOfAnEvenArray(arr));
	}

	public static int findSumOfAnEvenArray(int[] arr) {
		int sum = 0;
		for(int i : arr) {
			if(i % 2 == 0) {
				sum += i; //sum = sum + i
			}
		}
		return sum;
	}
}
/*
விளக்கம் :
1.  Array வில் உள்ள ஒரு ஒரு element ஐயும் for loop மூலம் எடுக்கவேண்டும்
2.  அப்படி எடுக்கும் போது அந்த element ஐ 2 ஆல் வகுக்கவேண்டும் (mod)
3.  ஆப்போது அதனுடைய மீதி (Remainder) 0 வந்தால் அதனை,
 	ஏற்கனவே உள்ள int உடன் கூட்டி கொண்டே போக வேண்டும்
4. அதுதான் sum of an array in even numbers.
 */