package hust.soict.globalict.aims.tests.cart;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.DigitalVideoDisc;

public class CartTest {

	public static void main(String[] args) {
		Cart cart = new Cart();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		cart.addMedia(dvd1, dvd2, dvd3);

		cart.printCart(Cart.FILTER_NONE);
		cart.searchMedia(0);
		cart.searchMedia("star war");
		cart.searchMedia("star wars");
	}

}
