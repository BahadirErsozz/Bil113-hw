
public class ComplexNumber{
	private int realNumerator, realDenominator, imagNumerator, imagDenominator;
	
	public ComplexNumber(String complexNumber)
	{
		// +5/3-5/7i or +5/3+5/7i
		this.realNumerator = Integer.parseInt(complexNumber.substring(0,complexNumber.indexOf('/')));
		// 3-5/7i or 3+5/7i
		complexNumber = complexNumber.substring(complexNumber.indexOf('/') + 1);
		this.realDenominator = (complexNumber.contains("+")) ? Integer.parseInt(complexNumber.substring(0,complexNumber.indexOf('+'))) : Integer.parseInt(complexNumber.substring(0,complexNumber.indexOf('-')));
		
		this.imagNumerator = (complexNumber.contains("+")) ? Integer.parseInt(complexNumber.substring(complexNumber.indexOf('+'), complexNumber.indexOf('/'))): Integer.parseInt(complexNumber.substring(complexNumber.indexOf('-'), complexNumber.indexOf('/')));	
		
		this.imagDenominator = Integer.parseInt(complexNumber.substring(complexNumber.indexOf('/') + 1, complexNumber.indexOf('i')));
	}
	
	public ComplexNumber(FractionalNumber fn1, FractionalNumber fn2)
	{
		this.realNumerator = fn1.getNumerator();
		this.realDenominator = fn1.getDenominator();
		this.imagNumerator = fn2.getNumerator();
		this.imagDenominator = fn2.getDenominator();
	}
	
	public String toString()
	{	
		return (imagNumerator >= 0) ? (realNumerator + "/" + realDenominator + "+" + imagNumerator + "/" + imagDenominator) : (realNumerator + "/" + realDenominator + "" + imagNumerator + "/" + imagDenominator);
	}
	
	public boolean equals(ComplexNumber cn)
	{
		return this.realNumerator == cn.realNumerator && this.realDenominator == cn.realDenominator && this.imagNumerator == cn.imagNumerator && this.imagDenominator == cn.imagDenominator;
	}
	
	public static ComplexNumber simplify(ComplexNumber cn)
	{
		FractionalNumber fn1 = new FractionalNumber(cn.realNumerator, cn.realDenominator);
		FractionalNumber fn2 = new FractionalNumber(cn.imagNumerator, cn.imagDenominator);
		fn1 = FractionalNumber.simplify(fn1);
		fn2 = FractionalNumber.simplify(fn2);
		
		ComplexNumber cn1 = new ComplexNumber(fn1, fn2);
		
		return cn1;
	}	
	
	public static ComplexNumber add(ComplexNumber cn1, ComplexNumber cn2)
	{
		FractionalNumber fn1Real = new FractionalNumber(cn1.realNumerator, cn1.realDenominator);
		FractionalNumber fn1Imag = new FractionalNumber(cn1.imagNumerator, cn1.imagDenominator);
		FractionalNumber fn2Real = new FractionalNumber(cn2.realNumerator, cn2.realDenominator);
		FractionalNumber fn2Imag = new FractionalNumber(cn2.imagNumerator, cn2.imagDenominator);
		
		ComplexNumber cn3 = new ComplexNumber(FractionalNumber.add(fn1Real, fn2Real), FractionalNumber.add(fn1Imag, fn2Imag));
		return cn3;
	}
	
	public static ComplexNumber subtract(ComplexNumber cn1, ComplexNumber cn2)
	{
		FractionalNumber fn1Real = new FractionalNumber(cn1.realNumerator, cn1.realDenominator);
		FractionalNumber fn1Imag = new FractionalNumber(cn1.imagNumerator, cn1.imagDenominator);
		FractionalNumber fn2Real = new FractionalNumber(cn2.realNumerator, cn2.realDenominator);
		FractionalNumber fn2Imag = new FractionalNumber(cn2.imagNumerator, cn2.imagDenominator);
		
		ComplexNumber cn3 = new ComplexNumber(FractionalNumber.subtract(fn1Real, fn2Real), FractionalNumber.subtract(fn1Imag, fn2Imag));
		return cn3;
	}
	
	public static ComplexNumber multiply(ComplexNumber cn1, ComplexNumber cn2)
	{ 
		// (3+5i) * (5-7i) = 3*5 - 3*7i + 5i*5 - 5i*7i
		FractionalNumber fn1Real = new FractionalNumber(cn1.realNumerator, cn1.realDenominator);
		FractionalNumber fn1Imag = new FractionalNumber(cn1.imagNumerator, cn1.imagDenominator);
		FractionalNumber fn2Real = new FractionalNumber(cn2.realNumerator, cn2.realDenominator);
		FractionalNumber fn2Imag = new FractionalNumber(cn2.imagNumerator, cn2.imagDenominator);
		FractionalNumber fn1ImagNeg = new FractionalNumber(cn1.imagNumerator * -1, cn1.imagDenominator);
		
		ComplexNumber cn3 = new ComplexNumber(FractionalNumber.add(FractionalNumber.multiply(fn1Real, fn2Real), FractionalNumber.multiply(fn1ImagNeg, fn2Imag)), FractionalNumber.add(FractionalNumber.multiply(fn1Real, fn2Imag), FractionalNumber.multiply(fn2Real, fn1Imag))); 
		return cn3;
	}
	
	public static ComplexNumber divide(ComplexNumber cn1, ComplexNumber cn2)
	{
		// (3+5i)      (3+5i) * (5+3i)      ComplexNumber.multiply()
		// ------  =   ---------------  =   ----------------------
		// (5-3i)      (5-3i) * (5+3i)          5 * 5 + 3 * 3
		FractionalNumber fn1Real = new FractionalNumber(cn1.realNumerator, cn1.realDenominator);
		FractionalNumber fn1Imag = new FractionalNumber(cn1.imagNumerator, cn1.imagDenominator);
		FractionalNumber fn2Real = new FractionalNumber(cn2.realNumerator, cn2.realDenominator);
		FractionalNumber fn2Imag = new FractionalNumber(cn2.imagNumerator, cn2.imagDenominator);
		FractionalNumber fn2ConjReal = new FractionalNumber(cn2.realNumerator, cn2.realDenominator);
		FractionalNumber fn2ConjImag = new FractionalNumber(cn2.imagNumerator * -1, cn2.imagDenominator);
		
		ComplexNumber cn3 = new ComplexNumber(fn1Real, fn1Imag);
		ComplexNumber cn4 = new ComplexNumber(fn2Real, fn2Imag);
		ComplexNumber cn5 = new ComplexNumber(fn2ConjReal, fn2ConjImag);
		// upper part ComplexNumber.multiply()
		ComplexNumber cn6 = ComplexNumber.multiply(cn3, cn5);
		FractionalNumber fn3Real = new FractionalNumber(cn6.realNumerator, cn6.realDenominator);
		FractionalNumber fn3Imag = new FractionalNumber(cn6.imagNumerator, cn6.imagDenominator);
		FractionalNumber fn4 = FractionalNumber.add(FractionalNumber.multiply(fn2Real, fn2Real), FractionalNumber.multiply(fn2Imag, fn2Imag));
		cn6 = new ComplexNumber(FractionalNumber.divide(fn3Real, fn4), FractionalNumber.divide(fn3Imag, fn4));
		return cn6;
	}
}
