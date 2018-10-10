public abstract class AbstractColumnGender {
    protected String value;

    protected abstract void init();

    protected abstract String generateValue(Gender gender);

    AbstractColumnGender(Gender gender) {
        init();
        value = generateValue(gender);
    }

    public String toString() {
        return value;
    }
}
