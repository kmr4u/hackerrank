package practice.org;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/*
 * Consider an array of n distinct integers. George can swap any two elements of the array any number of times. An array is beautiful if the sum of |arr[i] - arr[i-1]| among 0<i<n is minimal.

Given the array , determine and return the minimum number of swaps that should be performed in order to make the array beautiful.

For example, [7, 15, 12, 3]. One minimal array is [3, 7, 12, 15]. To get there, George performed the following swaps:

Swap      Result
      [7, 15, 12, 3]
3 7   [3, 15, 12, 7]
7 15  [3, 7, 12, 15]
It took  swaps to make the array beautiful. This is minimal among the choice of beautiful arrays possible.
 * */
public class LilysHomework {
	
	//sum of the absolute differences of adjacent elements is minimal when the array is sorted either ascending or descending
	//Calculate the number of swaps required to sort the array ascending and descending and return the minimum of them
	private static int lilysHomework(int[] arr) {
        Map<Integer, Integer> indexes = new HashMap<>();
        int[] sorted = new int[arr.length];
        int[] copy = new int[arr.length];

        for(int i=0; i<arr.length; i++){
            sorted[i] = arr[i];
            copy[i] = arr[i];
            indexes.put(arr[i], i);
        }

        Arrays.sort(sorted);
        int swapA = 0;
        for(int i=0; i<arr.length; i++){
            if(sorted[i] != arr[i]){ //mismatch
                int tempIndex = indexes.get(sorted[i]); //index of the sorted element in the original array
                indexes.put(sorted[i], i);
                indexes.put(arr[i], tempIndex);
                swapA++;
                
                int tmp = arr[i];
                arr[i] = arr[tempIndex];
                arr[tempIndex] = tmp;
            } 
        }
        
        //reset the map
        for(int i=0; i<arr.length; i++){
        	indexes.put(copy[i], i);
        }
        int swapD = 0;
        for(int i=arr.length-1, j=0; i>=0 && j<arr.length; i--, j++){
            if(sorted[i] != copy[j]){ //mismatch
                int tempIndex = indexes.get(sorted[i]); //index of the sorted element in the original array
                indexes.put(sorted[i], j);
                indexes.put(copy[j], tempIndex);
                swapD++;
                
                int tmp = copy[j];
                copy[j] = copy[tempIndex];
                copy[tempIndex] = tmp;
            } 
        }
        return Math.min(swapA, swapD);

    }
	
	public static void main(String[] args) {
		int[] A = new int[] {7, 15, 12, 3};
		System.out.println(lilysHomework(A));
	}
}
