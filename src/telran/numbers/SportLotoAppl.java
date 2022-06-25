package telran.numbers;
import java.util.Arrays;
public class SportLotoAppl {

	private static final int NUMBERS = 7;
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 49;
	public static void main(String[] args) {
		int ar[] = new int[NUMBERS];
		int number = 0;
		for(int i = 0; i < ar.length; i++) {
			while(ArrayInt.indexOf(ar, number) != -1) {
				number = getRandomNumber(MIN_NUMBER, MAX_NUMBER);
			}
			ar[i] = number;
		}
		 System.out.println(Arrays.toString(ar));
	}
	private static int getRandomNumber(int min, int max) {
		return (int) (min + Math.random() * (max - min + 1));
	}
}
