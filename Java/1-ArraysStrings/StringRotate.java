import java.util.Scanner;

/***
 * Check if one string is a rotation of the other. Only one call to isSubstring
 * allowed.
 * 
 * @author Dhaval
 *
 */
public class StringRotate {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1st String : ");
		String string1 = sc.nextLine();
		System.out.println("Enter 2nd String : ");
		String string2 = sc.nextLine();

		if (isRotatedSub(string1, string2))
			System.out.println("Is Rotated Substring");
		else
			System.out.println("Is NOT Rotated Substring");
		sc.close();
	}

	/**
	 * Check if string2 is a rotated substring of string1
	 */
	public static boolean isRotatedSub(String string1, String string2) {
		if (string1.length() != string2.length())
			return false;

		String merged = string1 + string2;
		return merged.contains(string2);
	}

}
