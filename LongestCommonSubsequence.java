package practice.org;

public class LongestCommonSubsequence {
	static int recursiveLCS(String s1, String s2) {

        if(s1.length() == 0 || s2.length() == 0){
            return 0;
        }
        if(s1.charAt(s1.length()-1) == s2.charAt(s2.length()-1)){
            return 1+ recursiveLCS(s1.substring(0, s1.length()-1), s2.substring(0, s2.length()-1));
        }else{
            return Math.max(recursiveLCS(s1, s2.substring(0, s2.length()-1)), recursiveLCS(s1.substring(0, s1.length()-1), s2));
        }
        //return 0;
    }
	
	static int lcs(String s1, String s2) {
		int m=s1.length(), n=s2.length();
		
		int[][] A = new int[m+1][n+1];
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(s1.charAt(i) == s2.charAt(j)) {
					A[i+1][j+1] = 1 + A[i][j];
				}else {
					A[i+1][j+1] = Math.max(A[i+1][j], A[i][j+1]);
				}
			}
		}
		
		return A[m][n];
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(lcs("SHINCHAN","NOHARAAA"));
		System.out.println(lcs("ABCDEF","FBDAMN"));
		System.out.println(lcs("HARRY","SALLY"));
	}
}
