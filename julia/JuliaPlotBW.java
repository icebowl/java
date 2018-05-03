//code by CW Coleman
//save as JuliaPlotI.java
//java JuliaPlotI .34567 .5 0  10 20 30 10 20 30 600
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JuliaPlotBW extends JFrame {
   public JuliaPlotBW()
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

        int mcolor = 0;
	      int i,j;
        int k = 0;
	      double x,y,x1,x2,y1,z;
		    double id, jd;
		    int iterations = iterationvalue;
        g.setColor(new Color(255,255,255));
  			g.fillRect(0,0,1000,1000);
        // build colors
    // just plot the julia set
		for (j = 0 ; j < 1000 ; j++) {
			jd = (double) j;
			y1 = (500 - jd) / scale;
				for (i = 0; i < 1000; i++){
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
            //  mcolor = k % modvalue;
              //g.setColor(new Color(ared[mcolor],agreen[mcolor],ablue[mcolor]));
              g.setColor(new Color(0,0,0));
							g.drawLine(i,j,i,j);
						}
	    	}//end for i
        }//end for j
      // only change code above this line
      // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
  }
      // execute application
      // globals
      //double c1, c2, limit, int ired, igreen, iblue,redAjust, greenAjust, blueAjust
      static double c1;
      static double c2 ;
      static double  limit;
      static int ired, igreen, iblue;
      static int scale ;
      static int iterationvalue;
      public static void main( String a[] ){
          c1 = Double.parseDouble(a[0]);
          c2 = Double.parseDouble(a[1]);
          limit = Double.parseDouble(a[2]);
          iterationvalue = Integer.parseInt(a[3]);
          scale = Integer.parseInt(a[4]);
          JuliaPlotBW myobject = new JuliaPlotBW();//change this
        	   	// adapter to handle only windowClosing event
            myobject.addWindowListener(
        			   new WindowAdapter() {
      				      public void windowClosing( WindowEvent event )
      				          {System.exit( 0 );}
                      }  // end WindowAdapter
          ); // end call to addWindowListener
   }//end main
 }// end class Painter
