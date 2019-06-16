package cartSystem;

import java.util.Map;

public class CartSystem extends TheSystem {
	CartSystem() {
	}

	@Override
	public void display() {
		double subtotal = 0;
		int longestNameL = 0;
		int longestDescL = 0;
		int longest = 0;
		for (Map.Entry<String, Item> it : this.getItemCollection().entrySet()) {
			int nameLength = it.getValue().getItemName().length();
			int descLength = it.getValue().getItemDesc().length();
			longestNameL = nameLength > longestNameL ? nameLength : longestNameL;
			longestDescL = descLength > longestDescL ? descLength : longestDescL;
			longest = longestNameL > longestDescL ? longestNameL : longestDescL;
		}
		longest = longest > 12 ? longest : 12;
		Utilities.separate("=", (longest + 3) * 4);
		System.out.println(Utilities.wallIn(Utilities.rightPadder("Item Name", longest))
				+ Utilities.wallIn(Utilities.rightPadder("Description", longest))
				+ Utilities.wallIn(Utilities.rightPadder("Quantity", longest))
				+ Utilities.wallIn(Utilities.rightPadder("Price", longest)));
		Utilities.separate("=", (longest + 3) * 4);
		for (Map.Entry<String, Item> it : this.getItemCollection().entrySet()) {
			subtotal += (it.getValue().getItemPrice() * it.getValue().getQuantity());
			String itemName = it.getValue().getItemName();
			String itemDesc = it.getValue().getItemDesc();
			int itemQuant = it.getValue().getQuantity();
			double itemPrice = itemQuant * it.getValue().getItemPrice();

			System.out.println(Utilities.wallIn(Utilities.rightPadder(itemName, longest))
					+ Utilities.wallIn(Utilities.rightPadder(itemDesc, longest))
					+ Utilities.wallIn(Utilities.rightPadder(String.valueOf(itemQuant), longest))
					+ Utilities.wallIn(Utilities.rightPadder(String.valueOf(itemPrice), longest)));
			Utilities.separate("=", (longest + 3) * 4);

		}
		System.out.println();
		System.out.println("Subtotal: " + Utilities.round(subtotal, 2));
		System.out.println();
		System.out.println("Tax: " + Utilities.round(subtotal * 0.05, 2));
		System.out.println();
		System.out.println("Total: " + Utilities.round(subtotal * 1.05, 2));
		System.out.println();
	}
}
