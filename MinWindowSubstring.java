package practice.org;

import java.util.HashMap;
import java.util.Map;

/*
 * Given a source and target string. Return the size of the smallest window in the source string which contains all of the characters of the target string.
 * 
 * Ex: adobecodebanc, abc -> banc
 * Ex: azjskfzts, sz -> zjs/zts
 * */
public class MinWindowSubstring {

	public static void solution(String source, String target) {
		
		int[] f = new int[26];
		int required=0;
		source = source.replaceAll("\\s+","");
		for(int i=0; i<target.length(); i++) {
			if(f[target.charAt(i)-'a'] == 0) {
				required++;
			}
			f[target.charAt(i)-'a']++;
		}
		
		int l=0, r=0,win=0,formed=0, end=0, min=Integer.MAX_VALUE, start=0;
		
		while(r < source.length()) {
			f[source.charAt(r)-'a']--;
			if(f[source.charAt(r)-'a']==0) {
				formed++;
			} 
			while(l<r && formed == required) {
				win = r-l;
				if(win < min) {
					min=win;
					start=l;
					end=r;
				}
				f[source.charAt(l)-'a']++;
				if(f[source.charAt(l)-'a'] > 0) {
					formed--;
				}
				
				l++;
			}
			r++;
		}
		
		System.out.println(source+" -> length:"+win+" -> Substring: "+source.substring(start, end+1));
	}
	
	public static void main(String[] args) {
		
		Map<String, String> tests = new HashMap<>();
		tests.put("adobecodebanc", "abc");
		tests.put("timetopractice", "toc");
		tests.put("zoomlazapzo", "oza");
		tests.put("this is a test string", "tist");
		tests.put("geeksforgeeks", "ork");
		tests.entrySet().forEach(entry -> solution(entry.getKey(), entry.getValue()));
	}
}
