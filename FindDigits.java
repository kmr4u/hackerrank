package practice.org;

/*
 * Program to print the number of digits in a number that can devide n. Each repeated occurance of a digit is counted as multiple. 
 * Ex: input 1012 -> output: 3 (1 can devide 1012, 1 can devide 1012, 2 can devide 1012)
 * input: 5432 -> output: 1 (only 2 can devide 5432)
 * */
public class FindDigits {

	static int findDigits(int n) {
        int count=0;
        int reminder = n;
        while(reminder/10 != 0){
            int d = reminder%10;
            if(d != 0 && n%d == 0) count++;
            reminder = reminder/10;
        }
        if(n%reminder == 0) count++;

        return count;
    }
	
	public static void main(String[] args) {
		System.out.println(findDigits(1012));
	}
}
