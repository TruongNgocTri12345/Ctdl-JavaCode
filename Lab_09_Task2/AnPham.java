package Lab_09_Task2;

public abstract class AnPham {
	protected String title;
	protected int pages;
	protected int years;
	protected String author;
	protected double price;

	public AnPham(String title, int pages, int years, String author, double price) {
		super();
		this.title = title;
		this.pages = pages;
		this.years = years;
		this.author = author;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public int getPages() {
		return pages;
	}

	public int getYears() {
		return years;
	}

	public double getPrice() {
		return price;
	}

	// C6
	public abstract String loaiAnPham();

	// C7
	public abstract boolean checkTapChi();

	// C8
	public abstract boolean checkAnPham(AnPham that);

	public abstract void addChuongSach(ChuongSach chuongSach);

	// C11
	public abstract boolean tenChoTruoc(String tapChiThat);

}
