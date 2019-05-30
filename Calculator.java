
public class Calculator {


//-------------- FUNCTIONS ----------------
	
	// Exponent (e^x)
	public float exponent(int n, float x){
			
		float result = 1;
		
		for (int i = 0 ; i < n ; ++i) {
			 result =  1 + x/(n-i) * result ;
			}
		
		return result;
	}

	//	10^x	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public float TenPower(float n){

		float result = 1;

		if (n == 0)
			return result;

		boolean isNegative = false;

		if (n < 0){
			isNegative = true;
			n *= -1;
		}

		String text = Float.toString(n);
		int numbWhole = text.indexOf('.');
		int numbDeci = text.length() - numbWhole - 1;

		//System.out.println(text + "\tnumbDeci: " + numbDeci);

		int maxDigits = 1;

		for (int i = 0 ; i < numbDeci; ++i)
			maxDigits *= 10;

		//System.out.println("maxDigits: " + maxDigits);

		int numerator = (int) (n * maxDigits);
		int denominator = maxDigits;

		//System.out.println("Fraction: " + numerator + "/" + denominator + "\tDecimal: " + (float) numerator/denominator);

		int whole = 0;

		while (numerator >= denominator){

			whole++;

			numerator -= denominator;

		}

		int decimal = numerator;

		//System.out.println("Whole: " + whole + "\tDecimal: " + decimal);


		result = (float) Power(10, whole);

		//System.out.println("\nRemaining Fraction:" + decimal + "/" + denominator);

		float nextPart = 1;

		double nRoot = FindNthRoot(10, denominator);

		//System.out.println("\nnRoot: " + nRoot);

		//nextPart = nRoot;

		//System.out.println("Decimal: " + decimal);

		for (int i = 0; i < decimal; i++)
			nextPart *= nRoot;

		//System.out.println("nextPart: " + nextPart);

		result *= nextPart;

		if (isNegative)
			result = 1/result;

		return  result;
	}

	public double Power(double base, int expo) {

		if(expo == 0)
			return 1;

		return base * Power(base, expo-1);
	}

	private double FindNthRoot(double base, int expo) {

		double x = 1;
		boolean accurate = false;

		while (!accurate) {
			double y = (1 / (double) expo) * ((expo - 1) * x + base / Power(x, expo - 1));
			accurate = Accuracy(x, y);
			x = y;
		}

		return x;
	}

	private boolean Accuracy(double x, double y) {

		double result = y - x;

		if (result < 0)
			result *= -1;

		return result < 0.000001;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////




		
	

}
