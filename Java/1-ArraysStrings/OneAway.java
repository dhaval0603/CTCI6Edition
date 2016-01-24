import java.util.Scanner;

/***
 * Check if two string are one/zero edits away from each other.
 * Insert/Replace/Delete is allowed as an edit
 * 
 * @author Dhaval
 */
public class OneAway {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1st String : ");
		String string1 = sc.nextLine();
		System.out.println("Enter 2nd String : ");
		String string2 = sc.nextLine();

		if (isOneAway(string1, string2))
			System.out.println("Strings are zero/one edit away");
		else
			System.out.println("Strings are NOT zero/one edit away");
		sc.close();
	}

	/**
	 * Check for one edit away conditions
	 */
	public static boolean isOneAway(String string1, String string2) {
		// One/zero edit away strings cannot have a difference of more than 1
		if (Math.abs(string1.length() - string2.length()) > 1)
			return false;

		int index1 = 0;
		int index2 = 0;
		boolean diffFound = false;

		while (index1 < string1.length() && index2 < string2.length()) {

			if (string1.charAt(index1) != string2.charAt(index2)) {
				if (diffFound) 
					// Already a difference found, so this is the second edit.
					return false;
				
				// First difference. Increment the larger index or both indexes if lengths are equal
				diffFound = true;
				if (string1.length() > string2.length())
					index1++;
				else if (string1.length() < string2.length())
					index2++;
				else {
					index1++;
					index2++;
				}
			} else {
				//No difference found, increment both indexes
				index1++;
				index2++;
			}

		}

		return true;

	}

}
