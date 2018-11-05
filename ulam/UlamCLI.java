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

public class UlamCLI extends JFrame { //change the name of class to match the name of the java file
	//  Use proper namesapce .  The name of the class should be capitalized.

   public UlamCLI()
   {
      super( "Ulam Spiral Scaled" );
      setSize(800,800);
      setVisible( true );
   }

   public void paint( Graphics g )
   {
	//int scale = 3;
	int count = 0;
	boolean checkPrime;
	IsPrime is = new IsPrime();
	int checkPrimes = 0;
	int modPrimes = 0;
	int nx,ny;
	int red = 0, green = 0, blue = 0;
	g.setColor(new Color(0,43,54));	g.fillRect(0,0,800,800);
	//g.setColor(new Color(red,green,blue));g.fillOval(nx,ny,5,5);
	// code from the tty debug
		int x = 0, y = 0,  e; // e is the end state of nlogic;
		int h = 0, k = 0;
		int parity = -1;//parity 0 + 1
		int parityMOD = 4;
		int n, nlogic =0;
		n = 1;
		//System.out.println("n:"+n+" x:"+x+" y:"+y+" h:"+h+" k:"+k+" nlogic "+nlogic+" parity:"+parity);
			g.setColor(new Color(113,176,159));
			g.fillRect(h+400,400-k,scale,scale);
			//g.drawLine(h+400,400-k,h+400,400-k);

		for (e = 1;e < 1000;e++){
			parity = -parity;
			//System.out.println (e + " e ***************************");
			nlogic = 0;
			for (x = 0; x < e; x++){
				g.setColor(new Color(0,43,54));
				g.drawRect(h+400,400-k,scale,scale);
				h = h + (parity*scale);
					n++;
				//System.out.println("n:"+n+" x:"+x+" y:"+y+" h:"+h+" k:"+k+" nlogic "+nlogic+" parity:"+parity);
				checkPrime = is.isprime(n);
				if (checkPrime)
					{	checkPrimes++;
							//modPrimes = checkPrimes % 14;
							modPrimes = count % 14;
							count++;
						//	System.out.print (modPrimes+" ");
								// 0 base03     0  43  54
								// 1 base02     7  54  66
								// 2 base01    7  88 110
								//	3 base00    101 123 131
								//	4	base0      131 148 150
								// 5		base1      147 161 161
								//	6	base2      238 232 213
								//	7		base3      253 246 227
								// 8		yellow     181 137   0
								//	9	orange     203  75  22
								//	10		red        220  50  47
								//	11	magenta    211  54 130
								//	12		violet     108 113 196
								//	13		blue        38 139 210
								//	14		cyan        42 161 152
								//	15		green      133 153   0
					switch(modPrimes){
						case 0: g.setColor(new Color(7,54,66));break;
						case 1: g.setColor(new Color(7,88,110));break;
						case 2: g.setColor(new Color(101,123,131));break;
						case 3: g.setColor(new Color(131,148,150));break;
						case 4: g.setColor(new Color(147,161,161));break;
						case 5: g.setColor(new Color(238,232,213));break;
						case 6: g.setColor(new Color(252,246,227));break;
						case 7: g.setColor(new Color(181,137,0));break;
						case 8: g.setColor(new Color(203,75,22));break;
						case 9: g.setColor(new Color(220,50,47));break;
						case 10: g.setColor(new Color(211,54,130));break;
						case 11: g.setColor(new Color(108,113,196));break;
						case 12: g.setColor(new Color(38,139,210));break;
						case 13: g.setColor(new Color(42,161,152));break;
						case 14: g.setColor(new Color(133,154,0));break;
				}//end select
						g.setColor(new Color(255,255,255));
					g.drawLine(h+400,400-k,h+401,401-k);
					//g.fillRect(h+400,400-k,scale,scale);
				}
		}
			nlogic =1;
			for (y = 0; y < e; y++){
				g.setColor(new Color(0,43,54));
				g.drawRect(h+400,400-k,scale,scale);
					k = k + (parity*scale);
					n++;
		//System.out.println("n:"+n+" x:"+x+" y:"+y+" h:"+h+" k:"+k+" nlogic "+nlogic+" parity:"+parity);

		checkPrime = is.isprime(n);
				if (checkPrime)
				{	checkPrimes++;
					//modPrimes = checkPrimes % 14;
					modPrimes = count % 14;
					count++;
				//System.out.print (modPrimes+" ");
					switch(modPrimes){
						case 0: g.setColor(new Color(7,54,66));break;
						case 1: g.setColor(new Color(7,88,110));break;
						case 2: g.setColor(new Color(101,123,131));break;
						case 3: g.setColor(new Color(131,148,150));break;
						case 4: g.setColor(new Color(147,161,161));break;
						case 5: g.setColor(new Color(238,232,213));break;
						case 6: g.setColor(new Color(252,246,227));break;
						case 7: g.setColor(new Color(181,137,0));break;
						case 8: g.setColor(new Color(203,75,22));break;
						case 9: g.setColor(new Color(220,50,47));break;
						case 10: g.setColor(new Color(211,54,130));break;
						case 11: g.setColor(new Color(108,113,196));break;
						case 12: g.setColor(new Color(38,139,210));break;
						case 13: g.setColor(new Color(42,161,152));break;
						case 14: g.setColor(new Color(133,154,0));break;
				}
						g.setColor(new Color(255,255,255));
					g.drawLine(h+400,400-k,h+401,401-k);
					//g.fillRect(h+400,400-k,scale,scale);
				}
			}


		}

		g.setColor(new Color(red,green,blue));g.drawLine(0,0,0,0);


	}//end paint
  // execute application
// set globals
	static int scale;
   public static void main( String args[] )
   {
		 scale =  Integer.parseInt(args[0]);
	   UlamCLI ulamobject = new  UlamCLI();//change this to match the name of the file and class

	   	// adapter to handle only windowClosing event
		ulamobject.addWindowListener(
			new WindowAdapter() {
				public void windowClosing( WindowEvent event )
				{System.exit( 0 );}
			}  // end anonymous inner class
		); // end call to addWindowListener
   }
}
