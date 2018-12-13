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

import entities.PersonalDataEntity;

public class PersonalDataEntityManagedBean implements Serializable {
    final public static String SELECT_ALL_ENTITIES_SQL = "SELECT o FROM PersonalDataEntity AS o";

    private PersonalDataEntity myEntity;

    private EntityManagerFactory myEntityManagerFactory;

    private ListDataModel myList;
    private ListDataModel myReferencesEntities; // M-N and M-1 references

    public PersonalDataEntityManagedBean() {
        myEntityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
    }

    private EntityManagerFactory getEntityManagerFactory() {
        return myEntityManagerFactory;
    }

    public PersonalDataEntity getEntity() {
        return myEntity;
    }

    public void setEntity(PersonalDataEntity entity) {
        myEntity = entity;
    }

    // add new PersonalDataEntity
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

        return "personalDataEntityList";
    }

    // save edited PersonalDataEntity
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
        return "personalDataEntityList";
    }

    // delete PersonalDataEntity
    public String delete() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            PersonalDataEntity entity = getCurrentEntity();
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

        return "personalDataEntityList";
    }

    public DataModel getReferencedEntities() {
        return myReferencesEntities;
    }

    public void setReferencedEntities(Collection<PersonalDataEntity> entities) {
        myReferencesEntities = new ListDataModel(new ArrayList<PersonalDataEntity>(entities));
    }

    public String startCreate() {
        myEntity = new PersonalDataEntity();
        return "createPersonalDataEntity";
    }

    public String startView() {
        setEntityFromRequestParam();
        return "viewPersonalDataEntity";
    }

    public String startEdit() {
        setEntityFromRequestParam();
        return "editPersonalDataEntity";
    }

    public PersonalDataEntity getCurrentEntity() {
        PersonalDataEntity entity = getEntityFromRequestParam();

        return entity == null ? myEntity : entity;
    }

    public PersonalDataEntity getEntityFromRequestParam() {
        if (myList == null) return null;

        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        PersonalDataEntity entity = (PersonalDataEntity) myList.getRowData();
        entity = entityManager.merge(entity);
        entityManager.close();

        return entity;
    }

    public void setEntityFromRequestParam() {
        myEntity = getCurrentEntity();
    }

    public PersonalDataEntity findEntity(int id) {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();

        PersonalDataEntity entity = entityManager.find(PersonalDataEntity.class, id);

        entityManager.close();

        return entity;
    }

    public DataModel getAllEntities() {
        myList = new ListDataModel(getEntities());

        return myList;
    }

    public SelectItem[] getAllEntitiesAsSelectedItems() {
        List<PersonalDataEntity> entities = getEntities();
        SelectItem selectItems[] = new SelectItem[entities.size()];
        int i = 0;
        for (PersonalDataEntity entity : entities) {
            selectItems[i++] = new SelectItem(entity, entity.getFamilyName()+" "+entity.getFirstName());
        }
        return selectItems;
    }

    public List<PersonalDataEntity> getEntities() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();

        List<PersonalDataEntity> entities = (List<PersonalDataEntity>) entityManager.createQuery(SELECT_ALL_ENTITIES_SQL).getResultList();

        entityManager.close();

        return entities;
    }
}
