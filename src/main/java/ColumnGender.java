public class ColumnGender extends AbstractColumnGender {
    ColumnGender(Gender gender) {
        super(gender);
    }

    @Override
    protected void init() {
    }

    @Override
    protected String generateValue(Gender gender) {
        return gender == Gender.MALE ? "М" : "Ж";
    }
}
