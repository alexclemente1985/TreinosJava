package utils;

public class CurrencyConverter {
	public static final double IOF = 0.06;
	
	private static double converter(double cot, double dollar) {
		double reals = dollar*IOF + dollar;
		
		return reals*cot;
	}
	
	public static String showConversion(double cot, double dollar) {
		return "Amount to be paid in reals = "+String.format("%.2f", converter(cot,dollar));
	}
}
