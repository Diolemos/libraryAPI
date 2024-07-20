package pedrodio.librarymanager.model;

public class Borrower {
   private String firstName;
   private String secondName;
   private Address address;
   private String primaryPhone;
   private String secondaryPhone;
   private String email;


    public Borrower() {
    }


    public Borrower(String firstName, String secondName, Address address, String primaryPhone, String secondaryPhone, String email) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
        this.primaryPhone = primaryPhone;
        this.secondaryPhone = secondaryPhone;
        this.email = email; }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return this.secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFullName() {
        return getFirstName() + " " + getSecondName();
    }

   

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPrimaryPhone() {
        return this.primaryPhone;
    }

    public void setPrimaryPhone(String primaryPhone) {
        this.primaryPhone = primaryPhone;
    }

    public String getSecondaryPhone() {
        return this.secondaryPhone;
    }

    public void setSecondaryPhone(String secondaryPhone) {
        this.secondaryPhone = secondaryPhone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    

}
