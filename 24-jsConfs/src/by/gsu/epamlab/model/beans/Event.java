package by.gsu.epamlab.model.beans;

public class Event {
	private int id;
	private String name;
	private String time;

	public Event(int id, String name, String time) {
		super();
		this.id = id;
		this.name = name;
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getTime() {
		return time;
	}

	public String toString() {
		return String.format("%d, %s, %s", id, name, time);
	}

}
