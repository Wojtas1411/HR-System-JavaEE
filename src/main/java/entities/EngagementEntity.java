package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "engagement", schema = "javaee", catalog = "")
public class EngagementEntity implements Serializable {
    private int id;
    private PersonalDataEntity personalDataByPersonId;
    private StaffCategoryEntity staffCategoryByStaffCategoryId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EngagementEntity that = (EngagementEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id", nullable = false)
    public PersonalDataEntity getPersonalDataByPersonId() {
        return personalDataByPersonId;
    }

    public void setPersonalDataByPersonId(PersonalDataEntity personalDataByPersonId) {
        this.personalDataByPersonId = personalDataByPersonId;
    }

    @ManyToOne
    @JoinColumn(name = "staff_category_id", referencedColumnName = "id", nullable = false)
    public StaffCategoryEntity getStaffCategoryByStaffCategoryId() {
        return staffCategoryByStaffCategoryId;
    }

    public void setStaffCategoryByStaffCategoryId(StaffCategoryEntity staffCategoryByStaffCategoryId) {
        this.staffCategoryByStaffCategoryId = staffCategoryByStaffCategoryId;
    }
}
