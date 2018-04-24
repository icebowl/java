import java.awt.*; 
import java.awt.event.*; 
import java.applet.*; 
import java.util.Date;
import java.awt.Font;

/* 
  <applet code="MouseMove" width=1000 height=800>
  <param name=red value=0> 
<param name=green value=0> 
<param name=blue value=0> 
<param name=redAjust value=5> 
<param name=greenAjust value=5> 
<param name=blueAjust value=5> 
<param name=limit value= 0> 
  </applet> 
*/ 


public class MouseMove extends Applet implements  MouseListener, MouseMotionListener{ 

private Font fontFace; 
 boolean done;
 boolean stopFlag;
 double c1, c2,dx,dy,dxadjust, dyadjust;
int ired, igreen, iblue,redAjust, greenAjust, blueAjust,limit;
  	  String msg = ""; 

	  int mouseX = 400, mouseY = 400; 
	  double dX = 0.0, dY = 0.0; // previous coordinates 
	  boolean draw; 
  
  
  
public void start() { 
    String temp; 

    temp = getParameter("red"); 
    try { if(temp != null) ired = Integer.parseInt(temp); 
      else  ired = 0; } catch(NumberFormatException exc) {  ired = -1;  } 
	  
	   temp = getParameter("green"); 
    try { if(temp != null) igreen = Integer.parseInt(temp); 
      else  igreen = 0; } catch(NumberFormatException exc) {  igreen = -1;  } 
	  
	   temp = getParameter("blue"); 
    try { if(temp != null) iblue = Integer.parseInt(temp);
      else  iblue = 0; } catch(NumberFormatException exc) {  iblue = -1;  }
	  
	  temp = getParameter("redAjust"); 
	      try { if(temp != null) redAjust = Integer.parseInt(temp); 
      else  redAjust = 0; } catch(NumberFormatException exc) {  redAjust = -1;  } 
	  
	   temp = getParameter("greenAjust"); 
    try { if(temp != null) greenAjust = Integer.parseInt(temp); 
      else  greenAjust = 0; } catch(NumberFormatException exc) {  greenAjust = -1;  } 
	  
	   temp = getParameter("blueAjust"); 
    try { if(temp != null) blueAjust = Integer.parseInt(temp); 
      else  blueAjust = 0; } catch(NumberFormatException exc) {  blueAjust = -1;  } 
	  
	   temp = getParameter("limit"); 
    try { if(temp != null) limit = Integer.parseInt(temp); 
      else  limit = 0; } catch(NumberFormatException exc) {  limit = -1;  } 
	   	 	  
  } 
  

  
  public void init() {
	  addMouseListener(this); 
	  addMouseMotionListener(this); 
	  fontFace = new Font("Arial", Font.PLAIN, 24);

	}//end init()
		
	public void stop(){  		
            
           }//end stop	
		
	
	
  // Handle mouse clicked. 
  public void mouseClicked(MouseEvent obj) { 
    mouseX = 810; 
    mouseY = 370;                                           
    msg = "Mouse clicked."; 
  // repaint(); 
  } 
 
  // Handle mouse entered. 
  public void mouseEntered(MouseEvent obj) { 
    mouseX = 810; 
    mouseY = 350; 
    msg = "Mouse entered."; 
   // repaint(); 
  } 
 
  // Handle mouse exited. 
  public void mouseExited(MouseEvent obj) { 
  
  } 
 
  // Handle button pressed. 
  public void mousePressed(MouseEvent obj) { 
    // save coordinates 
    mouseX = obj.getX(); 
    mouseY = obj.getY(); 
    msg = "*"; 
//insert scores into database

    repaint(); 
  } 
 
  // Handle button released. 
  public void mouseReleased(MouseEvent obj) { 
  } 
 
  // Handle mouse dragged. 
  public void mouseDragged(MouseEvent obj) { 
    
  } 
 
  // Handle mouse moved. 
  public void mouseMoved(MouseEvent obj) { 
    // show status 
//    showStatus(obj.getX() + ", " + obj.getY()); 
    dx = (double)obj.getX();
    dy = (double)obj.getY();
    dxadjust = (dx - 410) / 200;
   dyadjust = (410 - dy) / 200;
        showStatus( dxadjust + ", " + dyadjust); 
    
    
  } 
 
  // Display msg in applet window at current X,Y location. 
  public void paint(Graphics g) { int ared[] = new int[256];
	int agreen[] = new int[256];
	int ablue[] = new int[256];
	int i;	int rval = 0;	int  j,p;	int k;
	 double x,y,x1,x2,y1,z; double id, jd; 
		int Iterations = 1000;
		
        			
			
			
	for (i = 0; i < 256;i++){
		ared[i] = ired;
		agreen[i] = igreen;
		ablue[i] = iblue;
		ired = ired+redAjust;
		igreen = igreen+greenAjust;
		iblue = iblue+blueAjust;
		if (ired > 255) ired = 0;if (ired < 0) ired = 255;
		if (igreen > 255) igreen = 0;if (igreen < 0) igreen = 255;
		if (iblue > 255) iblue = 0;if (iblue < 0) iblue =  255;
	}
		g.setColor(new Color(255,255,255));
		g.fillRect(0,0,1000,900);
		int scale = 200;
		for (j = 0 ; j < 800 ; j++) {
			jd = (double) j;
			y1 = (400 - jd) / scale;
				for (i = 0; i < 800; i++){
					id = (double) i;
					x1 = (id - 400) / scale;			
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
					}while ((k < Iterations) & (z < 4.0));
						if (k > limit) {
						if (k > 255) k = 255;
							g.setColor(new Color(ared[k],agreen[k],ablue[k]));
							g.drawLine(i+10,j+10,i+10,j+10);
						}
	    	}//end for i
        }//end for j
	for (k = 0;k < 256; k++){
		g.setColor(new Color(ared[k],agreen[k],ablue[k]));
		g.drawLine(k+10,780,k+10,800);	
		
	}
	
			 Font font = new Font("Arial",Font.BOLD,18);
			 g.setFont(font);
		  
			g.setColor(new Color(255,0,0));
			//g.fillRect(0,0,1000,820);
			//g.setColor(new Color(0,0,0));
			g.drawString("Click the ",820,90);
			g.drawString("Mandelbrot Set",820,110);
			g.drawString("to get the",820,130);
			g.drawString("Julia Set",820,150);
			g.drawString("c + ci points.",820,170);
			//g.drawString("c + ci points.",820,190);
			//g.drawString("c + ci"+limit,820,210);
			g.setColor(new Color(0,0,200));
			dxadjust = (dx - 410) / 200;
			dyadjust = (410 - dy) / 200;
			
			g.drawString("c:"+dxadjust,820,240);
			g.drawString("ci:"+dyadjust ,820,270);
			//g.drawString("Click the Mandelbrot Set",820,280);
			  
 
	  
  }//end paint
}


