package by.gsu.epamlab;

import java.util.Scanner;

public class Purchase {
	
	private String name;
	private Byn byn;
	private int number;
	
	public Purchase() {
		this.byn = new Byn();
	}
	
	public Purchase(String name, Byn byn, int number) {
		this.name = name;
		this.byn = byn;
		this.number = number;
	}
	public Purchase(Scanner scanner) {
		this.name = scanner.next();
		this.byn = new Byn(scanner);
		this.number = scanner.nextInt();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Byn getByn() {
		return byn;
	}

	public void setByn(Byn byn) {
		this.byn = byn;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public Byn getCost() {
		return (new Byn(byn)).mul(number);
	}
	
	@Override
	public boolean equals(Object obj) {
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
		return 	name + ";"	+
				byn + ";" +
				number;
	}
	
	@Override
	public String toString() {
		return 	fieldsToString() + ";" +
				getCost();
	}
}
