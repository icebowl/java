//code by CW Coleman
//save as JuliaPlotI.java
//java JuliaPlotI .34567 .5 0  10 20 30 10 20 30 600
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MandelJuliaBW extends JFrame {
   public MandelJuliaBW()
   {
      super( "Julia Set" );
      setSize(1000,1000);
      setVisible( true );
   }

   public void paint( Graphics g ){
        // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		    // only change code below this line
        // double c1 c2 limit int ired, igreen, iblue,redAjust, greenAjust, blueAjust
      //  double c1 = 0.36;
    //    double c2 = 0.545;
    //    double  limit = 10;

      //  int ired, igreen, iblue,redAjust, greenAjust, blueAjust;

	      int i,j;
        int k = 0;
	      double x,y,x1,x2,y1,z;
		    double id, jd;
		    int iterations = 1000;
        // plot mandelbot
        ////////////////////////////////
        boolean first = true;
        g.setColor(new Color(255,255,255));
        g.fillRect(0,0,1000,1000);
        int scale = 250;
        for (i = 0 ; i < 1000 ; i++) {
          first = true;
          id = (double) i;
          x1 = (id - 500) / scale;
            for (j = 0; j < 501; j++){
              jd = (double) j;
              y1 = (500 - jd  ) / scale;
              c1 = x1;
              c2 = y1;
              x = 0;y= 0;
              z = 0.0;
              k = 0;
              do {
                x2 = (x * x) - (y * y) + c1;
                y = (2 * x * y) + c2;
                x = x2;
                z = (x * x) + (y * y);
                k++;
              }while ((k < iterations) & (z < 4.0));
            //  System.out.println(x1+" - "+y1);
                if (k >= limit) {
                  System.out.println(x1+" "+y1+" "+first);
                  g.setColor(new Color(127,127,127));
                  if (first) { first = false; g.setColor(new Color(0,0,255));}
                  g.drawLine(i,j,i,j);
                }
            }//end for i
            }//end for j
// wait
try
{
    Thread.sleep(5000);
}
catch(InterruptedException ex)
{
    Thread.currentThread().interrupt();
}
//
        // plot julia
/*
        g.setColor(new Color(255,255,255));
  			g.fillRect(0,0,1000,1000);

		for (j = 0 ; j < 1000 ; j++) {
			jd = (double) j;
			y1 = (1000 - jd) / scale;
				for (i = 0; i < 500; i++){
					id = (double) i;
					x1 = (id - 500) / scale;
					x = x1;
					y = y1;
					z = 0.0;
					k = 0;
					do {
						x2 = (x * x) - (y * y) + c1;
						y = (2 * x * y) + c2;
						x = x2;
						z = (x * x) + (y * y);
						k++;
					}while ((k < iterations) & (z < 4.0));
						if (k > limit) {
							g.setColor(new Color(0,0,0));
							g.drawLine(i,j,i,j);
						}
	    	}//end for i
        }//end for j
      // only change code above this line
      // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
      */
  }
// execute application
// globals
//double c1, c2, limit, int ired, igreen, iblue,redAjust, greenAjust, blueAjust
static double c1;
static double c2 ;
static double  limit;
static int iterations;
static int scale ;
//
  public static void main( String a[] ){
    limit = Double.parseDouble(a[0]);
    iterations =  Integer.parseInt(a[1]);
    scale = Integer.parseInt(a[2]);

    MandelJuliaBW myobject = new MandelJuliaBW();//change this
  	   	// adapter to handle only windowClosing event
        myobject.addWindowListener(
  			   new WindowAdapter() {
				      public void windowClosing( WindowEvent event )
				          {System.exit( 0 );}
                }  // end WindowAdapter
        ); // end call to addWindowListener
   }//end main
 }// end class Painter
