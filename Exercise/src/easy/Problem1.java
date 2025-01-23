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
