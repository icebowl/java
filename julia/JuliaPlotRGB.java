//code by CW Coleman
//save as JuliaPlotRGB.java
//java JuliaPlotRGB .345 .567 0 1000 20 250
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class JuliaPlotRGB extends JFrame {
   public JuliaPlotRGB()
   {
      super( "Julia Set" );
      setSize(1020,1000);
      setVisible( true );
   }
// ColorArray
class ColorArray{
		int rgb[][] = new int[3][256]; 
		int[][] color(){
		int i;
		// -- build array
		double startR,endR, startG,endG, startB, endB;
		double redD, greenD, blueD;
		startR = (double)(Math.random() *256); endR = (255 - startR);	  
		startG = (double)(Math.random() *256); endG = (255- startG);	
		startB = (double)(Math.random() *256); endB = (255 - startB);	
		redD = (endR - startR)/ colors;
		greenD = (endG - startG)/colors;
		blueD = (endB - startB)/colors;

		 
		for (i = 0; i < 256;i++){	
			rgb[0][i] = (int)startR;
			rgb[1][i] = (int)startG;
			rgb[2][i] = (int)startB;
			
		
			startR = startR + redD;
			startG = startG +greenD;
			startB = startB +blueD;
			// System.out.println(startR+" \t"+startG+"\t"+startB);
			
			if (startR > 255) startR = 0;if (startR < 0) startR = 255;
			if (startG > 255) startG = 0;if (startG < 0) startG = 255;
			if (startB > 255) startB = 0;if (startB < 0) startB =  255;
		}
		return rgb;
	}
	
}//end color
   

public void paint( Graphics g ){
	// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	//	initialize rgb[][]
	int rgb[][] = new int[3][256]; 
	ColorArray ca = new ColorArray();
	rgb = ca.color();
		int red,green,blue;
		int mc; //modcolor
		//
        int mcolor = 0;
	      int i,j;
        int k = 0;
	      double x,y,x1,x2,y1,z;
		    double id, jd;
		    int iterations = iterationvalue;
			g.setColor(new Color(255,255,255));
  			g.fillRect(0,0,1000,1000);
  			// display colors
  			for (j = 0; j < 256; j++){
				red = rgb[0][j];
				green= rgb[1][j];
				blue = rgb[2][j];
				g.setColor(new Color(red,green,blue));
							g.drawLine(1001,j+100,1020,j+100);
			}
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
					}while ((k <= iterations) & (z < 4.0));
						if (k >= limit) {
            //  mcolor = k % modvalue;
              //g.setColor(new Color(ared[mcolor],agreen[mcolor],ablue[mcolor]));
              g.setColor(new Color(0,0,0));
				mc = k%colors;
				red = rgb[0][mc];
				green= rgb[1][mc];
				blue = rgb[2][mc];
				//System.out.print(" "+mc);
				g.setColor(new Color(red,green,blue));
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
      static int colors;
      public static void main( String a[] ){
          c1 = Double.parseDouble(a[0]);
          c2 = Double.parseDouble(a[1]);
          limit = Double.parseDouble(a[2]);
          iterationvalue = Integer.parseInt(a[3]);
          colors = Integer.parseInt(a[4]);
          scale = Integer.parseInt(a[5]);

          JuliaPlotRGB myobject = new JuliaPlotRGB();//change this
        	   	// adapter to handle only windowClosing event
            myobject.addWindowListener(
        			   new WindowAdapter() {
      				      public void windowClosing( WindowEvent event )
      				          {System.exit( 0 );}
                      }  // end WindowAdapter
          ); // end call to addWindowListener
   }//end main
 }// end class Painter
