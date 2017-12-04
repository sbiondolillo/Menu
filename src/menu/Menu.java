/*
 * Menu Class
 * Samuel Biondolillo
 * CIS210M:ZZ Data Structures and Elementary Algorithms
 * Goal: To create a user interface for running the various programs built in class
 * Version 0.0.1 - 9/21/17
 */

package menu;
import java.io.IOException;
import java.util.Scanner;

import classes.TestBinaryTree;
import classes.TestWordCountTree;
import main.EuclidGCD;
import main.SieveOfEratosthenes;
import main.TowersOfHanoi;
import programs.FahrenheitToCentigrade;
import programs.FeetToCentimeters;
import programs.OzToGrams;
import programs.PrimeNumberGenerator;
import programs.TextToOrderedList;
import programs.TwoDimensionalArray;

public class Menu {

	/*
	 * Prompt the user to select a program to be run from the list of available programs
	 */
	private static int getProgramChoice() {
		Scanner input = new Scanner(System.in);
		String userSelection;
		int programChoice;
		while (true) {
			System.out.println("Please make a selection. You may enter enter 'help' for list of options: ");
			userSelection = input.nextLine();
			if (userSelection.toLowerCase().equals("help")) {
				printProgramList();
				continue;
			} 
			else if (userSelection.matches("\\d+")) { // any number of digits
				programChoice = Integer.parseInt(userSelection);
				break;
			} else {
				System.out.println("You have entered an invalid selection");
				continue;
			}
							
		}
		if (programChoice == 99)	// quit
				return 0;
		else 
			return programChoice;
	}
	
	/*
	 * Execute the program selected by the user or notify of an improper choice
	 * @param programChoice - integer representing a program selected from the menu
	 */
	private static void runProgram(int programChoice) throws IOException {
		switch (programChoice) {
			case 1: FahrenheitToCentigrade.main(null);
					break;
			case 2: FeetToCentimeters.main(null);
					break;
			case 3: OzToGrams.main(null);
					break;
			case 4:	PrimeNumberGenerator.main(null);
					break;
			case 5: TwoDimensionalArray.main(null);
					break;
			case 6: TextToOrderedList.main(null);
					break;
			case 7: TestBinaryTree.main(null);
			        break;
			case 8: TestWordCountTree.main(null);
			        break;
			case 9: EuclidGCD.main(null);
			        break;
			case 10: TowersOfHanoi.main(null);
			        break;
			case 11: SieveOfEratosthenes.main(null);
	        		break;
			default: System.out.println("There is no program number " + programChoice);
					getProgramChoice();
					break;
		}
	}
	
	/*
	 * Display a list of all valid entries for program selection
	 */
	private static void printProgramList() {
		System.out.println("Enter 1 to run a program which converts degrees Fahrenheit to degrees Centigrade.");
		System.out.println("Enter 2 to run a program which converts distance in Feet to Centimeters.");
		System.out.println("Enter 3 to run a program which converts mass in Ounces to Grams.");
		System.out.println("Enter 4 to run a program which generates a list of prime numbers.");
		System.out.println("Enter 5 to run a program which generates a rectangular field of characters.");
		System.out.println("Enter 6 to run a program which turns text into an ordered list made of the characters" +
				" from that text.");
		System.out.println("Enter 7 to run a program which produces a visualization of a series of modifications" +
				" to a binary search tree.");
		System.out.println("Enter 8 to run a program which produces a binary tree from a list of words in a text file.");
		System.out.println("Enter 9 to run a program which will find the Greatest Common Divisor of two integers.");
		System.out.println("Enter 10 to run a program which produces a visualization of the solution to the classic" +
				" Towers of Hanoi puzzle.");
		System.out.println("Enter 11 to run a program which generates a stack of the prime numbers from 2 to 1000.");
		System.out.println("Enter 99 to quit.");
	}
	
	/*
	 * Main - Gets a program choice from the user and then executes that program
	 * 	 	  will continue to prompt for more choices until the user quits
	 */
	public static void main(String[] args) throws IOException {
		// open System.in here so we can close it when the user quits
		Scanner input = new Scanner(System.in);
		// use a loop so the user can run as many programs as desired
		while (true) {
			// Introduce the menu and get selection from user
			System.out.println("Welcome to the Menu");
			int programChoice = getProgramChoice();
			// Quit when requested
			if (programChoice == 0) {
				System.out.println("Goodbye.");
				// close System.in here because doing so elsewhere crashes the program
				input.close();
				System.exit(0);
			}
			else
				runProgram(programChoice);
		}

	}

}