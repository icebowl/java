class FactObj {

	double factMethod(double n) {    
    // Basic Case to stop the recursion
	if (n<=1)  {
        return 1;
    } else {
         return(n*(factMethod(n-1)));
    }
}
}

class Factorial{
	public static void main(String[] args) {
		double n = 52.0;
		FactObj f = new FactObj();
		double factvalue = f.factMethod(n);
		 System.out.println(factvalue);
	}
}
