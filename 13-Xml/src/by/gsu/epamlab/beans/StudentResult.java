package by.gsu.epamlab.beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static by.Constants.*;

public class StudentResult {
	private static final SimpleDateFormat IN_FORMATTER = new SimpleDateFormat(IN_FORMAT);
	private static final SimpleDateFormat OUT_FORMATTER = new SimpleDateFormat(OUT_FORMAT);

	private String login;
	private String test;
	private Date date;
	private int mark;

	public StudentResult(String login, String test, String date, String mark) {
		try {
			this.login = login;
			this.test = test;
			this.date = IN_FORMATTER.parse(date);
			String[] elements = mark.split(SPLITTER);
			this.mark = (Integer.parseInt(elements[WHOLE_PART])) * FRACTION
					+ Integer.parseInt(elements[FRACTIONAL_PART]);
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}
	}

	public StudentResult() {
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	private String getStringMark() {
		return String.format(MARK_FORMAT, mark / FRACTION, mark % FRACTION);
	}

	private String getStringDate() {
		if (date != null) {
			return OUT_FORMATTER.format(date);
		}
		return null;
	}

	@Override
	public String toString() {
		return login + DELIMITER + test + DELIMITER + getStringDate() + DELIMITER + getStringMark();
	}

}
