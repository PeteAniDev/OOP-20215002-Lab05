package hust.soict.globalict.aims;

import java.util.Scanner;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Disc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Track;
import hust.soict.globalict.aims.store.Store;

public class Aims {

	private static Scanner scanner = new Scanner(System.in);
	private static int intInput;
	private static float floatInput;
	private static String stringInput;

	public static void main(String[] args) {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		Book book = new Book("Brimestone 8.4", "Action", 199.99f);
		CompactDisc cd = new CompactDisc("Brimestone Compilations", "Action", "Pete Karesisto", 399.99f);
		cd.addTrack(new Track("Meltwater Sump Defense", 19));
		cd.addTrack(new Track("Glacialfall Passage Conquer", 30));
		cd.addTrack(new Track("Deepwood Gorge Defense", 24));
		Store.addMedia(dvd1, dvd2, dvd3, book, cd);

		Cart cart = new Cart();

		do {
			showMenu();
			readInt();
			if (intInput == 1) {
				Store.printItems();
				do {
					storeMenu();
					readInt();
					if (intInput == 1) {
						System.out.println("Please enter the title of the media.");
						readString();
						Media item = Store.searchMedia(stringInput);
						if (item != null) {
							do {
								boolean isDisc = item instanceof Disc;
								mediaDetailsMenu(isDisc);
								readInt();
								if (intInput == 1) {
									cart.addMedia(item);
									System.out.println("Number of items in cart: " + cart.numberOfItems());
									confirm();
								} else if (intInput == 2 && isDisc) {
									Disc disc = (Disc) item;
									disc.play();
									confirm();
								}
							} while (intInput != 0);
							intInput = -1;
						} else {
							confirm();
						}
					} else if (intInput == 2) {
						System.out.println("Please enter the title of the media.");
						readString();
						Media item = Store.searchMedia(stringInput);
						if (item != null) {
							cart.addMedia(item);
						}
						System.out.println("Number of items in cart: " + cart.numberOfItems());
						confirm();
					} else if (intInput == 3) {
						System.out.println("Please enter the title of the media.");
						readString();
						Media item = Store.searchMedia(stringInput);
						if (item != null && item instanceof Disc) {
							Disc disc = (Disc) item;
							disc.play();
						} else if (item != null) {
							System.out.println("Item is not playable.");
						}
						confirm();
					} else if (intInput == 4) {
						seeCurrentCart(cart);
					}
				} while (intInput != 0);
				intInput = -1;
			} else if (intInput == 2) {
				Store.printItems();
				do {
					updateStoreMenu();
					readInt();
					if (intInput == 1) {
						System.out.println("Please choose an item type: ");
						System.out.println("1. CD");
						System.out.println("2. DVD");
						System.out.println("3. BOOK");
						readInt();
						int itemType = intInput - 1;
						if (intInput > 0 && intInput <= 3) {
							Media item = null;
							System.out.println("Please enter the item title.");
							readString();
							String title = stringInput;
							System.out.println("Please enter the item category.");
							readString();
							String category = stringInput;
							System.out.println("Please enter the item cost.");
							readFloat();
							float cost = floatInput;
							if (itemType == Store.TYPE_DVD) {
								System.out.println("Please enter the dvd director.");
								readString();
								String director = stringInput;
								System.out.println("Please enter the dvd length.");
								readInt();
								int length = intInput;
								item = new DigitalVideoDisc(title, category, director, length, cost);
							} else if (itemType == Store.TYPE_CD) {
								System.out.println("Please enter the dvd director.");
								readString();
								String director = stringInput;
								item = new CompactDisc(title, category, director, cost);
							} else if (itemType == Store.TYPE_BOOK) {
								item = new Book(title, category, cost);
							}
							if (item != null) {
								Store.addMedia(item);
								System.out.println("Item has been added to store.");
							} else {
								System.out.println("Failed to add item.");
							}
							confirm();
						} else {
							System.out.println("Invalid item type.");
							confirm();
						}
					} else if (intInput == 2) {
						System.out.println("Please enter the title of the media.");
						readString();
						Media item = Store.searchMedia(stringInput);
						if (item != null) {
							while (cart.contains(item)) {
								cart.removeMedia(item);
							}
							Store.removeMedia(item);
						}
						System.out.println("Item has been removed from store.");
						confirm();
					}
				} while (intInput != 0);
				intInput = -1;
			} else if (intInput == 3) {
				seeCurrentCart(cart);
			}
		} while (intInput != 0);
	}

	private static void seeCurrentCart(Cart cart) {
		cart.printCart(Cart.FILTER_NONE);
		do {
			cartMenu();
			readInt();
			if (intInput == 1) {
				do {
					filterMenu();
					readInt();
					if (intInput == 1) {
						System.out.println("Please enter an ID.");
						readInt();
						cart.setIdFilter(intInput);
						cart.printCart(Cart.FILTER_BY_ID);
						confirm();
					}
					if (intInput == 2) {
						System.out.println("Please enter a title.");
						readString();
						cart.setTitleFilter(stringInput);
						cart.printCart(Cart.FILTER_BY_TITLE);
						confirm();
					}
				} while (intInput > 2 && intInput < 0);
				intInput = -1;
			} else if (intInput == 2) {
				do {
					sortMenu();
					readInt();
					if (intInput == 1) {
						cart.sortCart(Media.COMPARE_BY_TITLE_COST);
						cart.printCart(Cart.FILTER_NONE);
						confirm();
					}
					if (intInput == 2) {
						cart.sortCart(Media.COMPARE_BY_COST_TITLE);
						cart.printCart(Cart.FILTER_NONE);
						confirm();
					}
				} while (intInput > 2 && intInput < 0);
				intInput = -1;
			} else if (intInput == 3) {
				System.out.println("Please enter the title of the media.");
				readString();
				Media item = cart.searchMedia(stringInput);
				if (item != null) {
					cart.removeMedia(item);
				}
				System.out.println("Item has been removed from cart.");
				confirm();
			} else if (intInput == 4) {
				System.out.println("Please enter the title of the media.");
				readString();
				Media item = cart.searchMedia(stringInput);
				if (item != null && item instanceof Disc) {
					Disc disc = (Disc) item;
					disc.play();
				} else if (item != null) {
					System.out.println("Item is not playable.");
				}
				confirm();
			} else if (intInput == 5) {
				System.out.println("An order has been created.");
				cart = new Cart();
				confirm();
			}
		} while (intInput != 0);
		intInput = -1;
	}

	private static void readInt() {
		intInput = scanner.nextInt();
		readString();
	}

	private static void readFloat() {
		floatInput = scanner.nextFloat();
		readString();
	}

	private static void readString() {
		stringInput = scanner.nextLine();
	}

	private static void confirm() {
		System.out.println("Type anything to confirm.");
		readString();
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

	public static void mediaDetailsMenu(boolean disc) {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		if (disc) {
			System.out.println("2. Play");
		}
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1" + (disc ? "-2" : ""));
	}

	public static void updateStoreMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add a media to store");
		System.out.println("2. Remove a media from store");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}

	public static void filterMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter by ID");
		System.out.println("2. Filter by title");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}

	public static void sortMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Sort by title");
		System.out.println("2. Sort by cost");
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