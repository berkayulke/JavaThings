package mainPackage;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MyCanvas extends Canvas implements MouseListener, MouseMotionListener{
	int x = 200, y = 150, width = 40, height = 60;
	int radius = 155;
	
	Point mousePoint = getCenter();
	Point mousePre = getCenter();
	
	public Canvas can = new Canvas();
	Dimension canvasDim = can.getSize();
	
	public MyCanvas() {
		addMouseMotionListener(this);
		addMouseListener(this);
		setBackground(Color.BLACK);
		setSize(mainClass.height,mainClass.width);
	}

	private boolean isInRangeCircle(Point poi) {
		Point center = getCenter();
		double dist = center.distance(poi);
		return dist < radius/2;
	}
	
	private Point getCenter() {
		return new Point(x + radius/2,y + radius/2);
	}
	
	public void paint(Graphics g) {
		Point difference = new Point(mousePoint.x - mousePre.x,mousePoint.y-mousePre.y);
		
		//fark kadar ilerlet
		x += difference.x;
		y += difference.y;
		
		g.setColor(Color.red);
		g.fillOval(x, y, radius, radius);
		
		mousePre = mousePoint;
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		//System.out.print("ber");
		Point tmp = e.getPoint();
		
		if(isInRangeCircle(tmp)) {
			mousePoint = tmp;
			repaint();
		}
			
		//else
			//mousePre = tmp;
	}

	@Override
	public void mouseMoved(MouseEvent e) {}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent arg0) {	}

	@Override
	public void mousePressed(MouseEvent e) {
		mousePre = e.getPoint();	
		//repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}
	
}
