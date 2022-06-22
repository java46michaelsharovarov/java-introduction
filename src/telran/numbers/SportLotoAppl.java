package telran.numbers;
import java.util.Arrays;
public class SportLotoAppl {

	public static void main(String[] args) {
		int ar[] = new int[7];
		int number = 0;
		for(int i = 0; i < ar.length; i++) {
			while(ArrayInt.indexOf(ar, number) != -1) {
				number = getRandomNumber(1, 49);
			}
			ar[i] = number;
		}
		 System.out.println(Arrays.toString(ar));
	}
	private static int getRandomNumber(int min, int max) {
		return (int) (min + Math.random() * (max - min + 1));
	}
}
