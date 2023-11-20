package Lab_09_Task2;

import java.util.List;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
		AnPham b1 = new TapChi("A", 100, 2021, "ABC", 5000, "AAAA");
		AnPham b2 = new TapChi("B", 100, 2011, "ABC", 5000, "BBBB");
		AnPham b3 = new TapChi("C", 100, 2023, "BCD", 5000, "CCCC");

		ChuongSach c1 = new ChuongSach("S", 30);
		ChuongSach c2 = new ChuongSach("T", 40);
		ChuongSach c3 = new ChuongSach("U", 50);
		ChuongSach c4 = new ChuongSach("V", 20);
		ChuongSach c5 = new ChuongSach("W", 10);
		ChuongSach c6 = new ChuongSach("X", 60);

		AnPham b4 = new SachThamKhao("C", 121, 2021, "BCD", 5000, "CCCC");
		AnPham b5 = new SachThamKhao("E", 200, 2021, "BCD", 5000, "DDDD");
		AnPham b6 = new SachThamKhao("F", 300, 2022, "BCD", 5000, "EEEE");
		b4.addChuongSach(c1);
		b4.addChuongSach(c2);
		b5.addChuongSach(c3);
		b5.addChuongSach(c4);
		b6.addChuongSach(c5);
		b6.addChuongSach(c6);

		DanhMucAnPham danhMuc = new DanhMucAnPham();
		danhMuc.add(b1);
		danhMuc.add(b2);
		danhMuc.add(b3);
		danhMuc.add(b4);
		danhMuc.add(b5);
		danhMuc.add(b6);

		// C6
		System.out.println(b1.loaiAnPham());
		System.out.println("------------------");
		// C7
		System.out.println(b2.checkTapChi());
		System.out.println(b5.checkTapChi());
		System.out.println("------------------");
		// C8
		System.out.println(b1.checkAnPham(b2));
		System.out.println("------------------");
		// C9
		System.out.println(danhMuc.totalMoney());
		System.out.println("------------------");
		// C10
		System.out.println(danhMuc.timSTKCoNhieuTrangNhat());
		System.out.println("------------------");

		// C11
		System.out.println(danhMuc.chuaTapChi("AAAA"));
		System.out.println(danhMuc.chuaTapChi("OMG"));
		System.out.println("------------------");
		// C12
		int targetYear = 2021;
		List<TapChi> tapChisBeforeYear = danhMuc.dsTapChiSuatBanNamTruoc(targetYear);
		System.out.println("Tap chi duoc suat ban truoc hoac trong nam:  " + targetYear + ":");
		for (TapChi tapChi : tapChisBeforeYear) {
			System.out.println(tapChi.getTitle() + " - " + tapChi.getYears());
		}
		System.out.println("------------------");
		// C13
		danhMuc.sapXepAnPham();
		System.out.println("An pham duoc sap xep:");
		for (AnPham anPham : danhMuc.getDsAnPham()) {
			System.out.println(anPham.getTitle() + " - " + anPham.getYears());
		}
		System.out.println("------------------");
		// C14
		Map<Integer, Integer> anPhamm = danhMuc.anPhamTheoNam();
		System.out.println("Thong ke so luong theo nam suat ban: ");
		for (Map.Entry<Integer, Integer> entry : anPhamm.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}

	}

}
