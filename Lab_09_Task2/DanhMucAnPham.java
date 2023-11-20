package Lab_09_Task2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DanhMucAnPham {
	private List<AnPham> dsAnPham;

	public DanhMucAnPham() {
		super();
		this.dsAnPham = new ArrayList<>();
	}

	public List<AnPham> getDsAnPham() {
		return dsAnPham;
	}

	public void add(AnPham anPham) {
		this.dsAnPham.add(anPham);
	}

	// C9
	public double totalMoney() {
		double sum = 0.0;
		for (AnPham anPham : dsAnPham) {
			sum += anPham.price;
		}
		return sum;
	}

	// C10
	public SachThamKhao timSTKCoNhieuTrangNhat() {
		SachThamKhao CoChuongNhieuTrangNhat = null;
		int maxSoTrang = -1;
		for (AnPham anPham : dsAnPham) {
			if (anPham instanceof SachThamKhao) {
				SachThamKhao sachThamKhao = (SachThamKhao) anPham;
				if (sachThamKhao.totalTrangCuaCacChuong() > maxSoTrang) {
					maxSoTrang = sachThamKhao.totalTrangCuaCacChuong();
					CoChuongNhieuTrangNhat = sachThamKhao;
				}
			}

		}
		return CoChuongNhieuTrangNhat;
	}

	// C11
	public boolean chuaTapChi(String tapChiThat) {
		for (AnPham anPham : dsAnPham) {
			if (anPham.tenChoTruoc(tapChiThat)) {
				return true;
			}
		}
		return false;

	}

	// C12
	public List<TapChi> dsTapChiSuatBanNamTruoc(int year) {
		List<TapChi> re = new ArrayList<>();
		for (AnPham anPham : dsAnPham) {
			if (anPham instanceof TapChi && anPham.getYears() <= year) {
				re.add((TapChi) anPham);
			}

		}

		return re;
	}

	// C13
	public void sapXepAnPham() {
		dsAnPham.sort(new Comparator<AnPham>() {

			@Override
			public int compare(AnPham o1, AnPham o2) {
				if (o1.getTitle().compareTo(o2.getTitle()) == 0) {
					return o2.getYears() - o1.getYears();
				}
				// TODO Auto-generated method stub
				return o1.getTitle().compareTo(o2.getTitle());
			}
		});
	}

	// C14
	public Map<Integer, Integer> anPhamTheoNam() {
		Map<Integer, Integer> re = new HashMap<>();
		for (AnPham anPham : dsAnPham) {
			re.put(anPham.getYears(), re.getOrDefault(anPham.getYears(), 0) + 1);
		}
		return re;
	}

}
