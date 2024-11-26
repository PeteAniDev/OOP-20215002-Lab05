package aims.tests;

import aims.Cart;
import aims.DigitalVideoDisc;

public class CartTest {

	public static void main(String[] args) {
		Cart cart = new Cart();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		cart.addDigitalVideoDisc(new DigitalVideoDisc[] { dvd1, dvd2, dvd3 });

		cart.printCart();
		cart.searchDVD(0);
		cart.searchDVD("star war");
		cart.searchDVD("star wars");
	}

}
