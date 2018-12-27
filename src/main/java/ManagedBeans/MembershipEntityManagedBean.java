package ManagedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entities.MembershipEntity;

public class MembershipEntityManagedBean implements Serializable {
    final public static String SELECT_ALL_ENTITIES_SQL = "SELECT o FROM MembershipEntity AS o";

    private MembershipEntity myEntity;

    private EntityManagerFactory myEntityManagerFactory;

    private ListDataModel myList;
    private ListDataModel myReferencesEntities; // M-N and M-1 references

    public MembershipEntityManagedBean() {
        myEntityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
    }

    private EntityManagerFactory getEntityManagerFactory() {
        return myEntityManagerFactory;
    }

    public MembershipEntity getEntity() {
        return myEntity;
    }

    public void setEntity(MembershipEntity entity) {
        myEntity = entity;
    }

    // add new MembershipEntity
    public String create() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(getEntity());
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            try {
                entityManager.getTransaction().rollback();
            } catch (Exception e) {
            }
        }
        entityManager.close();

        return "membershipEntityList";
    }

    // save edited MembershipEntity
    public String save() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            myEntity = entityManager.merge(getEntity());
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            try {
                entityManager.getTransaction().rollback();
            } catch (Exception e) {
            }
        }
        entityManager.close();
        return "membershipEntityList";
    }

    // delete MembershipEntity
    public String delete() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            MembershipEntity entity = getCurrentEntity();
            entity = entityManager.merge(entity);
            entityManager.remove(entity);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            try {
                entityManager.getTransaction().rollback();
            } catch (Exception e) {
            }
        }
        entityManager.close();

        return "membershipEntityList";
    }

    public DataModel getReferencedEntities() {
        return myReferencesEntities;
    }

    public void setReferencedEntities(Collection<MembershipEntity> entities) {
        myReferencesEntities = new ListDataModel(new ArrayList<MembershipEntity>(entities));
    }

    public String startCreate() {
        myEntity = new MembershipEntity();
        return "createMembershipEntity";
    }

    public String startView() {
        setEntityFromRequestParam();
        return "viewMembershipEntity";
    }

    public String startEdit() {
        setEntityFromRequestParam();
        return "editMembershipEntity";
    }

    public MembershipEntity getCurrentEntity() {
        MembershipEntity entity = getEntityFromRequestParam();

        return entity == null ? myEntity : entity;
    }

    public MembershipEntity getEntityFromRequestParam() {
        if (myList == null) return null;

        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        MembershipEntity entity = (MembershipEntity) myList.getRowData();
        entity = entityManager.merge(entity);
        entityManager.close();

        return entity;
    }

    public void setEntityFromRequestParam() {
        myEntity = getCurrentEntity();
    }

    public MembershipEntity findEntity(int id) {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();

        MembershipEntity entity = entityManager.find(MembershipEntity.class, id);

        entityManager.close();

        return entity;
    }

    public DataModel getAllEntities() {
        myList = new ListDataModel(getEntities());

        return myList;
    }

    public SelectItem[] getAllEntitiesAsSelectedItems() {
        List<MembershipEntity> entities = getEntities();
        SelectItem selectItems[] = new SelectItem[entities.size()];
        int i = 0;
        for (MembershipEntity entity : entities) {
            selectItems[i++] = new SelectItem(entity);
        }
        return selectItems;
    }

    public List<MembershipEntity> getEntities() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();

        List<MembershipEntity> entities = (List<MembershipEntity>) entityManager.createQuery(SELECT_ALL_ENTITIES_SQL).getResultList();

        entityManager.close();

        return entities;
    }

    public int getMagicValue(){
        if(myEntity.getPersonalDataByPersonId() == null){
            return 40;
        }
        if(myEntity.getPersonalDataByPersonId().getJobDataById() == null){
            return -1;
        }
        Collection<MembershipEntity> all = myEntity.getPersonalDataByPersonId().getMembershipsById();
        int num = 0;
        int max = myEntity.getPersonalDataByPersonId().getJobDataById().getWorkingHoursPerWeek();
        for(MembershipEntity m : all){
            if(myEntity.getId() != m.getId()){
                num += m.getWorkingHoursPerWeek();
            }
        }

        if(num>max) return 0;
        return max-num;
    }
}
