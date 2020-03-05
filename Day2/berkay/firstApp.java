import java.awt.*;
import java.awt.event.*;

/**
 * firstApp
 */
public class firstApp implements WindowListener, ActionListener {
    Frame frame;
    Panel panel;
    TextField textInput,textOutput;
    Button button;

    private String isPrime(int num)
    {
        if(num < 2)
            return "2'den buyuk bir sayi giriniz";
        for(int i = 2; i*i <= num;i++){
            if(num%i == 0)
                return "Asal degil " + i + " ye bolunuyor";
        }
        return "Asal";
    }

    public firstApp() {
        frame = new Frame();
        panel = new Panel();
        textInput = new TextField(30);
        textOutput = new TextField(75);
        button = new Button("Asal mi?");

        panel.add(textInput);
        panel.add(textOutput);
        panel.add(button);
        panel.setBackground(Color.yellow);

        frame.add(panel);

        button.addActionListener(this);
        frame.addWindowListener(this);

        frame.pack();

        frame.setSize(800, 450);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        firstApp app = new firstApp();
    }

    public void actionPerformed(ActionEvent e) {
        String inputString = textInput.getText();
        
        try {
            int inputInt = Integer.parseInt(inputString);
            textOutput.setText(this.isPrime(inputInt));
        } catch (Exception ex) {
            textOutput.setText("Lutfen bir tamsayi giriniz.");
        }

        textInput.setText("");
    }

    public void windowOpened(WindowEvent e) {
    }

    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    public void windowClosed(WindowEvent e) {
    }

    public void windowIconified(WindowEvent e) {
    }

    public void windowDeiconified(WindowEvent e) {
    }

    public void windowActivated(WindowEvent e) {
    }

    public void windowDeactivated(WindowEvent e) {
    }

}