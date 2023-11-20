package Lab_09_Task1;

public class Student {
	private String id; // MSSV
	private String name; // ho ten
	private int year; // nam

	public Student(String id, String name, int year) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getYear() {
		return year;
	}

	@Override
	public String toString() {
		return id + name + year;
	}

}
