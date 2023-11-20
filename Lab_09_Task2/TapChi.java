package Lab_09_Task2;

public class TapChi extends AnPham {
	private String tenTapChi;

	public TapChi(String title, int pages, int years, String author, double price, String tenTapChi) {
		super(title, pages, years, author, price);
		this.tenTapChi = tenTapChi;
	}

	public String getTenTapChi() {
		return tenTapChi;
	}

	public String loaiAnPham() {
		return "Tap chi";
	}

	public boolean checkTapChi() {
		return (2021 - this.years) == 10;
	}

	public boolean checkAnPham(AnPham that) {
		return that instanceof TapChi && this.author.equals(that.author);
	}

	public boolean tenChoTruoc(String tapChiThat) {
		return this.tenTapChi.equals(tapChiThat);

	}

	@Override
	public void addChuongSach(ChuongSach chuongSach) {
		// TODO Auto-generated method stub

	}

}
