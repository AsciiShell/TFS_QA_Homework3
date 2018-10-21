public enum Gender {
    MALE, FEMALE;

    public String toString() {
     if (this == MALE){
         return "М";
     }
     else{
         return "Ж";
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
}
