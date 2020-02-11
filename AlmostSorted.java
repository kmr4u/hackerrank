package practice.org;

public class AlmostSorted {

	public static String solution(int[] A) {/*
		
		int l=0, r=0;
		int firstPeak=Integer.MAX_VALUE, lastValley = Integer.MIN_VALUE;
		int p=0, v=0;
		if(A[0]>A[1]) {
			firstPeak=A[0];
			p++;
		}
		for(int i=1; i<A.length-1; i++) {
			if(A[i-1]<A[i] && A[i+1]<A[i]) {
				p++;
				if(firstPeak == Integer.MAX_VALUE && p == 1) {
					firstPeak = A[i];
					l=i;
				}
			}else if(A[i-1]>A[i] && A[i+1] > A[i]) {
				v++;
				if(lastValley == Integer.MIN_VALUE) {
					lastValley = A[i];
					r=i;
				}
			}
		}
		
		if(A[A.length-1] < A[A.length-2]) {
			lastValley = A[A.length-1];
			r = A.length-1;
			v++;
		}
		
		if(p == 0 && v == 0) return "yes";
		if(p == v) {
			if (p == 1) {
				if ((r - l) > 1)
					return "yes reverse " + (l+1) + " " + (r+1);
				else
					return "yes swap " + (l+1) + " " + (r+1);
			}else {
				return "yes swap " + (l+1) + " " + (r+1);
			}
		}
		return "no";
	*/
		int l = 0, N = A.length;
	    int r = N - 1;
	    
	    //Check for out of place index from the left
	    while(l < r && A[l] <= A[l+1]){
	      ++l;
	    }
	    
	    //Check if array already sorted
	    if(l == r){
	      return "yes";
	    }
	    
	    //Check for out of place index from the right
	    while(r > l && A[r] >= A[r-1]){
	      --r;
	    }
	    
	    //Check if swapping or reversing would NOT sort the array
	    if((l > 0 && A[r] < A[l-1]) || (r < N-1 && A[l] > A[r+1])){
	      return "no";
	    }
	        
	    //Check if we're dealing with a reversal
	    int m;
	    for(m = l+1; m < r && A[m] >= A[m+1]; ++m){}
	    if(m == r){
	      return "yes\n" + ((r-l < 2) ? "swap " : "reverse ") + (l+1) + " " + (r+1);
	    }
	    
	    //Check if we're NOT dealing with a swap
	    if(m-l > 1 || A[l] < A[r-1] || A[r] > A[l+1]){
	      return "no";
	    }
	    
	    //Check if we're dealing with a swap
	    for(int k = r-1; m < k && A[m] <= A[m+1]; ++m){}
	    return (r-m > 1) ? "no" : "yes\nswap " + (l+1) + " " + (r+1);
	}
	
	public static void main(String[] args) {
		//int[] A = new int[] {1, 5, 4, 3, 2, 6}; --> Yes, reverse 2 5
		int[] A = new int[] {3, 1, 2}; //--> No
		//int[] A = new int[] {1, 6, 2, 4, 3, 5, 7}; --> No
		//int[] A = new int[] {1, 5, 3, 6, 2}; --> No
		//int[] A = new int[] {1, 8, 7, 11, 14, 10, 17}; --> No
		//int[] A = new int[] {43, 65, 1, 98, 99, 101};
		//int[] A = new int[] {1, 4, 3, 2, 5}; --> Yes, reverse 2 4
		//int[] A = new int[] {3, 2, 1, 4, 5}; --> yes reverse 1 3
		//int[] A = new int[] {1, 2, 5, 4, 3}; //yes reverse 3 5
		System.out.println(solution(A));
	}
}
