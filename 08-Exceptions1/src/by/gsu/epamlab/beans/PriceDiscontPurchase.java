package by.gsu.epamlab.beans;

import java.util.Formatter;

import by.Constants;
import by.gsu.epamlab.exceptions.NegativeArgumentExceprion;
import by.gsu.epamlab.exceptions.NonPositiveArgumentException;
import by.gsu.epamlab.exceptions.NumField;
import by.gsu.epamlab.preferenses.Format;

public class PriceDiscontPurchase extends Purchase {

	private Byn discount;

	public PriceDiscontPurchase() {
		super();
	}

	public PriceDiscontPurchase(String name, Byn byn, int number, Byn discount) {
		super(name, byn, number);
		setDiscount(discount);
	}

	public PriceDiscontPurchase(String name, int byn, int number, int discount) {
		super(name, byn, number);
		try {
			setDiscount(new Byn(discount));
		} catch (NegativeArgumentExceprion e) {
			e.setField(NumField.DISCOUNT);
			throw e;
		}
	}

	public PriceDiscontPurchase(PriceDiscontPurchase purchase) {
		this(purchase.getName(), purchase.getByn(), purchase.getNumber(), purchase.discount);
	}
	
	public PriceDiscontPurchase getCopy() {
		return new PriceDiscontPurchase(this);
	}

	public Byn getDiscount() {
		return discount;
	}

	public void setDiscount(Byn discount) {
		try {
			if (discount.equals(new Byn())) {
				throw new NonPositiveArgumentException(NumField.DISCOUNT, Constants.ZERO);
			}
			if (super.getByn().compareTo(discount) <= Constants.ZERO) {
				throw new IllegalArgumentException(Constants.NEGATIVE_COST);
			}
			this.discount = discount;
		} catch (NegativeArgumentExceprion e) {
			e.setField(NumField.DISCOUNT);
			throw e;
		}
	}

	@Override
	public Byn getCost() {
		return super.getCost().sub(discount.mul(getNumber()));
	}

	@SuppressWarnings("resource")
	public String toTable() {
		Formatter f = new Formatter().format(Format.additionalFieldsFormat(), discount, getCost());
		StringBuilder line = super.fieldsToTable().append(f);
		f.close();
		return line.toString();
	}

	@Override
	protected String fieldsToString() {
		return super.fieldsToString() + Constants.SPLITTER + discount;
	}

}
