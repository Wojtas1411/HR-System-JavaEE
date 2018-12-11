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

import entities.TemporaryPersonalDataEntity;

public class TemporaryPersonalDataEntityManagedBean {
    final public static String SELECT_ALL_ENTITIES_SQL = "SELECT o FROM TemporaryPersonalDataEntity AS o";

    private TemporaryPersonalDataEntity myEntity;

    private EntityManagerFactory myEntityManagerFactory;

    private ListDataModel myList;
    private ListDataModel myReferencesEntities; // M-N and M-1 references

    public TemporaryPersonalDataEntityManagedBean() {
        myEntityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
    }

    private EntityManagerFactory getEntityManagerFactory() {
        return myEntityManagerFactory;
    }

    public TemporaryPersonalDataEntity getEntity() {
        return myEntity;
    }

    public void setEntity(TemporaryPersonalDataEntity entity) {
        myEntity = entity;
    }

    // add new TemporaryPersonalDataEntity
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

        return "temporaryPersonalDataEntityList";
    }

    // save edited TemporaryPersonalDataEntity
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
        return "temporaryPersonalDataEntityList";
    }

    // delete TemporaryPersonalDataEntity
    public String delete() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            TemporaryPersonalDataEntity entity = getCurrentEntity();
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

        return "temporaryPersonalDataEntityList";
    }

    public DataModel getReferencedEntities() {
        return myReferencesEntities;
    }

    public void setReferencedEntities(Collection<TemporaryPersonalDataEntity> entities) {
        myReferencesEntities = new ListDataModel(new ArrayList<TemporaryPersonalDataEntity>(entities));
    }

    public String startCreate() {
        myEntity = new TemporaryPersonalDataEntity();
        return "createTemporaryPersonalDataEntity";
    }

    public String startView() {
        setEntityFromRequestParam();
        return "viewTemporaryPersonalDataEntity";
    }

    public String startEdit() {
        setEntityFromRequestParam();
        return "editTemporaryPersonalDataEntity";
    }

    public TemporaryPersonalDataEntity getCurrentEntity() {
        TemporaryPersonalDataEntity entity = getEntityFromRequestParam();

        return entity == null ? myEntity : entity;
    }

    public TemporaryPersonalDataEntity getEntityFromRequestParam() {
        if (myList == null) return null;

        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        TemporaryPersonalDataEntity entity = (TemporaryPersonalDataEntity) myList.getRowData();
        entity = entityManager.merge(entity);
        entityManager.close();

        return entity;
    }

    public void setEntityFromRequestParam() {
        myEntity = getCurrentEntity();
    }

    public TemporaryPersonalDataEntity findEntity(int id) {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();

        TemporaryPersonalDataEntity entity = entityManager.find(TemporaryPersonalDataEntity.class, id);

        entityManager.close();

        return entity;
    }

    public DataModel getAllEntities() {
        myList = new ListDataModel(getEntities());

        return myList;
    }

    public SelectItem[] getAllEntitiesAsSelectedItems() {
        List<TemporaryPersonalDataEntity> entities = getEntities();
        SelectItem selectItems[] = new SelectItem[entities.size()];
        int i = 0;
        for (TemporaryPersonalDataEntity entity : entities) {
            selectItems[i++] = new SelectItem(entity);
        }
        return selectItems;
    }

    public List<TemporaryPersonalDataEntity> getEntities() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();

        List<TemporaryPersonalDataEntity> entities = (List<TemporaryPersonalDataEntity>) entityManager.createQuery(SELECT_ALL_ENTITIES_SQL).getResultList();

        entityManager.close();

        return entities;
    }
}
