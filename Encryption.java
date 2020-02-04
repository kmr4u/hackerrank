package practice.org;

public class Encryption{
	
	public static void main(String[] args) {
		System.out.println(encrypt("feedthedog"));
	}
	
	static String encrypt(String s){
		
		int l = s.length();
		int m = (int) Math.floor(Math.sqrt(l));
		int n = (int)Math.ceil(Math.sqrt(l));
		if(m*n < l) m = n;
		char[][] arr = new char[m][n];
		int index=0;
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(index >= l) break;
				arr[i][j] = s.charAt(index);
				index++;
			}
		}
		StringBuffer buffer = new StringBuffer();
		for(int j=0; j<n; j++) {
			for(int i=0; i<m; i++) {
				if (arr[i][j] != '\u0000' ) buffer.append(arr[i][j]);
			}
			buffer.append(" ");
		}
		return buffer.toString().trim();
	}
}
