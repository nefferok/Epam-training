package by.gsu.epamlab;

public final class Product {
	private final String name;
	private final Byn price;
	
	public Product() {
		this(null, new Byn());
	}

	public Product(String name, Byn price) {
		this.name = name;
		this.price = price;
	}
	
	public Product(String name, int price) {
		this.name = name;
		this.price = new Byn(price);
	}

	public String getName() {
		return name;
	}

	public Byn getPrice() {
		return new Byn(price);
	}

	@Override
	public String toString() {
		return name + ";" + price;
	}	
}
