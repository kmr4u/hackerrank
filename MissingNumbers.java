package practice.org;

import java.util.ArrayList;
import java.util.List;

/*
 * Numeros the Artist had two lists that were permutations of one another. He was very proud. Unfortunately, while transporting them from one exhibition to another, some numbers were lost out of the first list. Can you find the missing numbers?

As an example, the array with some numbers missing, arr = [7,2,5,3,5,3]. The original array of numbers brr=[7,2,5,4,6,3,5,3]. The numbers missing are [4,6].

Notes

If a number occurs multiple times in the lists, you must ensure that the frequency of that number in both lists is the same. If that is not the case, then it is also a missing number.
You have to print all the missing numbers in ascending order.
Print each missing number once, even if it is missing multiple times.
The difference between maximum and minimum number in the second list is less than or equal to 100.

Output the missing numbers in ascending order.
 * */

public class MissingNumbers {
	static int[] missingNumbers(int[] arr, int[] brr) {

        int min = Integer.MAX_VALUE;
        List<Integer> res = new ArrayList<>();
        for(int i: brr){
            if(i < min) min = i;
        }

        int[] frequency = new int[100];
        for(int i=0; i<brr.length; i++){
            frequency[brr[i]-min]++;
        }
        for(int i=0; i<arr.length; i++){
            frequency[arr[i]-min]--;
        }
        for(int i=0; i<frequency.length; i++){
            if(frequency[i] >= 1) 
            	res.add(min+i);
        }
        int[] missing = new int[res.size()];
        for(int i=0; i<res.size(); i++){
            missing[i] = res.get(i);
        }

        return missing;
    }
	
	public static void main(String[] args) {
		
		int[] arr = new int[] {203, 204, 205, 206, 207, 208, 203, 204, 205, 206};
		int[] brr = new int[] {203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204};
		
		for(int i: missingNumbers(arr, brr)) {
			System.out.println(i);
		}
		
	}
}
