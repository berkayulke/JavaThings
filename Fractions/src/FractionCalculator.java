public class FractionCalculator {

    static Fraction add(Fraction num1, Fraction num2) {
        int top1 = num1.getNominator() * num2.getDenominator();
        int top2 = num2.getNominator() * num1.getDenominator();
        int bot = num1.getDenominator() * num2.getDenominator();
        return new Fraction(top1 + top2, bot);
    }

    static Fraction subtract(Fraction num1, Fraction num2) {
        Fraction negNum2 = new Fraction(-num2.getNominator(), num2.getDenominator());
        return add(num1, negNum2);
    }

    static Fraction multiply(Fraction num1, Fraction num2) {
        return new Fraction(num1.getNominator() * num2.getNominator(), num1.getDenominator() * num2.getDenominator());
    }

    static Fraction divide(Fraction num1, Fraction num2) {
        if (num2.getNominator() == 0)
            return null;
        else
            return new Fraction(num1.getNominator() * num2.getDenominator(),
                                num1.getDenominator() * num2.getNominator());
    }

    static int gcd(int nom, int denom) {
        int max = Math.max(nom, denom);
        for (int i = max; i >= 2; i--) {
            if (nom % i == 0 && denom % i == 0) {
                return i;
            }
        }
        return 0;
    }

}
