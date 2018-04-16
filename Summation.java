class SumObj {

	double sumMethod(double n) {    
    // Basic Case to stop the recursion
	if (n<=1)  {
        return 1;
    } else {
         return(n+(sumMethod(n-1)));
    }
}
}

class Summation{
	public static void main(String[] args) {
		double sumvalue = 0;
		double n = 1000.0;
		SumObj s = new SumObj();
		sumvalue = s.sumMethod(n);
		 System.out.println(sumvalue);
	}
}
