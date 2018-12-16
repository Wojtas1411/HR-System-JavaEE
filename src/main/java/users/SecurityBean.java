package users;

import entities.UnitsEntity;
import entities.UserEntity;

import javax.annotation.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;
import java.util.ArrayList;
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

    public List<UnitsEntity> getMyUnits(){
        EntityManager em = getEntityManagerFactory().createEntityManager();
        List<UnitsEntity> ue = em.createQuery("select o from UnitsEntity o", UnitsEntity.class).getResultList();
        List<UnitsEntity> ret = new ArrayList<>();
        for(UnitsEntity u:ue){
            if(u.getPersonalDataByBossId().getUserByUserIdId().getUsername().equals(this.getCurrentUsername())){
                ret.add(u);
            }
        }

        return ret;
    }

    //check hierarchical roles

    public boolean isGrantedAdmin(){
        return getCurrentUserEntity().getRoles().equals("ROLE_ADMIN");
    }

    public boolean isGrantedHR(){
        return getCurrentUserEntity().getRoles().equals("ROLE_HR") || isGrantedAdmin();
    }

    public boolean isGrantedUser(){
        return  getCurrentUserEntity().getRoles().equals("ROLE_USER") || isGrantedHR();
    }
}
