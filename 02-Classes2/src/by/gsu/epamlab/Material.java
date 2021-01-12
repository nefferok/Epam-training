package by.gsu.epamlab;

public enum Material {
	STEEL (7850.0),
	COPPER (8500.0);

	private double density;
	
	private Material(double density) {
		this.density = density;
	}

	public String getName() {
		return name().toLowerCase();
	}

	public double getDensity() {
		return density;
	}	

    @Override
    public String toString() {
        return getName() + ";" + density;
    }
}
