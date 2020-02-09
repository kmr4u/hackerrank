package practice.org;

import java.util.HashSet;
import java.util.Set;

/*
 * We define P to be a permutation of the first  natural numbers in the range [1,n]. Let pos[i] denote the value at position i in permutation P using 1-based indexing.

P is considered to be an absolute permutation if |pos[i] - i| = k holds true for every i.

Given n and k, print the lexicographically smallest absolute permutation P. If no absolute permutation exists, print -1.

For example, let n=4 giving us an array pos[1,2,3,4]. If we use 1 based indexing, create a permutation where every |pos[i] - i| = k. If k=2 , we could rearrange them to [3,4,1,2].

input1: n=2, k=1
output1: 2 1
input2: n=3, k=0
output2: 1 2 3
input3: n=3, k=2
output3: -1
 * */

public class AbsolutePermutation {

	static int[] absolutePermutation(int n, int k) {

        int res[] = new int[n];
        Set<Integer> occured = new HashSet<Integer>();
        if(k == 0){
            for(int i=0; i<n; i++){
                res[i] = i+1;
            }
            return res;
        }
        for(int i=1; i<=n; i++){
        	if(i-k <= 0) {
        		if(i+k <= n && occured.add(i+k)) {
        			res[i-1] = i+k;
        		}else {
        			return new int[] {-1};
        		}
        	}else if(occured.add(i-k)) {
        		res[i-1] = i-k;
        	}else {
        		if(i+k > n  || occured.contains(i+k)) return new int[] {-1};
        		else {
        			res[i-1] = i+k;
        			occured.add(i+k);
        		}
        	}
        }

        return res;
    }
	
	public static void main(String[] args) {
		
		//int[] res = absolutePermutation(10, 5);
		//int[] res = absolutePermutation(10, 9);
		//int[] res = absolutePermutation(10, 3);
		int[] res = absolutePermutation(3, 2);
		for(int i: res) {
			System.out.print(i+" ");
		}
		//1 2 3 4 5 6 7 8 9 10
		//Expected: 2 1 4 3 6 5 8 7 10 9
	}

}
