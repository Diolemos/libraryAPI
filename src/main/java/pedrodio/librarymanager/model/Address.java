package pedrodio.librarymanager.model;

public class Address {
    String streetName;
    String houseNumber; //yes, string! as some housing unit identifiers may include letters or symbols
    String complement = "";
    String zipCode;


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


}
