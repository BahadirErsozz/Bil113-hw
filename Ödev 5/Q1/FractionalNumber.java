public class FractionalNumber{
	public int numerator = 1, denominator = 1;
	

	public FractionalNumber(String someString){
		int indexOfSlash = someString.indexOf("/");
		numerator = Integer.parseInt(someString.substring(0,indexOfSlash));
		denominator = Integer.parseInt(someString.substring(indexOfSlash + 1, someString.length()));
	}	
			
	public FractionalNumber(int numeratorConst, int denominatorConst){
		numerator = numeratorConst;
		denominator = denominatorConst;
	
	}
	
	public double getDoubleValue(){
		double doubleValue = (double)numerator / denominator;
		return doubleValue;
	}
	
	public String toString(){
		return (numerator + "/" + denominator);
	
	}
	
	public boolean equals(FractionalNumber fn){
		
		if (simplify(fn).numerator == simplify(this).numerator && simplify(fn).denominator == simplify(this).denominator){
			return true;
		}
		else 
		return false;
	}
	
	public static FractionalNumber simplify(FractionalNumber fn){
		FractionalNumber fnReturn = new FractionalNumber(1,1);
		fnReturn.numerator = Math.abs(fn.numerator);
		fnReturn.denominator = Math.abs(fn.denominator); 
		boolean isNegative = false;
		int i = 1, greatestDivisor = 1;
		if(fn.numerator == 0){
			fnReturn.denominator = 1;
		}
		else{
			if ((fn.numerator != Math.abs(fn.numerator) && fn.denominator == Math.abs(fn.denominator)) || (fn.numerator == Math.abs(fn.numerator) && fn.denominator != Math.abs(fn.denominator))){
				isNegative = true;
				fnReturn.numerator = Math.abs(fn.numerator);
				fnReturn.denominator = Math.abs(fn.denominator);
			}
			else{
				fnReturn.numerator = Math.abs(fn.numerator);
				fnReturn.denominator = Math.abs(fn.denominator);
				
			}
			while (i <= fnReturn.numerator && i <= fnReturn.denominator){
					if (fnReturn.numerator % i == 0 && fnReturn.denominator % i == 0){
						greatestDivisor = i;					
					}
				
				i++;
				}
			if(isNegative){
				fnReturn.numerator = (Math.abs(fnReturn.numerator) * -1) / greatestDivisor;
				fnReturn.denominator = Math.abs(fnReturn.denominator) / greatestDivisor;
			}
			else{
				fnReturn.numerator = Math.abs(fn.numerator) / greatestDivisor;
				fnReturn.denominator = Math.abs(fn.denominator) / greatestDivisor;
			}
		}
		return fnReturn;
	}

	public static FractionalNumber add(FractionalNumber fn1, FractionalNumber fn2){
		FractionalNumber fnReturn = new FractionalNumber("1/1");
		fnReturn.numerator = (fn1.numerator * fn2.denominator + fn1.denominator * fn2.numerator );
		fnReturn.denominator = fn2.denominator * fn1.denominator;
		return simplify(fnReturn);	
	}

	public static FractionalNumber subtract(FractionalNumber fn1, FractionalNumber fn2){
		FractionalNumber fnReturn = new FractionalNumber("1/1");
		fnReturn.numerator = (fn1.numerator * fn2.denominator - fn1.denominator * fn2.numerator);
		fnReturn.denominator = fn2.denominator * fn1.denominator;
		return simplify(fnReturn);
	
	}

	public static FractionalNumber multiply(FractionalNumber fn1, FractionalNumber fn2){
		FractionalNumber fnReturn = new FractionalNumber("1/1");
		fnReturn.numerator = (fn1.numerator * fn2.numerator );
		fnReturn.denominator = fn2.denominator * fn1.denominator;
		return simplify(fnReturn);
		
	
	}

	public static FractionalNumber divide(FractionalNumber fn1,FractionalNumber fn2){
		FractionalNumber fnReturn = new FractionalNumber("1/1");
		fnReturn.numerator = (fn1.numerator * fn2.denominator );
		fnReturn.denominator = fn2.numerator * fn1.denominator;
		if (fnReturn.denominator == 0)
			return null;
		else	
			return simplify(fnReturn);
	
	}
	
}
