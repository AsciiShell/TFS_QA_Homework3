public enum Gender {
    MALE, FEMALE;

    public String toString() {
        if (this == MALE) {
            return "М";
        } else {
            return "Ж";
        }
    }

    public String toSQL() {
        if (this == MALE) {
            return "MALE";
        } else {
            return "FEMALE";
        }
    }

    public static Gender fromInteger(int x) {
        switch (x) {
            case 0:
                return MALE;
            case 1:
                return FEMALE;
            default:
                return null;
        }
    }

    public static Gender fromString(String x) {
        x = x.toUpperCase();
        switch (x) {
            case "MALE":
                return MALE;
            case "FEMALE":
                return FEMALE;
            default:
                return null;
        }
    }
}
