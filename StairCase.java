package practice.org;

public class StairCase {

	 static void staircase(int n) {

         for(int i=0; i<n; i++){
             String line = "";
             for(int j=0; j<n; j++){
                 if(j>= (n-1)-i){
                     line = line+"#";
                 }
                 else{
                     line = " "+line;
                 }
             }
             System.out.println(line);
         }

	 }
	 
	 public static void main(String[] args) {
		 staircase(6);
	 }
}
