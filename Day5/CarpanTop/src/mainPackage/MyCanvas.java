package mainPackage;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

@SuppressWarnings("serial")
public class MyCanvas extends Canvas implements MouseListener, MouseMotionListener{
	int x = getRandom(), y = getRandom();
	int xSpeed = getRandomDir(), ySpeed = getRandomDir();
	int radius = 100;

	public Canvas can = new Canvas();
	Dimension canvasDim = can.getSize();
	
	private int getRandom() {
		double r = Math.random();
		r*=(mainClass.height-100);
		return (int)r;
	}
	
	private int getRandomDir() {
		return (int)(Math.random()*10);
	}
	
	private void checkCollision() {
		if(x < 0 || x + radius > mainClass.width)
			xSpeed*=-1;
		if(y + 5 < 0 || y + radius + 25 > mainClass.height)
			ySpeed*=-1;
	}
	
	public MyCanvas() {
		addMouseMotionListener(this);
		addMouseListener(this);
		setBackground(Color.BLACK);
		setSize(mainClass.height,mainClass.width);
	}

	public void paint(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillOval(x, y, radius, radius);
		
		checkCollision();
		
		x+=xSpeed;
		y+=ySpeed;
		
		try {
			Thread.sleep(50);
			repaint();
		}
		catch(Exception e) {}
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {}

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
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}
	
}