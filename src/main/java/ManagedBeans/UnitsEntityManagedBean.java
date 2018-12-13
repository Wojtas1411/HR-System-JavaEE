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

import entities.UnitsEntity;

public class UnitsEntityManagedBean implements Serializable {
    final public static String SELECT_ALL_ENTITIES_SQL = "SELECT o FROM UnitsEntity AS o";

    private UnitsEntity myEntity;

    private EntityManagerFactory myEntityManagerFactory;

    private ListDataModel myList;
    private ListDataModel myReferencesEntities; // M-N and M-1 references

    public UnitsEntityManagedBean() {
        myEntityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
    }

    private EntityManagerFactory getEntityManagerFactory() {
        return myEntityManagerFactory;
    }

    public UnitsEntity getEntity() {
        return myEntity;
    }

    public void setEntity(UnitsEntity entity) {
        myEntity = entity;
    }

    // add new UnitsEntity
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

        return "unitsEntityList";
    }

    // save edited UnitsEntity
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
        return "unitsEntityList";
    }

    // delete UnitsEntity
    public String delete() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            UnitsEntity entity = getCurrentEntity();
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

        return "unitsEntityList";
    }

    public DataModel getReferencedEntities() {
        return myReferencesEntities;
    }

    public void setReferencedEntities(Collection<UnitsEntity> entities) {
        myReferencesEntities = new ListDataModel(new ArrayList<UnitsEntity>(entities));
    }

    public String startCreate() {
        myEntity = new UnitsEntity();
        return "createUnitsEntity";
    }

    public String startView() {
        setEntityFromRequestParam();
        return "viewUnitsEntity";
    }

    public String startEdit() {
        setEntityFromRequestParam();
        return "editUnitsEntity";
    }

    public UnitsEntity getCurrentEntity() {
        UnitsEntity entity = getEntityFromRequestParam();

        return entity == null ? myEntity : entity;
    }

    public UnitsEntity getEntityFromRequestParam() {
        if (myList == null) return null;

        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        UnitsEntity entity = (UnitsEntity) myList.getRowData();
        entity = entityManager.merge(entity);
        entityManager.close();

        return entity;
    }

    public void setEntityFromRequestParam() {
        myEntity = getCurrentEntity();
    }

    public UnitsEntity findEntity(int id) {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();

        UnitsEntity entity = entityManager.find(UnitsEntity.class, id);

        entityManager.close();

        return entity;
    }

    public DataModel getAllEntities() {
        myList = new ListDataModel(getEntities());

        return myList;
    }

    public SelectItem[] getAllEntitiesAsSelectedItems() {
        List<UnitsEntity> entities = getEntities();
        SelectItem[] selectItems = new SelectItem[entities.size()];
        //selectItems[0] = new SelectItem(null, "None"); //add none option
        int i = 0;
        for (UnitsEntity entity : entities) {
            selectItems[i++] = new SelectItem(entity, entity.getName());
        }
        return selectItems;
    }

    public List<UnitsEntity> getEntities() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();

        List<UnitsEntity> entities = (List<UnitsEntity>) entityManager.createQuery(SELECT_ALL_ENTITIES_SQL).getResultList();

        entityManager.close();

        return entities;
    }
}
