package userInput;

public class Date {

	public static void main(String[] args) {
		/**
		 * Check month, day , year, and leap year
		 */

		
		int month = 2;
		int day = 29;
		int year = 2008;
		
		// For Jan, Mar, May, Jul, Aug, Oct, and Dec.
		if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			System.out.println("Month: " + month + " ---1");
		}
		
		// For April, June, Sept, and Nov.
		if(month == 4 || month == 6 || month == 8 || month == 11) {
			System.out.println("Month: " + month + " ---2");
		}
		
		// For Feb, check year to see if leap year
		if(month == 2 && (year % 4 == 0 && year % 100 == 0 && year % 400 == 0) && day == 29) {
			System.out.println("Month: " + month + " ---3");
			System.out.println("Leap Year: " + year);
		}
		else if(month == 2 && (year % 4 == 0 && year % 100 != 0)) {
			System.out.println("Month: " + month + " ---4");
			System.out.println("Leap Year: " + year);
		}
		else if(month == 2 && (year % 4 != 0 || (year % 100 == 0 && year % 400 != 0))){
			System.out.println("Month: " + month + " ---5");
			System.out.println("Year: " + year);
		}
	}

}
