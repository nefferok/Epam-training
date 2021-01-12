package by.gsu.epamlab;

public enum WeekDay {
	SUNDAY, MONDAY,	TUESDAY, WEDNESDAY,	THURSDAY, FRIDAY, SATURDAY;

	@Override
	public String toString() {
		return name().substring(0, 1) + name().substring(1).toLowerCase();
	}
}
