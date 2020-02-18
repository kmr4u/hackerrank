package practice.org;

import java.util.Map;
import java.util.TreeMap;

public class PatternMatchingKMP {

	public static boolean isPatternFound(String s, String p) {
		
		//prefix-suffix array
		int[] arr = new int[p.length()];
		
		int i=0, j=1;
		while(j<p.length()) {
			if(p.charAt(i) == p.charAt(j)) {
				arr[j] = arr[j-1]+1;
				i++;
				j++;
			}else if(i>0) {
				i=arr[i-1];
			}else {
				j++;
			}
		}
				
		int start = 0;
		for(int m=0; m<s.length(); ) {
			if(s.charAt(m) == p.charAt(start)) {
				m++;
				start++;
				if(start == p.length()) 
					return true;
			}
			else {
				if(start == 0) {
					m++;
				}else {
					start = arr[start-1];
					if(s.charAt(m) != p.charAt(start)) {
						start = 0;
					}
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Map<String, String> tests = new TreeMap<>();
		tests.put("adsgwadsxdsgwadsgz", "dsgwadsgz");
		tests.put("aaaaab", "aaab");
		tests.put("abcbcglx", "bcgl");
		tests.put("abcdef", "def");
		tests.put("computer", "muter");
		tests.put("stringmatchingmat", "ingmat");
		tests.put("videobox", "videobox");
		tests.entrySet().forEach(e -> System.out.println(isPatternFound(e.getKey(), e.getValue())));
		
	}
}
