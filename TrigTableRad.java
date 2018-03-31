
class TrigTableRad {

	public static void main (String args[]){
		double c,s,t; //temp double for cosine, sine and tangent so they can be rounded
		int d = 0; // degrees
		double r =0 ;// radian measure
		double pi = 3.141592;
		double i = (pi/12);  //increment r 15 degrees equals pi radians
		String undefined = "UN";
		System.out.println("radian measurement is represented as rad");
		System.out.println("\t\t rad \t\t| cos(radian) \t\t| sin(rad) \t\t|   tan(rad)" );
		while (r <= (2*pi)){
			//convert angle t to radians r
			c = Math.cos(r);
			s = Math.sin(r); 
			t = Math.tan(r);
			System.out.println("\t\t"+r+ "\t\t | "+ c +"\t\t "+ s + " \t\t " + t);
			r = r + i;		
		}
	}
}
