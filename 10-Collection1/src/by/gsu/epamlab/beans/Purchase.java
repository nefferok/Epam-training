package by.gsu.epamlab.beans;

import by.Constants;

public class Purchase {
	
	private final String name;
	private final Byn byn;
	private int number;
	
	public Purchase() {
		this.name = "";
		this.byn = new Byn();
	}
	
	public Purchase(String name, Byn byn, int number) {
		this.name = name;
		this.byn = byn;
		this.number = number;
	}
	
	public Purchase(String name, int byn, int number) {
		this(name, new Byn(byn), number);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String newName) {
		new Purchase(newName, byn, number);
	}

	public Byn getByn() {
		return byn;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public Byn getCost() {
		return byn.mul(number);
	}
	
	@Override
	public final int hashCode() {
		final int prime = Constants.PRIME_COLLISION;
		int result = Constants.START_HASH_RES;
		result = prime * result + ((byn == null) ? 0 : byn.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public final boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Purchase))
			return false;
		Purchase other = (Purchase) obj;
		if (byn == null) {
			if (other.byn != null)
				return false;		
		} else if (!byn.equals(other.byn))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	protected String fieldsToString() {
		return 	name + Constants.DELIMITER	+
				byn + Constants.DELIMITER +
				number;
	}
	
	@Override
	public String toString() {
		return 	fieldsToString() + Constants.DELIMITER +
				getCost();
	}
}
