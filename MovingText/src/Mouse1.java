import java.awt.event.*;
import java.awt.*;

class Kanvas01 extends Canvas implements MouseListener,MouseMotionListener
{
    private Point point;

    public Kanvas01(){
        point = new Point(0,0);
        setBackground(Color.YELLOW);
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void paint(Graphics gra)
    {
        gra.drawString("Merhaba",point.x,point.y);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        point = mouseEvent.getPoint();
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }
}

public class Mouse1 implements  WindowListener{
    private Frame fra;
    private Kanvas01 kanvas;

    public Mouse1(){
        fra = new Frame();
        kanvas = new Kanvas01();

        fra.addWindowListener(this);
        fra.add(kanvas);

        fra.setSize(800,600);
        fra.setResizable(false);
        fra.setVisible(true);
    }

    public static void main(String[] args) {
        Mouse1 app = new Mouse1();
    }

    @Override
    public void windowActivated(WindowEvent windowEvent) {

    }

    @Override
    public void windowClosed(WindowEvent windowEvent) {

    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {
        System.exit(0);
    }

    @Override
    public void windowDeactivated(WindowEvent windowEvent) {

    }

    @Override
    public void windowDeiconified(WindowEvent windowEvent) {

    }

    @Override
    public void windowIconified(WindowEvent windowEvent) {

    }

    @Override
    public void windowOpened(WindowEvent windowEvent) {

    }
}
