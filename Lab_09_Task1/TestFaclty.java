package Lab_09_Task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestFaclty {
	public static void main(String[] args) {
		// Sinh vien
		Student st1 = new Student("1", "Nguyen Van A", 2023);
		Student st2 = new Student("2", "Tran Thi B", 2023);
		Student st3 = new Student("3", "Le Quang C", 2023);
		Student st4 = new Student("4", "Pham Thi D", 2023);
		Student st5 = new Student("5", "Do Van E", 2023);
		Student st6 = new Student("6", "Ho Thi F", 2023);

		// Tạo danh sách sinh vien
		List<Student> ls1 = new ArrayList<>();
		ls1.add(st1);
		List<Student> ls2 = new ArrayList<>();
		ls2.add(st2);
		ls2.add(st3);
		ls2.add(st4);
		List<Student> ls3 = new ArrayList<>();
		ls3.add(st5);
		ls3.add(st6);

		Course c1 = new Course("1", "Lap trinh huong doi tuong", "ly thuyet", ls1, "Co tram");
		Course c2 = new Course("2", "Cau truc du lieu va giai thuat", "thuc hanh", ls2, "Thay Du");
		Course c3 = new Course("3", "Mang may tinh", "thuc hanh", ls3, "Co Nga");

		// Tạo danh sách các học phần
		List<Course> courses = new ArrayList<>();
		courses.add(c1);
		courses.add(c2);
		courses.add(c3);

		// Tạo khoa
		Faculty faculty = new Faculty("Khoa CNTT", "DH_Nong Lam", courses);

		// In ra học phần thực hành có nhiều sinh viên đăng ký học nhất
		System.out.println(
				"Hoc phan thuc hanh co nhieu sinh vien dk nhat: " + faculty.getMaxPracticalCourse().getTitle());

		// Thống kê danh sách sinh viên theo năm vào học
		Map<Integer, List<Student>> studentsByYear = faculty.groupStudentsByYear();
		for (Integer year : studentsByYear.keySet()) {
			System.out.println("Nam vao hoc: " + year);
			for (Student student : studentsByYear.get(year)) {
				System.out.println("- " + student.getName());
			}
		}

		Set<Course> practicalCourses = faculty.filterCourses("thuc hanh");
		for (Course course : practicalCourses) {
			System.out.println("Hoc phan thuc hanh: " + course.getTitle() + " - So luong sinh vien dk hoc: "
					+ course.getStudents().size());
		}
	}

}
