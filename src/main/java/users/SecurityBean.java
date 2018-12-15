package users;

import entities.UserEntity;

import javax.annotation.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;
import java.util.List;

@ManagedBean
public class SecurityBean implements Serializable {

    private EntityManagerFactory myEntityManagerFactory;

    public SecurityBean(){
        myEntityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
    }

    private EntityManagerFactory getEntityManagerFactory() {
        return myEntityManagerFactory;
    }

    public String getCurrentUsername(){
        return FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
    }

    public UserEntity getCurrentUserEntity(){
        EntityManager em = getEntityManagerFactory().createEntityManager();
        List<UserEntity> users = em.createQuery("SELECT o FROM UserEntity o",UserEntity.class).getResultList();
        for(UserEntity ue: users){
            if(ue.getUsername().equals(this.getCurrentUsername())){
                return ue;
            }
        }
        return null;
    }
}
