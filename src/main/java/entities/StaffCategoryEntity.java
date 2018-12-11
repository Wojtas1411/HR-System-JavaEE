package entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "staff_category", schema = "javaee", catalog = "")
public class StaffCategoryEntity {
    private int id;
    private String name;
    private Collection<EngagementEntity> engagementsById;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffCategoryEntity that = (StaffCategoryEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @OneToMany(mappedBy = "staffCategoryByStaffCategoryId")
    public Collection<EngagementEntity> getEngagementsById() {
        return engagementsById;
    }

    public void setEngagementsById(Collection<EngagementEntity> engagementsById) {
        this.engagementsById = engagementsById;
    }
}
