//code by CW Coleman
//save as JuliaPlotI.java
//java JuliaPlotI .34567 .5 0  10 20 30 10 20 30 600
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;

public class MandelJuliaRGB extends JFrame {
  public static int checkPoints (int xyPlot[][], int x, int y){
    int plotit = 0;
    //  if (xyPlot[x][y]=0 && ( xyPlot[x-1][y-1] = 0 || xyPlot[x][y-1] = 0 || xyPlot[x+1][y-1]= 0)) plotit = 1;
  if (xyPlot[x][y]==1 &&
        ( xyPlot[x-1][y-1] ==0 || xyPlot[x][y-1] == 0 || xyPlot[x+1][y-1]==0
          || xyPlot[x-1][y]==0 || xyPlot[x+1][y]==0
            || xyPlot[x-1][y+1]==0 || xyPlot[x][y+1]==0 || xyPlot[x+1][y+1]==0 )) plotit = 1;
   
    if (plotit == 1 &&
        ( xyPlot[x-1][y-1] ==0 || xyPlot[x][y-1] == 0 || xyPlot[x+1][y-1]==0
            || xyPlot[x-1][y+1]==0 || xyPlot[x][y+1]==0 || xyPlot[x+1][y+1]==0 )) {plotit = 1; }
   
   
   
   
   // if (xyPlot[x][y]==1 &&  xyPlot[x][y-1] == 0 ) plotit = 1;
   //if (xyPlot[x][y]==1 &&
   //     ( xyPlot[x-1][y-1] ==0 || xyPlot[x][y-1] == 0 || xyPlot[x+1][y-1]==0)) plotit = 1;
   
   
   
		return plotit;
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
	
}//end ColorArray



   public MandelJuliaRGB()
   {
      super( "Mandelbrot Set" );
      setSize(1200,1000);
      setVisible( true );
   }

	public void paint( Graphics g ){
		Font font = new Font("Serif", Font.PLAIN, 24);
		g.setFont(font);
		
		double xarray[][] = new double[1000][1000];
		double yarray[][] = new double[1000][1000];
		double c1array[] = new double[5000];
		double c2array[] = new double[5000];
		int xyPlot[][] = new int[1000][1000];
		
		int a,b,i,j;
        double c1,c2;
        int loopJulia = 0;
        int c1c2count = 0;
        int plotit = 0;
        int k = 0;
		double x,y,x1,x2,y1,z;
		    double id, jd;
		    int iterations = 1000;
        // initialize xyPlot[][]
        for (i = 0 ; i < 1000 ; i++) {
            for (j = 0; j < 1000; j++){
              xyPlot[i][j] = 0;
            }
        }
        // plot mandelbot
        ////////////////////////////////
        g.setColor(new Color(255,255,255));
        g.fillRect(0,0,1000,1000);
        int scale = 250;
        for (i = 0 ; i < 1000 ; i++) {
          id = (double) i;
          x1 = (id - 500) / scale;
            for (j = 0; j < 1000; j++){
              jd = (double) j;
              y1 = (500 - jd  ) / scale;
              c1 = x1;
              c2 = y1;
              x = 0;y= 0;
              z = 0.0;
              k = 0;
              xarray[i][j] = x1;
              yarray[i][j] = y1;
              do {
                x2 = (x * x) - (y * y) + c1;
                y = (2 * x * y) + c2;
                x = x2;
                z = (x * x) + (y * y);
                k++;
              }while ((k < 1000) & (z < 4.0));
            //  System.out.println(x1+" - "+y1);
                if (k >= 1000) {
                    xyPlot[i][j] = 1;
				//  System.out.println(x1+" "+y1+" plotted");
                  g.setColor(new Color(127,127,127));
                  g.drawLine(i,j,i,j);
                }
            }//end for i
            }//end for j

		for (j = 0 ; j < 1000 ; j++) {
				for (i = 0; i < 1000; i++){
          g.setColor(new Color(250,250,250));
          plotit = checkPoints(xyPlot,i,j);
          if (plotit == 1) {
              g.setColor(new Color(30,127,30));
              //System.out.println(  xarray[i][j]+ " "+ yarray[i][j]+" array printed c1c2count "+c1c2count);
              c1array[c1c2count] = xarray[i][j];
              c2array[c1c2count] = yarray[i][j];
                c1c2count++;
            }
          g.drawLine(i,j,i,j);
	    	}//end for i
        }//end for j mandelbot
        //System.out.println("\n\n"+c1c2count+"\n\n");      
		Scanner objScanner = new Scanner(System.in);
		char c = objScanner.next().charAt(0);
		//System.out.println(c);
				
        
      //plot Julia
      //	initialize rgb[][]
		int rgb[][] = new int[3][256]; 
		
		//
     // g.setColor(new Color(255,255,0));
     // g.fillRect(0,0,1000,1000);
      while (loopJulia < c1c2count){
      c1 = c1array[loopJulia];
      c2 = c2array[loopJulia];
	  g.setColor(new Color(200,200,200));
	  g.fillRect(1000,400,1200,1000);
        g.setColor(new Color(0,0,0));
      g.drawString("c  = "+c1, 1020, 500);
      g.drawString("ci = "+c2, 1020, 700);
      // create colors
      ColorArray ca = new ColorArray();
		rgb = ca.color();
		int red,green,blue;
		int mc; //modcolor
      
 
      // display colors
  			for (j = 0; j < 256; j++){
				red = rgb[0][j];
				green= rgb[1][j];
				blue = rgb[2][j];
				g.setColor(new Color(red,green,blue));
							g.drawLine(1050,j+100,1200,j+100);
			}
      
    //c1 = -2.0;
      for (j = 0 ; j < 1000 ; j++) {
          jd = (double) j;
          y1 = (500 - jd) / scale;
            for (i = 0; i < 1000; i++){
              g.setColor(new Color(255,255,255));
              g.drawLine(i,j,i,j);
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
                if (k >= limit) {
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
            loopJulia++;
        }//end while
  }
// execute application
// globals
//double c1, c2, limit, int ired, igreen, iblue,redAjust, greenAjust, blueAjust

static double  limit;
static int iterations;
static int scale ;
 static int colors;
// main program
  public static void main( String a[] ){
    limit = Double.parseDouble(a[0]);
    iterations =  Integer.parseInt(a[1]);
	colors = Integer.parseInt(a[2]);
    MandelJuliaRGB myobject = new MandelJuliaRGB();//change this
  	   	// adapter to handle only windowClosing event
        myobject.addWindowListener(
  			   new WindowAdapter() {
				      public void windowClosing( WindowEvent event )
				          {System.exit( 0 );}
                }  // end WindowAdapter
        ); // end call to addWindowListener
   }//end main
 }// end class Painter
