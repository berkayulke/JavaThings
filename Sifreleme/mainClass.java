import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class mainClass implements WindowListener, ActionListener {

    final int alphSize = 27;
    ArrayList<Character> secrets = getAlphabet();
    Panel pan;
    Frame fra;
    TextField decryptedField, cryptedField;
    Button dolarBut,tlBut;
    String crypte,decrypte;

    private char indexToChar(int x){
        return (char)(x + 'a');
    }
    private int charToIndex(char x){
        return (int)(x - 'a');
    }
    
    private ArrayList<Character> getAlphabet(){
        ArrayList<Character> al = new ArrayList<Character>();
        for(int i = 0; i < alphSize;i++){
            al.add(indexToChar(i));
        }
        return al;
    }

    private void fillArray(){
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        for(int i = 0; i < alphSize; i++)
            indexes.add(i);
        
        char c = 'a';
        while(c <= 'z'){
            int randIndex = (int)(Math.random()*indexes.size());
            secrets.set(randIndex,c);
            c++;
        }
    }

    public mainClass() {
        //Set Variables
        fra = new Frame();
        pan = new Panel();
        decryptedField = new TextField(30);
        cryptedField = new TextField(29);

        crypte = "Sifrele";
        decrypte = "Sifreyi Coz";
        dolarBut = new Button(crypte);
        tlBut = new Button(decrypte);
        
        fillArray();

        //System.out.println(secrets[25]);
        //Set Beginning Texts
        dolarBut.setBackground(Color.WHITE);
        tlBut.setBackground(Color.WHITE);

        //Set Panel
        pan.add(decryptedField);
        pan.add(dolarBut);
        pan.add(cryptedField);
        pan.add(tlBut);
        pan.setBackground(Color.BLUE);

        //Add listeners
        dolarBut.addActionListener(this);
        tlBut.addActionListener(this);
        fra.addWindowListener(this);

        //Set Frame
        fra.add(pan);
        fra.pack();
        fra.setSize(480, 270);
        fra.setResizable(false);
        fra.setVisible(true);
    }

    public static void main(String args[]) {
    	mainClass mainClass = new mainClass();
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String buttonText = actionEvent.getActionCommand();
        if(buttonText == crypte){
            //fillArray();
            String out = "";
            String in = decryptedField.getText();
            for(int i = 0; i < in.length();i++){
                char curChar = in.charAt(i);
                if(curChar<'a' || curChar > 'z')
                    cryptedField.setText("LUTFEN SADECE HARF GIRINIZ");
                int charIndex = charToIndex(curChar);
                out += secrets.get(charIndex);
            }
            cryptedField.setText(out);
        }
        else if(buttonText == decrypte){
            String out = "";
            String in = cryptedField.getText();
            for(int i = 0; i < in.length();i++){
                char curChar = in.charAt(i);
                if(curChar<'a' || curChar > 'z')
                    cryptedField.setText("LUTFEN SADECE HARF GIRINIZ");
                int charIndex = secrets.indexOf(curChar);
                out += indexToChar(charIndex);
            }
            decryptedField.setText(out);
        }
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

