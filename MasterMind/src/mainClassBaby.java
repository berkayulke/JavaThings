import javax.print.DocFlavor;
import java.awt.*;
import java.awt.desktop.SystemSleepEvent;
import java.awt.event.*;
import java.util.Collections;
import java.util.zip.CheckedOutputStream;

public class mainClassBaby implements WindowListener, ActionListener {

    Panel pan;
    Frame fra;
    TextField inputField, outputField;
    Button but;

    Game game;

    public mainClassBaby() {
        //Set Variables
        fra = new Frame();
        pan = new Panel();
        inputField = new TextField(30);
        outputField = new TextField(50);
        but = new Button("Play");
        game = new Game();

        //Set Beginning Texts
        inputField.setText("Tahmininizi Buraya Girin!");
        outputField.setText("Sonucunu Buradan Görün!");

        //Set Button
        but.setBackground(Color.WHITE);

        //Set Panel
        pan.add(inputField);
        pan.add(outputField);
        pan.add(but);
        pan.setBackground(Color.BLUE);

        //Add listeners
        but.addActionListener(this);
        fra.addWindowListener(this);

        //Set Frame
        fra.add(pan);
        fra.pack();
        fra.setSize(480, 270);
        fra.setResizable(false);
        fra.setVisible(true);
    }

    public static void main(String args[]) {
        mainClassBaby mainClass = new mainClassBaby();
    }

    public void actionPerformed(ActionEvent actionEvent) {
        int inputInt = this.getNumberFromUser();
        if (inputInt != -1) {
            String score = game.makeGuess(inputInt);
            outputField.setText(score);
        }
    }

    //-1 degeri hata degeridir
    private int getNumberFromUser(){
		String userInput = inputField.getText();
		inputField.setText("");
		try {
			int inputInt = Integer.parseInt(userInput);
			int isInvalid = game.isInvalidInput(inputInt);

			if (isInvalid == 0){
				return inputInt;
			}else if (isInvalid == -1){
				outputField.setText("Lutfen " + Constants.lowerLimit + " - " + Constants.upperLimit + " araliginda bir sayi giriniz");
				return -1;
			}
			else if (isInvalid == -2){
                outputField.setText("Girdiginiz Sayida Ayni Rakam Tekrar Etmemeli");
                return -1;
            }

		} catch (Exception e) {
			outputField.setText("Lutfen Bir Tam Sayi Giriniz");
			return -1;
		}
		return -1;
	}

    public void windowActivated(WindowEvent windowEvent) {
    }

    public void windowClosed(WindowEvent windowEvent) {
    }

    public void windowClosing(WindowEvent windowEvent) {
        System.exit(0);
    }

    public void windowDeactivated(WindowEvent windowEvent) {
    }

    public void windowDeiconified(WindowEvent windowEvent) {
    }

    public void windowIconified(WindowEvent windowEvent) {
    }

    public void windowOpened(WindowEvent windowEvent) {
    }
}

