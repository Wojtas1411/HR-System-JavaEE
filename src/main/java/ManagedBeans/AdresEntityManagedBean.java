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

import entities.AdresEntity;

public class AdresEntityManagedBean {
    final public static String SELECT_ALL_ENTITIES_SQL = "SELECT o FROM AdresEntity AS o";

    private AdresEntity myEntity;

    private EntityManagerFactory myEntityManagerFactory;

    private ListDataModel myList;
    private ListDataModel myReferencesEntities; // M-N and M-1 references

    public AdresEntityManagedBean() {
        myEntityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
    }

    private EntityManagerFactory getEntityManagerFactory() {
        return myEntityManagerFactory;
    }

    public AdresEntity getEntity() {
        return myEntity;
    }

    public void setEntity(AdresEntity entity) {
        myEntity = entity;
    }

    // add new AdresEntity
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

        return "adresEntityList";
    }

    // save edited AdresEntity
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
        return "adresEntityList";
    }

    // delete AdresEntity
    public String delete() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            AdresEntity entity = getCurrentEntity();
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

        return "adresEntityList";
    }

    public DataModel getReferencedEntities() {
        return myReferencesEntities;
    }

    public void setReferencedEntities(Collection<AdresEntity> entities) {
        myReferencesEntities = new ListDataModel(new ArrayList<AdresEntity>(entities));
    }

    public String startCreate() {
        myEntity = new AdresEntity();
        return "createAdresEntity";
    }

    public String startView() {
        setEntityFromRequestParam();
        return "viewAdresEntity";
    }

    public String startEdit() {
        setEntityFromRequestParam();
        return "editAdresEntity";
    }

    public AdresEntity getCurrentEntity() {
        AdresEntity entity = getEntityFromRequestParam();

        return entity == null ? myEntity : entity;
    }

    public AdresEntity getEntityFromRequestParam() {
        if (myList == null) return null;

        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        AdresEntity entity = (AdresEntity) myList.getRowData();
        entity = entityManager.merge(entity);
        entityManager.close();

        return entity;
    }

    public void setEntityFromRequestParam() {
        myEntity = getCurrentEntity();
    }

    public AdresEntity findEntity(int id) {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();

        AdresEntity entity = entityManager.find(AdresEntity.class, id);

        entityManager.close();

        return entity;
    }

    public DataModel getAllEntities() {
        myList = new ListDataModel(getEntities());

        return myList;
    }

    public SelectItem[] getAllEntitiesAsSelectedItems() {
        List<AdresEntity> entities = getEntities();
        SelectItem[] selectItems = new SelectItem[entities.size()];
        int i = 0;
        for (AdresEntity entity : entities) {
            selectItems[i++] = new SelectItem(entity);
        }
        return selectItems;
    }

    public List<AdresEntity> getEntities() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();

        List<AdresEntity> entities = (List<AdresEntity>) entityManager.createQuery(SELECT_ALL_ENTITIES_SQL).getResultList();

        entityManager.close();

        return entities;
    }
}
