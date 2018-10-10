import java.util.Date;

public class ColumnBirthDate extends AbstractColumn {
    private static final Date startDate = new Date(70, 0, 1);
    private static final Date endDate = new Date();

    protected void init() {

    }

    @Override
    protected Object generateValue() {
        return Rand.randomDate(startDate, endDate);
    }

    public Date getDate() {
        return (Date) value;
    }
}
