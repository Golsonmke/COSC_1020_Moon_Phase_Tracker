package project2;

import java.util.*;
/**
 * COSC 1020 Sec.101 8am
 * Professor Nadiyah Johnson
 * Moon Phase Tracker
 * @author Gary Olson
 *
 */
public class MoonPhaseTracker {

	public static void main(String[] args) {
		
		System.out.println();
		String fullDate = userInput();
		String monthString = month(fullDate);
		int day = day(fullDate);
		int year = year(fullDate);
		int month = monthNum(monthString);
		int julian = julianDay(month,year,day);
		String dayOfWeek = dayOfWeek(julian);
		String moonPhase = moonPhase(julian);
		printResults(monthString,day,year,julian,dayOfWeek,moonPhase);
		runAgain();
		

	}
	//Method to get user input
	public static String userInput() {
		//Instatiate Scanner classs
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		//Prompt user to enter date
		System.out.print("Enter the date (e.g. March 16, 1981) : ");
		String fullDate = in.nextLine();
	
		return fullDate;	
	}
	//Method to extract the month from the user input string
	public static String month(String fullDate) {
		
		String monthString = fullDate.substring(0,fullDate.indexOf(" "));
		return monthString;
	}
	//Method to extract the day and convert to integer
	public static int day(String fullDate) {
		
		String dayString = fullDate.substring(fullDate.indexOf(" ")+1, fullDate.indexOf(","));
		int day = Integer.parseInt(dayString);
		return day;	
	}
	//Method to extract the year and convert to integer
	public static int year(String fullDate) {
		
		String yearString = fullDate.substring(fullDate.indexOf(",")+2, fullDate.length());		
		int year = Integer.parseInt(yearString);
		return year;
	}
	//Method to convert string to corresponding month integer
	public static int monthNum(String month) {

		String compMonth = month.toUpperCase();
		int num = 0;
		
		switch(compMonth) {
		case "JANUARY":
			return num = 1;
		case "FEBRUARY":
			return num = 2;
		case "MARCH":
			return num = 3;
		case "APRIL":
			return num = 4;
		case "MAY":
			return num = 5;
		case "JUNE":
			return num = 6;
		case "JULY":
			return num = 7;
		case "AUGUST":
			return num = 8;
		case "SEPTEMBER":
			return num = 9;
		case "OCTOBER":
			return num = 10;
		case "NOVEMBER":
			return num = 11;
		case "DECEMBER":
			return num = 12;
		}
		return num;
	}
	//Method to calculate julian day
	public static int julianDay(int month,int year, int day) {
		
		int a,y,m,julian;
		
		a = (14-month)/12;
		y = year + 4800 -a;
		m = month + 12 * a - 3;
		julian = day + (153 * m + 2)/5 + 365 * y + y/4 - y/100 + y/400 - 32045;
		
		return julian;	
		
	}
	//Method to calculate the day of the week
	public static String dayOfWeek(int julian) {
		
		String dayOfWeek = null;
		int d = (julian +1)%7;
		
		if(d == 0)
			return dayOfWeek = "Sunday";
		else if(d == 1)
			return dayOfWeek = "Monday";
		else if(d == 2)
			return dayOfWeek = "Tuesday";
		else if(d == 3)
			return dayOfWeek = "Wednesday";
		else if(d == 4)
			return dayOfWeek = "Thursday";
		else if(d == 5)
			return dayOfWeek = "Friday";
		else if(d == 6)
			return dayOfWeek = "Saturday";
		return dayOfWeek;
			
	}
	//Method to calculate moon phase
	public static String moonPhase(int julian) { 
		
		String moonPhase = null;
		double a =  ((julian - 2415021) % 29.53088853)/(29.53088853) *8;
		var b = Math.round(a);
		
		if(b < 0)
			b+=8;
		if(b == 0)
			 moonPhase = "New Moon";
		else if(b == 1)
			 moonPhase = "Waxing Cresent";
		else if(b == 2)
			 moonPhase = "First Quarter";
		else if(b == 3)
			 moonPhase = "Waxing Gibbous";
		else if(b == 4)
			 moonPhase = "Full Moon";
		else if(b == 5)
			 moonPhase = "Waning Gibbous";
		else if(b == 6)
			 moonPhase = "Last Quarter";
		else if(b == 7)
			 moonPhase = "Waning Cresent";
		else if(b == 8)
			 moonPhase = "New Moon";
		else
			moonPhase = "Bad Calculation!";	
		return moonPhase;
			
	}
	//Method to display results
	public static void printResults(String monthString,int day,int year,int julian, String dayOfWeek, String moonPhase) {
		
		System.out.println(monthString + " " + day +", " + year + " has a Julian day of " + julian + ".");
		System.out.println("Its day of the week is " + dayOfWeek + ".");
		System.out.println("Its phase of the moon is " + moonPhase + ".");
		System.out.println();
			
	}
	//Method to run program again
	public static void runAgain() {
		
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		System.out.print("Would you like to run another date? Enter Y/N: ");
		String input = s.nextLine();
		
		if(input.equals("Y")  || input.equals("y")) {
			
			main(null);
		}	
		else if(input.equals("N")|| input.equals("n")) {
			
			System.out.println("Thank you! Goodbye!");
		}
		else {
			
			System.out.println("Enter valid choice!");
			System.out.println();
			runAgain();
		}
		
		
		
	}

}
