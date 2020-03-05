
/**
 * berkay
 */
import java.util.Scanner;

public class berkay {

    public static void main(String[] args) {
        int s = 11;
        while (s % 10 == s / 10) {
            s = (int) ((Math.random() * 86) + 12);
        }

        Scanner scanner = new Scanner(System.in);

        String secret = Integer.toString(s);
        String userInput = "00";
        int result = 0;

        System.out.println("Secret = " + secret);

        // Dogru bilmedigi surece
        while (result != 2) {
            result = 0;
            userInput = scanner.next();

            // Sayi girildi
            try {
                int userInputInt = Integer.parseInt(userInput);
                // Yanlis aralik
                if (userInputInt < 12 || userInputInt > 98) {
                    System.out.println("Yanlis Girdi\nLutfen 12 ile 98 asarinda bir sayi giriniz:");
                    continue;
                }
                // Ardisik sayi
                if (userInputInt % 10 == userInputInt / 10) {
                    System.out.println("Ardisik iki sayisi ayni olan bir sayi giremezsiniz");
                    continue;
                }

                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        // Eslesen terim var
                        if (userInput.charAt(i) == secret.charAt(j)) {
                            // Dogru yerde
                            if (i == j)
                                result++;
                            // Yanlis yerde
                            else
                                result--;
                        }
                    }
                }

                System.out.println(result);
            }
            // Sayi girilmedi
            catch (Exception e) {
                System.out.println("Lutfen bir sayi giriniz");
            }

        }

        System.out.println("Tebrikler");
        scanner.close();
    }
}