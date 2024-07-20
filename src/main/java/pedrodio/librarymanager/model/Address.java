package pedrodio.librarymanager.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30)
    private String streetName;
    @Column(length = 5)
    private String houseNumber; //yes, string! as some housing unit identifiers may include letters or symbols
    @Column(length = 30)
    private String complement = "";
    @Column
    private String zipCode;

    public Address() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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