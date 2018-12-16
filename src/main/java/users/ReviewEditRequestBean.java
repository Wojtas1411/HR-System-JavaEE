package users;

import entities.*;

import javax.annotation.ManagedBean;
import javax.faces.context.FacesContext;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@ManagedBean
public class ReviewEditRequestBean implements Serializable {
    private EntityManagerFactory myEntityManagerFactory;
    private PersonalDataEntity myPersonalData;
    private TemporaryPersonalDataEntity temp;

    public ReviewEditRequestBean(){
        myEntityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");

        //get first temporary personal data
        List<TemporaryPersonalDataEntity> list = myEntityManagerFactory.createEntityManager().
                createQuery("select o from TemporaryPersonalDataEntity o ORDER BY o.timestamp ASC",TemporaryPersonalDataEntity.class).getResultList();

        if(list.size()==0){
            temp=null;
            myPersonalData=null;
        } else {
            temp = list.get(0);

            UserEntity ue = myEntityManagerFactory.createEntityManager().createQuery("select o from UserEntity o where o.username=:name", UserEntity.class)
                    .setParameter("name", temp.getUserId()).getSingleResult();

            myPersonalData = ue.getPersonalDataById();
            myPersonalData.setId(ue.getPersonalDataById().getId());
            myPersonalData.setFamilyName(temp.getFamilyName());
            myPersonalData.setFirstName(temp.getFirstName());
            myPersonalData.setBirthDate(temp.getBirthDate());
            myPersonalData.setBirthPlace(temp.getBirthPlace());
            myPersonalData.setPhoto(temp.getPhoto());

            Jsonb jsonb = JsonbBuilder.create();

            //emails
            Collection<EmailsEntity> temp_emails;

            temp_emails = jsonb.fromJson(temp.getEmails(), new ArrayList<EmailsEntity>() {
            }.getClass().getGenericSuperclass());

            for (EmailsEntity e : temp_emails) {
                e.setPersonalDataByUserId(myPersonalData);
            }

            myPersonalData.setEmailsById(temp_emails);

            //phone numbers

            Collection<PhoneNumbersEntity> temp_phone_numbers = jsonb.fromJson(temp.getPhoneNumbers(), new ArrayList<PhoneNumbersEntity>() {
            }.getClass().getGenericSuperclass());

            for (PhoneNumbersEntity p : temp_phone_numbers) {
                p.setPersonalDataByUserId(myPersonalData);
            }

            myPersonalData.setPhoneNumbersById(temp_phone_numbers);

            //addresses

            Collection<AdresEntity> temp_adres = jsonb.fromJson(temp.getAdres(), new ArrayList<AdresEntity>() {
            }.getClass().getGenericSuperclass());

            for (AdresEntity a : temp_adres) {
                a.setPersonalDataByUserId(myPersonalData);
            }

            myPersonalData.setAdresById(temp_adres);
        }

    }

    private EntityManagerFactory getEntityManagerFactory() {
        return myEntityManagerFactory;
    }

    public PersonalDataEntity getUserData(){
        return myPersonalData;
    }

    public void accept_temp() throws IOException {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        //email
        for(EmailsEntity ee: myPersonalData.getEmailsById()){
            try {
                entityManager.getTransaction().begin();
                ee = entityManager.merge(ee);
                entityManager.getTransaction().commit();
            } catch (Exception ex) {
                try {
                    entityManager.getTransaction().rollback();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        //phone numbers
        for(PhoneNumbersEntity pe: myPersonalData.getPhoneNumbersById()){
            try {
                entityManager.getTransaction().begin();
                pe = entityManager.merge(pe);
                entityManager.getTransaction().commit();
            } catch (Exception ex) {
                try {
                    entityManager.getTransaction().rollback();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        //addresses
        for(AdresEntity ae : myPersonalData.getAdresById()){
            try {
                entityManager.getTransaction().begin();
                ae = entityManager.merge(ae);
                entityManager.getTransaction().commit();
            } catch (Exception ex) {
                try {
                    entityManager.getTransaction().rollback();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        //personal data
        try {
            entityManager.getTransaction().begin();
            myPersonalData = entityManager.merge(myPersonalData);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            try {
                entityManager.getTransaction().rollback();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        entityManager.close();

        this.delete_temp();
    }

    public void delete_temp() throws IOException{
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            temp = entityManager.merge(temp);
            entityManager.remove(temp);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            try {
                entityManager.getTransaction().rollback();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        entityManager.close();

        FacesContext.getCurrentInstance().getExternalContext().redirect("review_edit_request.xhtml");
    }
}
