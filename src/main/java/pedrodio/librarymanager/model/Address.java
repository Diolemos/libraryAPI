package pedrodio.librarymanager.model;

public class Address {
    private String streetName;
    private String houseNumber; //yes, string! as some housing unit identifiers may include letters or symbols
    private String complement = "";
    private String zipCode;

    public Address() {
    }

    public Address(String streetName, String houseNumber, String zipCode) {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.zipCode = zipCode;
    }

    public Address(String streetName, String houseNumber, String complement, String zipCode) {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.complement = complement;
        this.zipCode = zipCode;
    }

    public String getStreetName() {
        return this.streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getHouseNumber() {
        return this.houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getComplement() {
        return this.complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    // Method to get the full address
    public String getFullAddress() {
        StringBuilder fullAddress = new StringBuilder();
        fullAddress.append(houseNumber).append(" ").append(streetName);
        if (!complement.isEmpty()) {
            fullAddress.append(", ").append(complement);
        }
        fullAddress.append(", ").append(zipCode);
        return fullAddress.toString();
    }

    // Override the toString method
    @Override
    public String toString() {
        return "Address{" +
                "streetName='" + streetName + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", complement='" + complement + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}