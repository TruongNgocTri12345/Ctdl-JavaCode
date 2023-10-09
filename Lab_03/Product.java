package Lab_03;

public class Product {
	// San pham
	private String id; // id
	private String name; // ten
	private double price; // gia
	private String type; // loai

	public Product(String id, String name, double price, String type) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.type = type;
	}

	public String toString() {
		return "ID: " + id + ", Ten: " + name + ", Gia ca: " + price + ", Loai: " + type;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public String getType() {
		return type;
	}
}
