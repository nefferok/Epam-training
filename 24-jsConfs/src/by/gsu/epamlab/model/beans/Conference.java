package by.gsu.epamlab.model.beans;

public class Conference {
	private String name;
	private String faculty;
	private String date;

	public Conference(String name, String faculty, String date) {
		super();
		this.name = name;
		this.faculty = faculty;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public String getFaculty() {
		return faculty;
	}

	public String getDate() {
		return date;
	}

	public String toString() {
		return String.format("%s, %s, %s", name, faculty, date);
	}

}
