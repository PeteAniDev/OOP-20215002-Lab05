package hust.soict.globalict.aims;

import java.util.Scanner;

import hust.soict.globalict.aims.store.Store;

public class Aims {

	private static Scanner scanner = new Scanner(System.in);
	private static int intInput;
	private static String stringInput;

	public static void main(String[] args) {
		do {
			showMenu();
			readInt();
			if (intInput == 1) {
				do {
					storeMenu();
					readInt();
					if (intInput == 1) {
						System.out.println("Please enter the title of the media.");
						readString();
						Store.searchMedia(stringInput);
						confirm();
					}
				} while (intInput != 0);
			}
		} while (intInput != 0);
	}

	private static void readInt() {
		intInput = scanner.nextInt();
	}

	private static void readString() {
		stringInput = scanner.next();
	}

	private static void confirm() {
		System.out.println("Type anything to confirm.");
		scanner.next();
	}

	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}

	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}

	public static void mediaDetailsMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}

	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
	}

}