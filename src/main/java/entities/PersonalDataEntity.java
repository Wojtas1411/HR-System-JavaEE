package entities;

import javax.persistence.*;
import javax.validation.constraints.Past;
import java.io.Serializable;
//import java.sql.Date;
import java.util.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "personal_data", schema = "javaee")
public class PersonalDataEntity implements Serializable {
    private int id;
    private String familyName;
    private String firstName;
    @Past
    private Date birthDate;
    private String birthPlace;
    private String photo;

    private Collection<AdresEntity> adresById;
    private Collection<EmailsEntity> emailsById;
    private Collection<PhoneNumbersEntity> phoneNumbersById;

    private JobDataEntity jobDataById;

    private EngagementEntity engagementsById;
    private Collection<MembershipEntity> membershipsById;

    private UserEntity userByUserIdId;

    private Collection<UnitsEntity> unitsById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonalDataEntity that = (PersonalDataEntity) o;
        return id == that.id &&
                Objects.equals(familyName, that.familyName) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(birthDate, that.birthDate) &&
                Objects.equals(birthPlace, that.birthPlace) &&
                Objects.equals(photo, that.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, familyName, firstName, birthDate, birthPlace, photo);
    }

    @OneToMany(mappedBy = "personalDataByUserId")
    public Collection<AdresEntity> getAdresById() {
        return adresById;
    }

    public void setAdresById(Collection<AdresEntity> adresById) {
        this.adresById = adresById;
    }

    @OneToMany(mappedBy = "personalDataByUserId")
    public Collection<EmailsEntity> getEmailsById() {
        return emailsById;
    }

    public void setEmailsById(Collection<EmailsEntity> emailsById) {
        this.emailsById = emailsById;
    }

    @OneToOne(mappedBy = "personalDataByPersonId")
    public EngagementEntity getEngagementsById() {
        return engagementsById;
    }

    public void setEngagementsById(EngagementEntity engagementsById) {
        this.engagementsById = engagementsById;
    }

    @OneToOne(mappedBy = "personalDataByUserId", fetch = FetchType.EAGER)
    public JobDataEntity getJobDataById() {
        return jobDataById;
    }

    public void setJobDataById(JobDataEntity jobDataById) {
        this.jobDataById = jobDataById;
    }

    @OneToMany(mappedBy = "personalDataByPersonId", fetch = FetchType.EAGER)
    public Collection<MembershipEntity> getMembershipsById() {
        return membershipsById;
    }

    public void setMembershipsById(Collection<MembershipEntity> membershipsById) {
        this.membershipsById = membershipsById;
    }

    @OneToOne
    @JoinColumn(name = "user_id_id", referencedColumnName = "id", nullable = false)
    public UserEntity getUserByUserIdId() {
        return userByUserIdId;
    }

    public void setUserByUserIdId(UserEntity userByUserIdId) {
        this.userByUserIdId = userByUserIdId;
    }

    @OneToMany(mappedBy = "personalDataByUserId")
    public Collection<PhoneNumbersEntity> getPhoneNumbersById() {
        return phoneNumbersById;
    }

    public void setPhoneNumbersById(Collection<PhoneNumbersEntity> phoneNumbersById) {
        this.phoneNumbersById = phoneNumbersById;
    }

    @OneToMany(mappedBy = "personalDataByBossId")
    public Collection<UnitsEntity> getUnitsById() {
        return unitsById;
    }

    public void setUnitsById(Collection<UnitsEntity> unitsById) {
        this.unitsById = unitsById;
    }
}
