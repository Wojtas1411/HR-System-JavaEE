package entities;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "membership", schema = "javaee")
public class MembershipEntity implements Serializable {
    private int id;
    @Min(1)
    @Max(40)
    private int workingHoursPerWeek;
    private PersonalDataEntity personalDataByPersonId;
    private UnitsEntity unitsByUnitId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "working_hours_per_week")
    public int getWorkingHoursPerWeek() {
        return workingHoursPerWeek;
    }

    public void setWorkingHoursPerWeek(int workingHoursPerWeek) {
        this.workingHoursPerWeek = workingHoursPerWeek;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MembershipEntity that = (MembershipEntity) o;
        return id == that.id &&
                workingHoursPerWeek == that.workingHoursPerWeek;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, workingHoursPerWeek);
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
    @JoinColumn(name = "unit_id", referencedColumnName = "id", nullable = false)
    public UnitsEntity getUnitsByUnitId() {
        return unitsByUnitId;
    }

    public void setUnitsByUnitId(UnitsEntity unitsByUnitId) {
        this.unitsByUnitId = unitsByUnitId;
    }
}
