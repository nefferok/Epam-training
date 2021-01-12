package by.gsu.epamlab.beans;

import java.util.Formatter;

import by.Constants;
import by.gsu.epamlab.exceptions.NegativeArgumentExceprion;
import by.gsu.epamlab.exceptions.NonPositiveArgumentException;
import by.gsu.epamlab.exceptions.NumField;
import by.gsu.epamlab.preferenses.Format;

public class Purchase {

	private String name;
	private Byn byn;
	private int number;

	public Purchase() {
		this.byn = new Byn();
	}

	public Purchase(String name, Byn byn, int number) {
		setName(name);
		setByn(byn);
		setNumber(number);
	}

	public Purchase(String name, int byn, int number) {
		try {
			setName(name);
			setByn(new Byn(byn));
			setNumber(number);
		} catch (NegativeArgumentExceprion e) {
			e.setField(NumField.PRICE);
			throw e;
		}
	}

	public Purchase(Purchase purchase) {
		this(purchase.name, purchase.byn, purchase.number);
	}

	public String getName() {
		return name;
	}

	public final void setName(String name) {
		if (name.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.name = name;
	}

	public Byn getByn() {
		return byn;
	}

	public void setByn(Byn byn){
		try {
			if (byn.equals(new Byn())) {
				throw new NonPositiveArgumentException(NumField.PRICE, Constants.ZERO);
			}
			this.byn = new Byn(byn);
		} catch (NegativeArgumentExceprion e) {
			e.setField(NumField.PRICE);
			throw e;
		}
	}

	public int getNumber() {
		return number;
	}

	public final void setNumber(int number) {
		if (number == Constants.ZERO) {
			throw new NonPositiveArgumentException(NumField.NUMBER, number);
		}
		if (number < Constants.ZERO) {
			throw new NegativeArgumentExceprion(NumField.NUMBER, number);
		}
		this.number = number;
	}

	public Purchase getCopy() {
		return new Purchase(this);
	}

	public Byn getCost() {
		return byn.mul(number);
	}

	@SuppressWarnings("resource")
	public String toTable() {
		Formatter f = new Formatter().format(Format.additionalFieldsFormat(), Constants.STUB, getCost());
		StringBuilder line = fieldsToTable().append(f);
		f.close();
		return line.toString();
	}

	@SuppressWarnings("resource")
	protected StringBuilder fieldsToTable() {
		Formatter f = new Formatter().format(Format.purchaseFieldsFormat(), name, byn, number);
		StringBuilder line = new StringBuilder().append(f);
		f.close();
		return line;
	}

	protected String fieldsToString() {
		return name + Constants.SPLITTER + byn + Constants.SPLITTER + number;
	}

	@Override
	public String toString() {
		return fieldsToString() + Constants.SPLITTER + getCost();
	}
}
