package entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "units", schema = "javaee", catalog = "")
public class UnitsEntity {
    private int id;
    private String name;
    private String type;
    private Collection<MembershipEntity> membershipsById;
    private UnitsEntity unitsByParentId;
    private Collection<UnitsEntity> unitsById;
    private PersonalDataEntity personalDataByBossId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnitsEntity that = (UnitsEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type);
    }

    @OneToMany(mappedBy = "unitsByUnitId")
    public Collection<MembershipEntity> getMembershipsById() {
        return membershipsById;
    }

    public void setMembershipsById(Collection<MembershipEntity> membershipsById) {
        this.membershipsById = membershipsById;
    }

    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    public UnitsEntity getUnitsByParentId() {
        return unitsByParentId;
    }

    public void setUnitsByParentId(UnitsEntity unitsByParentId) {
        this.unitsByParentId = unitsByParentId;
    }

    @OneToMany(mappedBy = "unitsByParentId")
    public Collection<UnitsEntity> getUnitsById() {
        return unitsById;
    }

    public void setUnitsById(Collection<UnitsEntity> unitsById) {
        this.unitsById = unitsById;
    }

    @ManyToOne
    @JoinColumn(name = "boss_id", referencedColumnName = "id", nullable = false)
    public PersonalDataEntity getPersonalDataByBossId() {
        return personalDataByBossId;
    }

    public void setPersonalDataByBossId(PersonalDataEntity personalDataByBossId) {
        this.personalDataByBossId = personalDataByBossId;
    }
}
