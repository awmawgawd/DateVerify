package userInput;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UserInput1 {

	public static void main(String[] args) {
		/** Get user input of DOB.
		 *  Use Regex to insure of proper format entered by user.
		 */
		// Create Scanner object
		Scanner input = new Scanner(System.in);
				
		// Print prompt.
		System.out.print("Enter Date of Birth (MM-DD-YYYY): ");
		
		
		/**
		 *  Check MM-DD-YYYY format before prompting user to re-enter if using incorrect format.
		 */
		
		// Wait for user to enter text.
		String dob = input.nextLine();
		
		// Checks length = 10
		int length = dob.length();
		boolean isLength = length == 10;
		
		// Values of MM, DD, YYYY 
		int month = Integer.parseInt(dob.substring(0,2));
		int day = Integer.parseInt(dob.substring(3,5));
		int year = Integer.parseInt(dob.substring(6,10));
		boolean isMonth;
		boolean isDay31;
		boolean isDay30;
		boolean isDay28;
		boolean isDay29;
		boolean isYear;
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY");
		LocalDateTime now = LocalDateTime.now();
		int currYear= Integer.parseInt(dtf.format(now));
		
		System.out.println();
		
		/**
		 * Check YYYY
		 */
		// Check to make sure YYYY value is between 1880 and current year
		if(year > 1880  && year <= currYear)
		
			
		 /**
		  * Check MM
		  */
		
		// Check to make sure MM value is between 1 to 12.
		if(month > 0 && month < 13) {
			isMonth = true;
		}
		
		
		/**
		 * Check DD
		 */
		
		// Check to make sure DD value is between 1 to 31 for Jan, Mar, May, Jul, Aug, Oct, and Dec.
		if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			isDay28 = false;
			isDay29 = false;
			isDay30 = false;
			isDay31 = true;
		}
		
		// Check to make sure DD value is between 1 to 301 for April, June, Sept, and Nov.
		if(month == 4 || month == 6 || month == 8 || month == 11) {
			isDay28 = false;
			isDay29 = false;
			isDay30 = true;
			
		}
		
		// Check to make sure DD value is 1 to 28 or 1 to 29 (leap year) for Feb.
		if(month == 2) {
			if(year % 4 == 0 && year % 100 == 0 && year % 400 == 0) {
				isDay28 = false;
				isDay29 = true;
				isDay30 = false;
				isDay31 = false;
			}
			else if(year % 4 == 0 && year % 100 != 0) {
				isDay28 = false;
				isDay29 = true;
				isDay30 = false;
				isDay31 = false;
			}
			else if(year % 4 != 0 || (year % 100 == 0 && year % 400 != 0)){
				isDay28 = true;
				isDay29 = false;
				isDay30 = false;
				isDay31 = false;
			}
			else {
				System.out.println("You have a February month, but somehow you are not categorized properly. Must check condition.");
				isDay28 = false;
				isDay29 = false;
				isDay30 = false;
				isDay31 = false;
			}
		}
		
		
			
		
		
		
		
		
		
		
		
		
		
		// Print user's inputs.
		String userInputs = "Date of Birth: " + dob;
		
		System.out.println(userInputs);
		
		
		
		
	}

}
