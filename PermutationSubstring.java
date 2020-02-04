package practice.org;

public class PermutationSubstring {
	private static int[] primes = null;
	private static int[] getFirstTwentySixPrimes() {
		int[] primes = new int[26];
	
		int count=0, max=26;
		primes[count++] = 2;
		
		for(int i=3;;i+=2) {
			boolean isPrime = true;
			for(int j=3; j<=Math.floor(Math.sqrt(i)); j++) {
				if(i%j == 0 && i != j) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) {
				primes[count++] = i;
				if(count == max) {
					break;
				}
			}
		}
		return primes;
	}
	
	public static void main(String[] args) {
		
		primes = getFirstTwentySixPrimes();
		/*for(int i: arr) {
			System.out.print(i+" ");
		}*/
		
		String a = "abbc";
		String b = "cbabadcbbabbcbabaabccbabc";
		
		int smallHash = getSmallHash(a);
		
		System.out.println(smallHash);
		
		/*for(int i=0; i<b.length(); i++) {
			
		}*/
		int left = 0, end=a.length()-1;
		int curHash = getCurHash(left, end, b);
		while(end < b.length()) {
			if(smallHash == curHash) {
				System.out.println(b.substring(left, end));
			}

			curHash /= primes[b.charAt(left) - 'a'];
			curHash *= primes[b.charAt(end) - 'a'];
			left++;
			end++;
			
		}
	}
	
	private static int getSmallHash(String a) {
		int hash = 1;
		
		for(int i=0; i<a.length(); i++) {
			hash *= primes[a.charAt(i) - 'a'];
		}
		
		return hash;
	}
	
	private static int getCurHash(int start, int end, String b) {
		int curHash = 1;
		
		for(int i=start; i<=end; i++) {
			curHash *= primes[b.charAt(i) - 'a'];
		}
		return curHash;
	}
}