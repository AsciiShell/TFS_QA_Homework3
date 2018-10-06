import java.util.Random;

public class Rand {
    public static int RandomInt(int min, int max) {
        Random random = new Random();
        return min + random.nextInt(max - min + 1);
    }

    static String RandomItem(String[] array) {
        Random random = new Random();
        return array[random.nextInt(array.length)];
    }
}
