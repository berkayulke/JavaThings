import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

class Kanvas extends Canvas {

    private int x = 0;
    private int direction = 1;
    public Kanvas(){
        setBackground(Color.YELLOW);
    }
    public void paint(Graphics gra)
    {
        gra.setFont(new Font("TimesRoman",Font.PLAIN,24));
        gra.drawString("Merhaba",x,200);

        x += direction*12;

        if ( x >= 800 - 128 || x <= 0)
            direction *= -1;

        try{
            Thread.sleep(200);
        }
        catch (Exception e){

        }

        repaint();
    }
}

public class Grafik01 implements WindowListener {
    private Frame fra;
    private Kanvas kan;

    public Grafik01(){
        fra = new Frame();
        kan = new Kanvas();

        fra.addWindowListener(this);
        fra.add(kan);

        fra.setSize(800,600);
        fra.setResizable(false);
        fra.setVisible(true);

    }

    public static void main(String[] args) {

        Grafik01 app = new Grafik01();
    }

    public void windowOpened(WindowEvent windowEvent) { }
    public void windowIconified(WindowEvent windowEvent) {}
    public void windowDeiconified(WindowEvent windowEvent) {}
    public void windowDeactivated(WindowEvent windowEvent) { }
    public void windowClosing(WindowEvent windowEvent) {

        System.exit(0);
    }
    public void windowClosed(WindowEvent windowEvent) { }
    public void windowActivated(WindowEvent windowEvent) { }
}
