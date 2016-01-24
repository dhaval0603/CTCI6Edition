import java.util.Scanner;

/***
 * Convert a normal string to URL. Convert spaces to %20.
 * Length of input char array is sufficient enough to include the extra characters needed for URLifying
 * True length of the string is provided. Inplace conversion.
 * @author Dhaval
 *
 */
public class URLify {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String : ");
		String inputString = sc.nextLine();
		System.out.println("Enter true length : ");
		int trueLength = sc.nextInt();

		System.out.println("URL version of the string : " + urlify(inputString, trueLength));
		sc.close();
	}

	/**
	 * In-place encoding of spaces to '%20'
	 * @param inputString
	 * @param trueLength
	 * @return
	 */
	public static String urlify(String inputString, int trueLength) {
		int countSpace = 0;
		char input[] = inputString.toCharArray();

		// Count number of spaces to compute the resulting string length
		for (int i = 0; i < trueLength; i++) {
			if (input[i] == ' ')
				countSpace++;
		}

		int index = trueLength + 2*countSpace -1;
		for (int i = trueLength -1; i >= 0; i--) {
			if (input[i] == ' ') {
				// If 'space', replace by '%20'
				input[index - 2] = '%';
				input[index - 1] = '2';
				input[index] = '0';
				index = index - 3;
			} else {
				// Else copy the char as it is
				input[index] = input[i];
				index--;
			}
		}

		String resultString = new String(input);
		return resultString;
	}
}
