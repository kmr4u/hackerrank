package practice.org;

//https://www.cs.bham.ac.uk/~mdr/teaching/modules04/java2/TilesSolvability.html

/*
 * Larry has been given a permutation of a sequence of natural numbers incrementing from  1 as an array. He must determine whether the array can be sorted using the following operation any number of times:

Choose any 3 consecutive indices and rotate their elements in such a way that ABC -> BCA -> CAB -> ABC.
For example, if :

A				rotate 
[1,6,5,2,4,3]	[6,5,2]
[1,5,2,6,4,3]	[5,2,6]
[1,2,6,5,4,3]	[5,4,3]
[1,2,6,3,5,4]	[6,3,5]
[1,2,3,5,6,4]	[5,6,4]
[1,2,3,4,5,6]

YES
On a new line for each test case, print YES if  can be fully sorted. Otherwise, print NO.
 * */
public class LarrysArray {

	public static String solution(int[] A) {
		int inversions = 0;
		
		for(int i=0; i<A.length-1; i++) {
			for(int j=i+1; j<A.length; j++) {
				if(A[i] > A[j]) inversions++;
			}
		}
		//If the grid width is odd, then the number of inversions in a solvable situation is even.
		return inversions%2 == 0? "YES": "NO";
	}
}
