package Lab_09_Task2;

import java.util.ArrayList;
import java.util.List;

public class SachThamKhao extends AnPham {
	private String linhVuc;
	private List<ChuongSach> chuongSach;

	public SachThamKhao(String title, int pages, int years, String author, double price, String linhVuc) {
		super(title, pages, years, author, price);
		this.linhVuc = linhVuc;
		this.chuongSach = new ArrayList<>();
	}

	public String getLinhVuc() {
		return linhVuc;
	}

	public List<ChuongSach> getChuongSach() {
		return chuongSach;
	}

	public String loaiAnPham() {
		return "Sach tham khao";
	}

	public boolean checkTapChi() {
		return false;
	}

	public boolean checkAnPham(AnPham that) {
		return that instanceof SachThamKhao && this.author.equals(that.author);
	}

	public int totalTrangCuaCacChuong() {
		int total = 0;
		for (ChuongSach cs : chuongSach) {
			if (cs.getSoTrang() > total)
				total = cs.getSoTrang();
		}
		return total;

	}

	public void addChuongSach(ChuongSach chuongSach) {
		this.chuongSach.add(chuongSach);
	}

	@Override
	public boolean tenChoTruoc(String tapChiThat) {
		// TODO Auto-generated method stub
		return false;
	}

}
