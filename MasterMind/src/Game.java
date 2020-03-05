import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    private int secret;
    private String currentScore;

    public Game() {
        secret = this.createRandomNumber();
        currentScore = "";
        System.out.println("Secret = " + secret);
    }

    private int createRandomNumber() {
        String numStr = "";

        List<Integer> shuffledNumbers = new ArrayList<Integer>();
        for (int i = 1; i < 10; i++)
            shuffledNumbers.add(i);
        Collections.shuffle(shuffledNumbers);

        for (int i = 0; i < Constants.digitAmount; i++) {
            int x = shuffledNumbers.remove(0);
            if(i == 0 && x == 0)
                shuffledNumbers.add(0);
            numStr += Integer.toString(x);
        }
        return Integer.parseInt(numStr);
    }

    private int getNthDigit(int num, int digit) {
        int dig_pow = (int) Math.pow(10, digit);
        return (num / dig_pow) % 10;
    }

    public int isInvalidInput(int x) {

        if (x <= Constants.lowerLimit || x >= Constants.upperLimit)
            return -1;

        String xString = Integer.toString(x);

        //i. indeks i rakamı gorundu muyu tutacak
        boolean numbers[] = new boolean[10];
        for (int i = 0; i < 10; i++)
            numbers[i] = false;

        for (int i = 0; i <Constants.digitAmount ; i++) {

            char c = xString.charAt(i);
            int cur_digit = Character.getNumericValue(c);

            if (numbers[cur_digit] == true)
                return -2;

            numbers[cur_digit] = true;
        }
        return 0;
    }

    public String makeGuess(int guess) {
        currentScore = "";
        int pos = 0,neg = 0;

        if (guess == secret)
            return "Tebrikler";

        for (int i = 0; i < Constants.digitAmount; i++) {
            for (int j = 0; j < Constants.digitAmount; j++) {
                //Eslesen Terim Var
                if (this.getNthDigit(guess, i) == this.getNthDigit(secret, j)) {
                    //Dogru yerde
                    if (i == j)
                        pos++;
                    else
                        neg++;
                }
            }
        }
        if(neg == 0)
            currentScore = "+" + pos;
        else if (pos == 0)
            currentScore = "-" + neg;
        else
            currentScore = "+" + pos + "-" + neg;
        return  currentScore;
    }
}
