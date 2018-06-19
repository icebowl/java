//https://github.com/icebowl/java.git
//Algorithm by Craig Coleman
// I did not look at any Ulam Spiral algorithms before I developed this.
// Plese give me credit if you use this

import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;


class IsPrime {
	boolean prime;
			int  d;// x is the number to check to be prime
			double dn;
			int pivot;
	boolean isprime (int n){
		prime = true;//assume value is prime	
		pivot = (int)Math.sqrt(n);
			for (d = 2; d < pivot+1;d ++){
				dn = d;
				if ((n % 2 == 0) && (n > 2)) {prime = false; break;} 
				if ((n / dn) == (n / d)) {prime = false; break;}
			}
			if (prime) {
			//System.out.print(n + " ");
		}
		return prime;
	}
}//end class IsPrime

public class UlamPlotScale extends JFrame { //change the name of class to match the name of the java file
	//  Use proper namesapce .  The name of the class should be capitalized.
	
   public UlamPlotScale()
   {
      super( "Ulam Spiral Scaled" );
      setSize(800,800);  
      setVisible( true );   
   }

   public void paint( Graphics g )
   {
	int scale = 31;
	boolean checkPrime;
	IsPrime is = new IsPrime();
	int checkPrimes = 0;
	int modPrimes = 0;
	int nx,ny,count;
	int red = 0, green = 0, blue = 0;
	g.setColor(new Color(0,64,0));	g.fillRect(0,0,800,800);
	//g.setColor(new Color(red,green,blue));g.fillOval(nx,ny,5,5);
	// code from the tty debug
		int x = 0, y = 0,  e; // e is the end state of nlogic;
		int h = 0, k = 0;
		int parity = -1;//parity 0 + 1 
		int parityMOD = 4;
		int n, nlogic =0;
		n = 1;
		//System.out.println("n:"+n+" x:"+x+" y:"+y+" h:"+h+" k:"+k+" nlogic "+nlogic+" parity:"+parity);
			g.setColor(new Color(255,255,255));
			g.fillRect(h+400,400-k,scale,scale);
			//g.drawLine(h+400,400-k,h+400,400-k);
			
		for (e = 1;e < 1000;e++){
			parity = -parity;
			//System.out.println (e + " e ***************************");
			nlogic = 0;
			for (x = 0; x < e; x++){
				g.setColor(new Color(255,255,255));
				g.drawRect(h+400,400-k,scale,scale);
				h = h + (parity*scale);
					n++;
					
				//System.out.println("n:"+n+" x:"+x+" y:"+y+" h:"+h+" k:"+k+" nlogic "+nlogic+" parity:"+parity);
				
				checkPrime = is.isprime(n);
				if (checkPrime) 
				{	checkPrimes++;
					modPrimes = checkPrimes % 4;
						//System.out.print (modPrimes+" ");
					switch(modPrimes){
					case 0:
						 g.setColor(new Color(255,0,0));
					break;
					case 1:
						 g.setColor(new Color(0,255,0));
					break;
					case 2:
						 g.setColor(new Color(0,0,255));
					break;
					case 3:
						g.setColor(new Color(255,255,0));
					break;
					
				}//end select
						g.setColor(new Color(255,255,0));
				//	g.drawLine(h+400,400-k,h+400,400-k);
					g.fillRect(h+400,400-k,scale,scale);
				}
		}
			nlogic =1;
			for (y = 0; y < e; y++){
				g.setColor(new Color(255,255,255));
				g.drawRect(h+400,400-k,scale,scale);
					k = k + (parity*scale);
					n++;
		//System.out.println("n:"+n+" x:"+x+" y:"+y+" h:"+h+" k:"+k+" nlogic "+nlogic+" parity:"+parity);
		
		checkPrime = is.isprime(n);
				if (checkPrime)
				{	checkPrimes++;
					modPrimes = checkPrimes % 4;
				//	System.out.print (modPrimes+" ");
					switch(modPrimes){
					case 0:
						 g.setColor(new Color(255,0,0));
					break;
					case 1:
						 g.setColor(new Color(0,255,0));
					break;
					case 2:
						 g.setColor(new Color(0,0,255));
					break;
					case 3:
						g.setColor(new Color(255,255,0));
					break;
				}
						g.setColor(new Color(255,255,0));
					//g.drawLine(h+400,400-k,h+400,400-k);
					g.fillRect(h+400,400-k,scale,scale);
				}
			}
				
	
		}

		g.setColor(new Color(red,green,blue));g.drawLine(0,0,0,0);
	
	
	}//end paint
  // execute application
   public static void main( String args[] )
   {
	   UlamPlotScale ulamobject = new  UlamPlotScale();//change this to match the name of the file and class
	 
	   	// adapter to handle only windowClosing event
		ulamobject.addWindowListener(
			new WindowAdapter() {
				public void windowClosing( WindowEvent event )
				{System.exit( 0 );}
			}  // end anonymous inner class
		); // end call to addWindowListener
   }
}
