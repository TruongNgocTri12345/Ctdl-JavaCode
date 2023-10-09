package Lab_03;

public class OrderItem {
	private Product p;
	private int quantity; // so luong

	public OrderItem(Product p, int quantity) {
		this.p = p;
		this.quantity = quantity;
	}

	public String toString() {
		return p + ", So luong: " + quantity;
	}

	public Product getP() {
		return p;
	}

	public int getQuality() {
		return quantity;
	}
}
