import java.util.HashMap;
import java.util.Scanner;

/***
 * Given two strings, check if one is a permutation of the other (Case
 * Sensitive)
 * 
 * @author Dhaval
 */
public class Permutation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1st String : ");
		String string1 = sc.nextLine();
		System.out.println("Enter 2nd String : ");
		String string2 = sc.nextLine();

		if (isPermutation(string1, string2))
			System.out.println("Strings are permutations");
		else
			System.out.println("Strings are not permutations");

	}

	/**
	 * Check for permutations
	 * 
	 * @param string1
	 * @param string2
	 * @return true/false
	 */
	public static boolean isPermutation(String string1, String string2) {
		// If lengths are not equal, strings cannot be permutations
		if (string1.length() != string2.length())
			return false;

		HashMap<Character, Integer> charCounts = new HashMap<Character, Integer>();

		// Count char counts of string1
		for (int i = 0; i < string1.length(); i++) {
			if (charCounts.get(string1.charAt(i)) == null)
				charCounts.put(string1.charAt(i), 1);
			else
				charCounts.put(string1.charAt(i), charCounts.get(string1.charAt(i)) + 1);
		}

		// Count char counts of string2.
		// If an imbalance/new character is found, count will be -1
		for (int j = 0; j < string2.length(); j++) {
			if (charCounts.get(string2.charAt(j)) == null)
				return false;
			charCounts.put(string2.charAt(j), charCounts.get(string2.charAt(j)) - 1);
			if (charCounts.get(string2.charAt(j)) == -1)
				return false;
		}
		return true;
	}
}
