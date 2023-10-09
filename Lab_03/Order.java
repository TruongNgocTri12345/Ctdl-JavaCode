package Lab_03;

import java.util.Arrays;
import java.util.Comparator;

public class Order {
	private OrderItem[] items;

	public Order(OrderItem[] items) {
		this.items = items;
	}
	//in cac don hang 
	public void print() {
		for (OrderItem item : items) {
		System.out.println(item.toString());
		}
		
	}

	// Tinh tong chi phi cua don hang
	public double cost() {
		double totalCost = 0.0;
		for (OrderItem item : items) {
			totalCost += item.getQuality() * item.getP().getPrice();
		}
		return totalCost;
	}

	// Kiem tra xem don hang co chua san pham cu th khong (using binary search)
	public boolean contains(Product p) {
		// Sap xep cac muc theo ID san pham
		Arrays.sort(items, Comparator.comparing(item -> item.getP().getId()));

		// Tim kiem nhi phan cho san pham
		int left = 0;
		int right = items.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;

			int comparison = items[mid].getP().getId().compareTo(p.getId());

			if (comparison == 0) {
				return true; // Co san pham
			} else if (comparison < 0) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return false; // Khong co san pham
	}

	// Loc san pham dua tren loai da cho (using linear search)Tim kiem tuyen tinh
	public Product[] filter(String type) {
		int count = 0;
		for (OrderItem item : items) {
			if (item.getP().getType().equals(type)) {
				count++;
			}
		}

		Product[] filteredProducts = new Product[count];
		int index = 0;

		for (OrderItem item : items) {
			if (item.getP().getType().equals(type)) {
				filteredProducts[index] = item.getP();
				index++;
			}
		}

		return filteredProducts;
	}
}
