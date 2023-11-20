package Lab_09_Task1;

import java.util.List;

public class Course {
	private String id; // ma so
	private String title; // tieu de
	private String type; // loai:TH or LT
	private List<Student> students; // ds sinh vien
	private String lecturer; // giang vien

	public Course(String id, String title, String type, List<Student> students, String lecturer) {
		super();
		this.id = id;
		this.title = title;
		this.type = type;
		this.students = students;
		this.lecturer = lecturer;
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getType() {
		return type;
	}

	public List<Student> getStudents() {
		return students;
	}

	public String getLecturer() {
		return lecturer;
	}

}
