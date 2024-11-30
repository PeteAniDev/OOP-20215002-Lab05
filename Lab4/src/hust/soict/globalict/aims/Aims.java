package hust.soict.globalict.aims;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.DigitalVideoDisc;

public class Aims {

	public static void main(String[] args) {
		Cart newOrder = new Cart();

		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		newOrder.addMedia(dvd1, dvd2, dvd3);

		newOrder.removeMedia(dvd2);
		newOrder.removeMedia(dvd2);

		System.out.printf("The total cost is: %.2f", newOrder.totalCost());
	}

}