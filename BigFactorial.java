package practice.org;

import java.math.BigInteger;

public class BigFactorial {

	static void extraLongFactorials(int n) {

        BigInteger factorial = factorial(BigInteger.valueOf(n));
        System.out.println(factorial);

    }
    private static BigInteger factorial(BigInteger n){
        if(n.equals(BigInteger.ONE)){
            return BigInteger.ONE;
        }
        return n.multiply(factorial(n.subtract(BigInteger.ONE)));
    }
    
    
}
