package practice.org;

import java.util.Arrays;
import java.util.List;

/*
 * You are working at the cash counter at a fun-fair, and you have different types of coins available to you in infinite quantities. The value of each coin is already given. Can you determine the number of ways of making change for a particular number of units using the given types of coins?

For example, if you have 4 types of coins, and the value of each type is given as 8,3,1,2 respectively, you can make change for 3 units in three ways: {1,1,1},{1,2} and {3}.

Function Description

Complete the getWays function in the editor below. It must return an integer denoting the number of ways to make change.

getWays has the following parameter(s):

n: an integer, the amount to make change for
c: an array of integers representing available denominations

input:
4 3
1 2 3

output: 4
Explanation: U can make change for 4 from given 3 coins in 4 ways as: {1,1,1,1}, {1, 1, 2}, {1, 3}, {2, 2} 

input:
10 4
2 5 3 6

output: 5
Explanation: {2,2,2,2,2}, {2, 2, 6}, {2, 2, 3, 3}, {2, 3 5}, {5, 5}
 * 
 * */

public class TheCoinChangeProblem {

	
	public static long getWays(int n, List<Long> c) {
	    // Write your code here
	    long[][] ways = new long[c.size()+1][n+1];

	    for(int i=0; i<= c.size(); i++){
	        ways[i][0]=1;
	    }

	    for(int i=1; i<=c.size(); i++){
	        for(int j=1; j<=n; j++){ 
	            if(j-c.get(i-1) >= 0){
	                ways[i][j] = ways[i-1][j]+ways[i][(int) (j-c.get(i-1))];
	            }else{
	                ways[i][j] = ways[i-1][j];
	            }
	        }
	    }

	    return ways[c.size()][n];
	 }
	
	public static void main(String[] args) {
		
		List<Long> values = Arrays.asList((long)2, (long)5, (long)3, (long)6);
		System.out.println(getWays(10, values));
	}
}
