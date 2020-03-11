import java.io.SyncFailedException;
import java.util.Scanner;

class MainClass {
	public static void main(String[] args) {
		MainClass app = new MainClass();
	}

	private MainClass() {
		int input = 1;
		Scanner scanner = new Scanner(System.in);
		while (input != 0) {
			System.out.println("Lutfen İsleminizi giriniz");

			Fraction[] fractions = new Fraction[2];

			System.out.println("İlk Sayi:");
			fractions[0] = getNumberFromUser(scanner);

			System.out.println("\nİslem:");
			String operation = scanner.nextLine();

			System.out.println("\nİkinci Sayi:");
			fractions[1] = getNumberFromUser(scanner);

			System.out.print("\nSonuc: ");

			switch (operation) {
				case "+":
					System.out.println(FractionCalculator.add(fractions[0], fractions[1]).toString());
					break;
				case "-":
					System.out.println(FractionCalculator.subtract(fractions[0], fractions[1]).toString());
					break;
				case ".":
					System.out.println(FractionCalculator.multiply(fractions[0], fractions[1]).toString());
					break;
				case "*":
					System.out.println(FractionCalculator.multiply(fractions[0], fractions[1]).toString());
					break;
				case "/":
					System.out.println(FractionCalculator.divide(fractions[0], fractions[1]).toString());
					break;
				default:
					System.out.println("Yanlis Operasyon");
					break;
			}
			System.out.print("\n");
		}
		scanner.close();
	}

	private Fraction getNumberFromUser(Scanner scanner) {
		String inp = scanner.nextLine();

		try{
			int nom = Integer.parseInt(inp);
			return new Fraction(nom,1);
		}
		catch(Exception e){
			return Fraction.readFromString(inp);
		}
	}
}
