
public class Fraction {
    private int nom, denom;

    Fraction(int nom, int denom) {
        if (nom < 0 && denom < 0) {
            this.nom = -nom;
            this.denom = -denom;
        } else {
            this.nom = nom;
            this.denom = denom;
        }
        this.simplify();
    }

    public int getNominator() {
        return this.nom;
    }

    public int getDenominator() {
        return this.denom;
    }

    public String toString() {
        if (this.nom % this.denom == 0)
            return Integer.toString(this.nom/this.denom);
        return this.nom + "/" + this.denom;
    }

    private void simplify() {
        int gcd = FractionCalculator.gcd(this.nom, this.denom);

        if (gcd != 0) {
            this.nom /= gcd;
            this.denom /= gcd;
        }
    }

    public static Fraction readFromString(String inp) {
        inp.trim();
        String[] inps = inp.split("/");
        int no = Integer.parseInt(inps[0]);
        int deno = Integer.parseInt(inps[1]);
        return new Fraction(no, deno);
    }
}
