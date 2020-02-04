package practice.org;

import java.util.Arrays;
import java.util.List;

/*
 * Given a set of distinct integers, print the size of a maximal subset of  where the sum of any  numbers in  is not evenly divisible by .

For example, the array  and . One of the arrays that can be created is . Another is . After testing all permutations, the maximum length solution array has  elements.

Function Description

Complete the nonDivisibleSubset function in the editor below. It should return an integer representing the length of the longest subset of  meeting the criteria.

nonDivisibleSubset has the following parameter(s):

S: an array of integers
k: an integer
Input Format

The first line contains  space-separated integers,  and , the number of values in  and the non factor.
The second line contains  space-separated integers describing , the unique values of the set.

Constraints

All of the given numbers are distinct.
Output Format

Print the size of the largest possible subset ().

Sample Input

4 3
1 7 2 4
Sample Output

3
 
 */

public class NonDevisibleSubset {
	
	public static int nonDivisibleSubset(int k, List<Integer> s) {
	    /*
	     * 1. If the sum of 2 numbers is divisible by k, their modulo-k will be i, k-i
	     * 2. Store the frequency of modulo-k of the numbers of the given array in a new array
	     * 3. Iterate through the frequency array and pick the max of f[i] or f[k-i]
	     * 4. Special handling for i=0 and i=k/2 as max of 1 number have to be picked for 0 and k/2 reminders
	     */
		int[] frequency = new int[k];
	    Arrays.fill(frequency, 0);
	    for(int i=0; i<s.size(); i++){
	        frequency[s.get(i)%k]++;
	    }

	    if(k%2 == 0){
	        frequency[k/2] = Math.min(frequency[k/2], 1);
	    }    
	    int res = Math.min(frequency[0], 1);

	    for(int i=1; i<=k/2; i++){
	        res += Math.max(frequency[i], frequency[k-i]);
	    }

	    return res;
	    }

}
