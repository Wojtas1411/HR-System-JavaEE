package users;

import entities.PersonalDataEntity;
import entities.TemporaryPersonalDataEntity;
import entities.UserEntity;

import javax.faces.context.FacesContext;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class MyDataBean implements Serializable {

    private EntityManagerFactory myEntityManagerFactory;
    private UserEntity myUser;

    public MyDataBean(){
        myEntityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        SecurityBean sb = new SecurityBean();
        myUser = sb.getCurrentUserEntity();
    }

    private EntityManagerFactory getEntityManagerFactory() {
        return myEntityManagerFactory;
    }

    public PersonalDataEntity getUserData(){
        return myUser.getPersonalDataById();
    }

    public void requestDataEdit() throws IOException {
        TemporaryPersonalDataEntity temp = new TemporaryPersonalDataEntity();
        temp.setTimestamp(new Timestamp(new Date().getTime()));
        temp.setUserId(myUser.getUsername());
        temp.setFamilyName(myUser.getPersonalDataById().getFamilyName());
        temp.setFirstName(myUser.getPersonalDataById().getFirstName());
        temp.setBirthDate(myUser.getPersonalDataById().getBirthDate());
        temp.setBirthPlace(myUser.getPersonalDataById().getBirthPlace());
        temp.setPhoto(myUser.getPersonalDataById().getPhoto());

        //email
        Jsonb jsonb = JsonbBuilder.create();
        temp.setEmails(jsonb.toJson(myUser.getPersonalDataById().getEmailsById()));

        //phone numbers
        temp.setPhoneNumbers(jsonb.toJson(myUser.getPersonalDataById().getPhoneNumbersById()));

        //addresses
        temp.setAdres(jsonb.toJson(myUser.getPersonalDataById().getAdresById()));

        //persist
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(temp);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            try {
                entityManager.getTransaction().rollback();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        entityManager.close();

        FacesContext.getCurrentInstance().getExternalContext().redirect("mydata.xhtml");
    }
}
