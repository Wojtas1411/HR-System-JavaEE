package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "adres", schema = "javaee", catalog = "")
public class AdresEntity implements Serializable {
    private int id;
    private byte prim;
    private String street;
    private String number;
    private String local;
    private String postalCode;
    private String town;
    private PersonalDataEntity personalDataByUserId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "prim")
    public byte getPrim() {
        return prim;
    }

    public void setPrim(byte prim) {
        this.prim = prim;
    }

    @Basic
    @Column(name = "street")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Basic
    @Column(name = "number")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Basic
    @Column(name = "local")
    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    @Basic
    @Column(name = "postal_code")
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Basic
    @Column(name = "town")
    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdresEntity that = (AdresEntity) o;
        return id == that.id &&
                prim == that.prim &&
                Objects.equals(street, that.street) &&
                Objects.equals(number, that.number) &&
                Objects.equals(local, that.local) &&
                Objects.equals(postalCode, that.postalCode) &&
                Objects.equals(town, that.town);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, prim, street, number, local, postalCode, town);
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public PersonalDataEntity getPersonalDataByUserId() {
        return personalDataByUserId;
    }

    public void setPersonalDataByUserId(PersonalDataEntity personalDataByUserId) {
        this.personalDataByUserId = personalDataByUserId;
    }
}
