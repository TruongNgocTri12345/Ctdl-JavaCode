package Lab_09_Task1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Faculty {
	private String name;// ten
	private String address; // dia chi
	private List<Course> courses; // ds hoc phan

	public Faculty(String name, String address, List<Course> courses) {
		super();
		this.name = name;
		this.address = address;
		this.courses = courses;
	}

	public Course getMaxPracticalCourse() {
		Course re = courses.get(0);
		for (Course c : courses) {
			if (c.getType().equals("thuc hanh") && c.getStudents().size() > re.getStudents().size()) {
				re = c;
			}
		}
		return re;
	}

	public Map<Integer, List<Student>> groupStudentsByYear() {
		Map<Integer, List<Student>> re = new HashMap<>();

		for (Course course : courses) {
			for (Student student : course.getStudents()) {
				int key = student.getYear();
				List<Student> value = new ArrayList<>();

				if (!re.containsKey(key)) {
					value.add(student);
					re.put(key, value);
				}
				// Thêm sinh viên vào danh sách của năm tương ứng
				re.get(key).add(student);
			}
		}

		return re;
	}

	public Set<Course> filterCourses(String type) {
		Set<Course> re = new TreeSet<Course>(new Comparator<Course>() {

			@Override
			public int compare(Course c1, Course c2) {
				// TODO Auto-generated method stub
				return c2.getStudents().size() - c1.getStudents().size();
			}

		});
		for (Course course : courses) {
			if (course.getType().equals(type)) {
				re.add(course);
			}

		}
		return re;
	}

}
