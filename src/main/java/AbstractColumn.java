public abstract class AbstractColumn {
    protected Object value;

    protected abstract void init();

    protected abstract Object generateValue();

    AbstractColumn() {
        init();
        value = generateValue();
    }

    public String toString() {
        return (String) value;
    }
}
