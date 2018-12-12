package ManagedBeans;

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

import entities.StaffCategoryEntity;

public class StaffCategoryEntityManagedBean {
    final public static String SELECT_ALL_ENTITIES_SQL = "SELECT o FROM StaffCategoryEntity AS o";

    private StaffCategoryEntity myEntity;

    private EntityManagerFactory myEntityManagerFactory;

    private ListDataModel myList;
    private ListDataModel myReferencesEntities; // M-N and M-1 references

    public StaffCategoryEntityManagedBean() {
        myEntityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
    }

    private EntityManagerFactory getEntityManagerFactory() {
        return myEntityManagerFactory;
    }

    public StaffCategoryEntity getEntity() {
        return myEntity;
    }

    public void setEntity(StaffCategoryEntity entity) {
        myEntity = entity;
    }

    // add new StaffCategoryEntity
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

        return "staffCategoryEntityList";
    }

    // save edited StaffCategoryEntity
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
        return "staffCategoryEntityList";
    }

    // delete StaffCategoryEntity
    public String delete() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            StaffCategoryEntity entity = getCurrentEntity();
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

        return "staffCategoryEntityList";
    }

    public DataModel getReferencedEntities() {
        return myReferencesEntities;
    }

    public void setReferencedEntities(Collection<StaffCategoryEntity> entities) {
        myReferencesEntities = new ListDataModel(new ArrayList<StaffCategoryEntity>(entities));
    }

    public String startCreate() {
        myEntity = new StaffCategoryEntity();
        return "createStaffCategoryEntity";
    }

    public String startView() {
        setEntityFromRequestParam();
        return "viewStaffCategoryEntity";
    }

    public String startEdit() {
        setEntityFromRequestParam();
        return "editStaffCategoryEntity";
    }

    public StaffCategoryEntity getCurrentEntity() {
        StaffCategoryEntity entity = getEntityFromRequestParam();

        return entity == null ? myEntity : entity;
    }

    public StaffCategoryEntity getEntityFromRequestParam() {
        if (myList == null) return null;

        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        StaffCategoryEntity entity = (StaffCategoryEntity) myList.getRowData();
        entity = entityManager.merge(entity);
        entityManager.close();

        return entity;
    }

    public void setEntityFromRequestParam() {
        myEntity = getCurrentEntity();
    }

    public StaffCategoryEntity findEntity(int id) {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();

        StaffCategoryEntity entity = entityManager.find(StaffCategoryEntity.class, id);

        entityManager.close();

        return entity;
    }

    public DataModel getAllEntities() {
        myList = new ListDataModel(getEntities());

        return myList;
    }

    public SelectItem[] getAllEntitiesAsSelectedItems() {
        List<StaffCategoryEntity> entities = getEntities();
        SelectItem selectItems[] = new SelectItem[entities.size()];
        int i = 0;
        for (StaffCategoryEntity entity : entities) {
            selectItems[i++] = new SelectItem(entity, entity.getName());
        }
        return selectItems;
    }

    public List<StaffCategoryEntity> getEntities() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();

        List<StaffCategoryEntity> entities = (List<StaffCategoryEntity>) entityManager.createQuery(SELECT_ALL_ENTITIES_SQL).getResultList();

        entityManager.close();

        return entities;
    }
}
