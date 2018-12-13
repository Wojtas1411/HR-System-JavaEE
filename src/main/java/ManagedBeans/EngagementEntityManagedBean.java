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

import entities.EngagementEntity;

public class EngagementEntityManagedBean implements Serializable {
    final public static String SELECT_ALL_ENTITIES_SQL = "SELECT o FROM EngagementEntity AS o";

    private EngagementEntity myEntity;

    private EntityManagerFactory myEntityManagerFactory;

    private ListDataModel myList;
    private ListDataModel myReferencesEntities; // M-N and M-1 references

    public EngagementEntityManagedBean() {
        myEntityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
    }

    private EntityManagerFactory getEntityManagerFactory() {
        return myEntityManagerFactory;
    }

    public EngagementEntity getEntity() {
        return myEntity;
    }

    public void setEntity(EngagementEntity entity) {
        myEntity = entity;
    }

    // add new EngagementEntity
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

        return "engagementEntityList";
    }

    // save edited EngagementEntity
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
        return "engagementEntityList";
    }

    // delete EngagementEntity
    public String delete() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            EngagementEntity entity = getCurrentEntity();
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

        return "engagementEntityList";
    }

    public DataModel getReferencedEntities() {
        return myReferencesEntities;
    }

    public void setReferencedEntities(Collection<EngagementEntity> entities) {
        myReferencesEntities = new ListDataModel(new ArrayList<EngagementEntity>(entities));
    }

    public String startCreate() {
        myEntity = new EngagementEntity();
        return "createEngagementEntity";
    }

    public String startView() {
        setEntityFromRequestParam();
        return "viewEngagementEntity";
    }

    public String startEdit() {
        setEntityFromRequestParam();
        return "editEngagementEntity";
    }

    public EngagementEntity getCurrentEntity() {
        EngagementEntity entity = getEntityFromRequestParam();

        return entity == null ? myEntity : entity;
    }

    public EngagementEntity getEntityFromRequestParam() {
        if (myList == null) return null;

        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        EngagementEntity entity = (EngagementEntity) myList.getRowData();
        entity = entityManager.merge(entity);
        entityManager.close();

        return entity;
    }

    public void setEntityFromRequestParam() {
        myEntity = getCurrentEntity();
    }

    public EngagementEntity findEntity(int id) {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();

        EngagementEntity entity = entityManager.find(EngagementEntity.class, id);

        entityManager.close();

        return entity;
    }

    public DataModel getAllEntities() {
        myList = new ListDataModel(getEntities());

        return myList;
    }

    public SelectItem[] getAllEntitiesAsSelectedItems() {
        List<EngagementEntity> entities = getEntities();
        SelectItem selectItems[] = new SelectItem[entities.size()];
        int i = 0;
        for (EngagementEntity entity : entities) {
            selectItems[i++] = new SelectItem(entity);
        }
        return selectItems;
    }

    public List<EngagementEntity> getEntities() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();

        List<EngagementEntity> entities = (List<EngagementEntity>) entityManager.createQuery(SELECT_ALL_ENTITIES_SQL).getResultList();

        entityManager.close();

        return entities;
    }
}
