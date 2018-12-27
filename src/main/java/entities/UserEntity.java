package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "javaee")
public class UserEntity implements Serializable {
    private int id;
    private String username;
    private String roles;
    private String password;
    private PersonalDataEntity personalDataById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "roles")
    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return id == that.id &&
                Objects.equals(username, that.username) &&
                Objects.equals(roles, that.roles) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, roles, password);
    }

    @OneToOne(mappedBy = "userByUserIdId", fetch = FetchType.EAGER)
    public PersonalDataEntity getPersonalDataById() {
        return personalDataById;
    }

    public void setPersonalDataById(PersonalDataEntity personalDataById) {
        this.personalDataById = personalDataById;
    }
}
