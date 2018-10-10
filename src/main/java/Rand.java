import java.util.Date;
import java.util.Random;

class Rand {
    static int randomInt(int min, int max) {
        Random random = new Random();
        return min + random.nextInt(max - min + 1);
    }

    static long randomInt(long min, long max) {
        Random random = new Random();
        return min + random.nextLong() % (max - min + 1);
    }

    static Object randomItem(Object[] array) {
        Random random = new Random();
        return array[random.nextInt(array.length)];
    }

    static int randomItem(int[] array) {
        Random random = new Random();
        return array[random.nextInt(array.length)];
    }

    static Date randomDate(Date start, Date end) {
        Random random = new Random();
        return new Date(start.getTime() + randomInt(start.getTime(), end.getTime()));
    }

    static Gender randomGender() {
        Random random = new Random();
        return random.nextBoolean() ? Gender.MALE : Gender.FEMALE;
    }
}
