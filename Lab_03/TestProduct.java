package Lab_03;

public class TestProduct {
	public static void main(String[] args) {
		// Tao san pham
		Product product1 = new Product("P101", "San pham 1", 10.0, "Type A");
		Product product2 = new Product("P102", "San pham 2", 15.0, "Type B");
		Product product3 = new Product("P103", "San pham 3", 20.0, "Type A");

		// Tao muc don hang
		OrderItem item1 = new OrderItem(product1, 2);
		OrderItem item2 = new OrderItem(product2, 3);
		OrderItem item3 = new OrderItem(product3, 1);

		// Tao mang cac muc don hang
		OrderItem[] orderItems = { item1, item2, item3 };

		// Tao don hang
		Order order = new Order(orderItems);
		
		//in tat ca don hang
		System.out.println("---------------------");
		order.print();
		System.out.println("---------------------");

		// Test cost() method
		double totalCost = order.cost();
		System.out.println("Tong chi phi cua don hang: $" + totalCost);
		System.out.println("---------------------");

		// Test contains() method
		Product searchProduct = new Product("P102", "Product 2", 15.0, "Type B");
		boolean containsProduct = order.contains(searchProduct);
		if (containsProduct) {
			System.out.println("Don hang co chua san pham: " + searchProduct);
		} else {
			System.out.println("Don hang khong chua san pham: " + searchProduct);
		}
		System.out.println("---------------------");

		// Test filter() method
		String filterType = "Type A";
		Product[] filteredProducts = order.filter(filterType);
		System.out.println("San pham thuoc loai " + filterType + " theo thu tu:");
		for (Product p : filteredProducts) {
			System.out.println(p);
		}
		System.out.println("---------------------");
	}
}
