package by.gsu.epamlab.beans;

import by.Constants;

public class SegmentCounter {
	private final int len;
	private int num;
	
	public SegmentCounter(int len, int num) {
		this.len = len;
		this.num = num;
	}
	
	public int getLen() {
		return len;
	}

	public int getNum() {
		return num;
	}
	
	@Override
	public String toString() {
		return len + Constants.DELIMITER + num;
	}
	
}
