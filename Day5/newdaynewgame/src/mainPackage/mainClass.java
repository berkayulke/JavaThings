package mainPackage;
import java.awt.*;
import java.awt.event.*;

public class mainClass implements WindowListener{
	
	public static final int height = 1000, width = 1000;
	MyCanvas can;
	Frame fra;
	
	mainClass(){
		can = new MyCanvas();
		fra = new Frame();
		 
		fra.addWindowListener(this);
		
		fra.add(can);
		fra.setSize(height,width);
		fra.setVisible(true);
	}
	
	public static void main(String[] args) {
		mainClass app = new mainClass();
		//System.exit(100);
	}
	

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
