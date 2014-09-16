import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Color;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.apache.batik.svggen.SVGGraphics2D;
import org.apache.batik.dom.GenericDOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DOMImplementation;

public class PaintHouseAsSVG {
	
	public void paint(Graphics2D g2d, float[] pX, float[] pY) {
		float xPoints[] = { 12.5f, 12.5f, 17.5f, 17.5f, 20f, 20f, 22.5f, 22.5f, 12.5f, 17.5f, 22.5f };         
		float yPoints[] = { 8.5f,  13.5f, 13.5f, 8.5f, 8.5f, 13.5f, 13.5f, 8.5f, 8.5f, 3.5f,  8.5f  };
		
		float minX = 10f;
    	float maxX = 22.5f; 
    	float minY = 3.5f;
    	float maxY = 16f;
    	
		int nPoints = xPoints.length;
		
		g2d.setPaint(Color.lightGray);
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));
		g2d.fillPolygon(display(xPoints, xPoints.length), display(yPoints, yPoints.length), nPoints);
		
		g2d.setPaint(Color.blue);
		g2d.setStroke(new BasicStroke(1.5f));
		g2d.drawPolygon(display(xPoints, xPoints.length), display(yPoints, yPoints.length), nPoints);

        float step = 0f;
        while (minX + step <= maxX) {
        	g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
            g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 1.0f, new float[] {1f, 1f, 1f}, 2f));
        	g2d.drawLine((int)((minX - 1)*10), (int)((minY + step)*10), (int)((maxX + 1)*10), (int)((minY + step)*10));
        	g2d.drawLine((int)((minX + step)*10), (int)((minY - 1)*10), (int)((minX + step)*10), (int)((maxY + 1)*10));
        	
        	g2d.setPaint(Color.black);
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
            g2d.setFont(new Font("Arial", Font.PLAIN, 8));
            
        	g2d.drawString(gridValueString(minX, step), (int)((minX + step - 1)*10), (int)((minY - 1.5)*10));
        	g2d.drawString(gridValueString(minY, step), (int)((minX - 3)*10), (int)((minY + step + 0.1)*10));
        	step += 2.5f;
		}
        for (int i = 0; i < pX.length; i++) {
        	g2d.setPaint(Color.black);
        	g2d.setStroke(new BasicStroke(1.0f));
        	g2d.drawOval((int)(pX[i]*10), (int)(pY[i]*10), 4, 4);
        	
			if (!checkPoint(pX[i], pY[i])) {
				g2d.setPaint(Color.lightGray);
			}
			
        	g2d.fillOval((int)(pX[i]*10), (int)(pY[i]*10), 4, 4);
		}
	}
	
	private int[] display(float[] arr, int n) {
		int[] result = new int[n];
		for (int i = 0; i < arr.length; i++) {
			result[i] = (int)(arr[i]*10);
		}
		return result;
	}
	
	private String gridValueString(float value, float step) {
		String gridValue = Float.toString(value + step);
    	if ((int)(value + step) == value + step) {
    		gridValue = Integer.toString((int)(value + step));
		}
		return gridValue;
	}

	private Boolean checkPoint(float x, float y) {
		Boolean result =  false;
		
		if(
				(((x >= 12.5 && x <= 17.5) || (x >= 20 && x <= 22.5)) && (y >= 8.5 && y <= 13.5))
				||
				((x >= 12.5 && x <= 22.5 && y >= 3.5 && y <= 8.5) && (Math.abs(y-3.5) >= Math.abs(x-17.5)))
			){
			result = true;
		}
		
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);	
		int n = s.nextInt();
		float[] pX = new float [n];
		float[] pY = new float [n];
		
		for (int i = 0; i < n; i++) {
			pX[i] = s.nextFloat();
			pY[i] = s.nextFloat();
		}
		s.close();
		
		DOMImplementation domImpl = GenericDOMImplementation.getDOMImplementation();
		
		String svgNS = "http://www.w3.org/2000/svg";
		
		Document document = domImpl.createDocument(svgNS, "svg", null);
		
		SVGGraphics2D svgGenerator = new SVGGraphics2D(document);
		
		PaintHouseAsSVG houseDraw = new PaintHouseAsSVG();
		houseDraw.paint(svgGenerator, pX, pY);
		
		svgGenerator.stream(new FileWriter("house.html"), false);
	}
}
