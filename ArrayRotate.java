package practice.org;

public class ArrayRotate{

	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5};
		int[] res = rotateArray(a, 4);
		for(int i: res) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	public static int[] rotateArray(int[] a, int k) {
		
		int[] aux = new int[a.length];
		if(k == a.length) {
			return a;
		}
		for(int i=0; i<a.length; i++) {
			aux[(k+i) % a.length] = a[i];
		}
		return aux;
	}
}
