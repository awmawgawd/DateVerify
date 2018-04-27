package userInput;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UserInput1 {

	public static void main(String[] args) {
		boolean isMonth = false;
		boolean isDay = false;
		boolean isDay31 = false;
		boolean isDay30 = false;
		boolean isDay28 = false;
		boolean isDay29 = false;
		boolean isYear = false;
		boolean isLength = false;
		boolean begin = true;
		String dob = "";
		int length;
		
		int month;
		int day;
		int year;
		int currYear;
		
		/** Get user input of DOB.
		 *  Use Regex to insure of proper format entered by user.
		 */
		// Create Scanner object
		Scanner input = new Scanner(System.in);
		
		while(begin == true) {
		
			
			// Print prompt.
			System.out.print("Enter Date of Birth (MM-DD-YYYY): ");
			
			
			/**
			 *  Check MM-DD-YYYY format before prompting user to re-enter if using incorrect format.
			 */
			
			// Wait for user to enter text.
			dob = input.nextLine();
			
			// Checks length = 10
			length = dob.length();
			isLength = length == 10;
			
			// **************** FIX to make sure no error when inputting example: 044-0505-505050. Recommend to use substring to find if values are numeric before converting *******************
			
			// Values of MM, DD, YYYY 
			month = Integer.parseInt(dob.substring(0,2));
			day = Integer.parseInt(dob.substring(3,5));
			year = Integer.parseInt(dob.substring(6,10));
		
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY");
			LocalDateTime now = LocalDateTime.now();
			currYear= Integer.parseInt(dtf.format(now));
			
			System.out.println();
			
			
			/**
			 * Check YYYY
			 */
			// Check to make sure YYYY value is between 1880 and current year
			if(year >= 1880  && year <= currYear) {
				isYear = true;
			}
			
				
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
			
			// Set isDay to true
			if(isDay28 == true || isDay29 == true || isDay30 == true || isDay31 == true) {
				isDay = true;
			}
			
			// Check values
			System.out.println("Month: " + month + "\nDay: " + day + "\nYear: " + year);
			System.out.println("isMonth: " + isMonth + "\nisDay28: " + isDay28 + "\nisDay29: " + isDay29 + "\nisDay30: " + isDay30 + "\nisDay31: " + isDay31 + "\nisDay: " + isDay + "\nisYear:  " + isYear);
			
			
			// Check to make sure values are true and then exit loop if true
			if(isMonth == true && isDay == true && isYear == true && isLength == true) {
				begin = false;
			}
			else {
				begin = true;
				System.out.println("\nFormat should be MM-DD-YYYY. Please re-enter Date of Birth\n");
			}
			

			
		}
		
		
		
		
		// Print user's inputs.
		String userInputs = "Date of Birth: " + dob;
		
		System.out.println(userInputs);
		
		input.close();
		
		
	}

}
