package practice.org;

public class AppendAndDelete {
	
	static String appendAndDelete(String s, String t, int k) {

        if(s.equals(t)){
            if(k%2 == 0 || k >= 2*s.length()) return "Yes";
        }
        int firstSplit = -1;
        int n = Math.min(s.length(), t.length());
        int i=0;
        for(i=0; i<n; i++){
            if(s.charAt(i) != t.charAt(i)){
                firstSplit = i;
                break;
            }
        }
        int reminder = 0;
        if(i==n && firstSplit == -1){
            reminder = Math.max(s.length(), t.length()) - i;
            if(k >= reminder && (k-reminder)%2 == 0) return "Yes";
            else if(k >= s.length()+t.length()) return "Yes";
        }else{
            reminder = (s.length() - firstSplit) + (t.length() - firstSplit);
            if(k >= reminder) return "Yes";
        }

        return "No";
    }
	
	public static void main(String[] args) {
		System.out.println(appendAndDelete("aaa", "a", 5));
	}

}
