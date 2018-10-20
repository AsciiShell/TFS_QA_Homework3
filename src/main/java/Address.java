public final class Address {
    private final String country;
    private final String region;
    private final String city;
    private final String street;
    private final String house;
    private final int flat;
    private final int zip;

    public Address(String country, String region, int zip, String city, String street, String house, int flat) {
        this.country = country;
        this.region = region;
        this.city = city;
        this.street = street;
        this.house = house;
        this.flat = flat;
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public String getRegion() {
        return region;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getHouse() {
        return house;
    }

    public int getFlat() {
        return flat;
    }

    public int getZip() {
        return zip;
    }
}
