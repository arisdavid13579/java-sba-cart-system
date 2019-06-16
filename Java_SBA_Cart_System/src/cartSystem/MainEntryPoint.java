package cartSystem;

import java.io.IOException;
import java.util.Scanner;

public class MainEntryPoint {
	public static void main(String[] args) throws IOException {
		AppSystem app = new AppSystem();
		CartSystem cart = new CartSystem();
		Scanner userInput = new Scanner(System.in);
		Integer choice = 0;
		while (choice != 7) {
			menu();
			choice = userInput.nextInt();
			switch (choice) {
			case 1:
				Item item = new Item();
				userInput.nextLine();
				System.out.print("\nEnter the item name:\n");
				item.setItemName(userInput.nextLine());
				System.out.print("\nEnter a description for the item:\n");
				item.setItemDesc(userInput.nextLine());
				System.out.print("\nEnter the item's price:\n");
				item.setItemPrice(userInput.nextDouble());
				System.out.print("\nEnter the quantity available in the System:\n");
				item.setAvailableQuantity(userInput.nextInt());
				System.out.println(item.getItemName());
				if (app.add(item)) {
					System.out.println("Item successfully added");
				} else {
					System.out.println("Try Again");
				}
				break;
			case 2:
				app.display();
				System.out.println("Enter the name of the item");
				userInput.nextLine();
				String item_name = userInput.nextLine();
				if (cart.add(app.getItemCollection().get(item_name))) {
					System.out.println("Item successfully added");
				} else {
					System.out.println("Invalid or Unavailable Item, Please Try Again");
				}
				;
				break;
			case 3:
				cart.display();
				break;
			case 4:
				app.display();
				break;
			case 5:
				cart.display();
				System.out.println("Enter the name of the item");
				userInput.nextLine();
				item_name = userInput.nextLine();
				if (cart.remove(item_name) != null) {
					System.out.println(item_name + " was removed from the cart");
				} else {
					System.out.println("Invalid Item, Please Try Again");
				}
				break;
			case 6:
				app.display();
				System.out.println("Enter the name of the item");
				userInput.nextLine();
				item_name = userInput.nextLine();
				if (app.remove(item_name) != null) {

					System.out.println(item_name + " was removed from the System");
					if (cart.remove(item_name) != null) {
						System.out.println(item_name + " was also removed from the cart");
					}
				} else {
					System.out.println("Invalid Item, Please Try Again");
				}

				break;
			case 7:
				System.out.println("\nByyyeee!!");
				break;
			}
		}
		userInput.close();
	}

	public static void menu() {
		System.out.println("\nChoose an action:");
		System.out.println("1. Add item to System");
		System.out.println("2. Add item to Cart");
		System.out.println("3. Display Cart");
		System.out.println("4. Display System");
		System.out.println("5. Remove item from Cart");
		System.out.println("6. Remove item from System");
		System.out.println("7. Quit");
	}
}
