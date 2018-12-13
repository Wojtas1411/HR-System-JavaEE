package entities;

import javax.persistence.*;
import java.io.Serializable;
//import java.sql.Date;
import java.util.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "temporary_personal_data", schema = "javaee", catalog = "")
public class TemporaryPersonalDataEntity implements Serializable {
    private int id;
    private Timestamp timestamp;
    private String userId;
    private String familyName;
    private String firstName;
    private Date birthDate;
    private String birthPlace;
    private String photo;
    private String adres;
    private String emails;
    private String phoneNumbers;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "timestamp")
    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Basic
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "family_name")
    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "birth_date")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Basic
    @Column(name = "birth_place")
    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    @Basic
    @Column(name = "photo")
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Basic
    @Column(name = "adres")
    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    @Basic
    @Column(name = "emails")
    public String getEmails() {
        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    @Basic
    @Column(name = "phone_numbers")
    public String getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(String phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TemporaryPersonalDataEntity that = (TemporaryPersonalDataEntity) o;
        return id == that.id &&
                Objects.equals(timestamp, that.timestamp) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(familyName, that.familyName) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(birthDate, that.birthDate) &&
                Objects.equals(birthPlace, that.birthPlace) &&
                Objects.equals(photo, that.photo) &&
                Objects.equals(adres, that.adres) &&
                Objects.equals(emails, that.emails) &&
                Objects.equals(phoneNumbers, that.phoneNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, timestamp, userId, familyName, firstName, birthDate, birthPlace, photo, adres, emails, phoneNumbers);
    }
}
