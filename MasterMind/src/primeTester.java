public class primeTester {
    public static String isPrime(int x)
    {
        if(x <= 2)
            return "Lutfen 2'den Buyuk Bir Sayi Giriniz";
        for (int i = 2; i * i <= x; i++)
            if(x%i == 0)
                return "Asal Degildir";
        return "Asaldir";
    }
}
