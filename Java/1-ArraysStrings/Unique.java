import java.util.Scanner;

/***
 * Determine if a string has all unique characters. Cannot use additional data structures.
 * @author Dhaval
 *
 */
public class Unique {
	
	public static int MAX_CHARS = 128;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter sentence : ");
		String inputString = sc.nextLine();

		if (isUnique(inputString))
			System.out.println("All characeters are unique");
		else
			System.out.println("All characeters are not unique");
	}

	/**
	 * Assume 128 characters for standard ASCII
	 * @param inputString
	 * @return true/false
	 * 
	 */
	public static boolean isUnique(String inputString) {
		if(inputString.length() > MAX_CHARS)
			return false;
		
		//Boolean list to keep track of occurrence of characters 
		boolean charList[] = new boolean[MAX_CHARS];
		
		for(int i=0;i<inputString.length();i++) {
			int number = inputString.charAt(i);
			
			//Character already encountered. Not Unique
			if(charList[number]) 
				return false;
			//Record first occurrence of the character
			charList[number] = true;
		}
		
		return true;
	}

}
