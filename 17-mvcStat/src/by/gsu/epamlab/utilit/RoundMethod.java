package by.gsu.epamlab.utilit;

public enum RoundMethod {
	FLOOR {
		double roundFunction (double d) {
			return Math.floor(d);
		}
	},
	CEIL {
		double roundFunction (double d) {
			return Math.ceil(d);
		}
	},
	ROUND {
		double roundFunction (double d) {
			return Math.round(d);
		}		
	};
	abstract double roundFunction(double d);
	
	public double round(double roundedValue, int d) {
		int[] pow = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};
		int tenPow = pow[d];
		return roundFunction(roundedValue * tenPow) / tenPow;
	}
}