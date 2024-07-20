package pedrodio.librarymanager.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Borrower {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   
    @Column(length = 15)
    private String firstName;
    @Column(length = 15)
   private String secondName;
   @OneToOne(cascade = CascadeType.ALL)
   private Address address;
   @Column(length = 15)
   private String primaryPhone;
   @Column(length = 15)
   private String secondaryPhone;
   @Column(length = 15)
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

        public Long getId() {
            return id;
        }
    
        public void setId(Long id) {
            this.id = id;
        }

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
