package cartSystem;

public class Item {
	private String itemName;
	private String itemDesc;
	private Double itemPrice;
	private Integer quantity;
	private Integer availableQuantity;

	public Item() {
		quantity = 1;
		itemDesc = " "; /*
						 * Setting new item descriptions to a blank space instead of empty to avoid
						 * NullPointerExceptions for my display() method in the cart
						 */
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public Double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(Integer availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
}
