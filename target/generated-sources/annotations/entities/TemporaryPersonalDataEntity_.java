package entities;

import java.sql.Timestamp;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TemporaryPersonalDataEntity.class)
public abstract class TemporaryPersonalDataEntity_ {

	public static volatile SingularAttribute<TemporaryPersonalDataEntity, String> emails;
	public static volatile SingularAttribute<TemporaryPersonalDataEntity, String> firstName;
	public static volatile SingularAttribute<TemporaryPersonalDataEntity, String> birthPlace;
	public static volatile SingularAttribute<TemporaryPersonalDataEntity, String> familyName;
	public static volatile SingularAttribute<TemporaryPersonalDataEntity, String> photo;
	public static volatile SingularAttribute<TemporaryPersonalDataEntity, Integer> id;
	public static volatile SingularAttribute<TemporaryPersonalDataEntity, String> adres;
	public static volatile SingularAttribute<TemporaryPersonalDataEntity, String> userId;
	public static volatile SingularAttribute<TemporaryPersonalDataEntity, Date> birthDate;
	public static volatile SingularAttribute<TemporaryPersonalDataEntity, String> phoneNumbers;
	public static volatile SingularAttribute<TemporaryPersonalDataEntity, Timestamp> timestamp;

	public static final String EMAILS = "emails";
	public static final String FIRST_NAME = "firstName";
	public static final String BIRTH_PLACE = "birthPlace";
	public static final String FAMILY_NAME = "familyName";
	public static final String PHOTO = "photo";
	public static final String ID = "id";
	public static final String ADRES = "adres";
	public static final String USER_ID = "userId";
	public static final String BIRTH_DATE = "birthDate";
	public static final String PHONE_NUMBERS = "phoneNumbers";
	public static final String TIMESTAMP = "timestamp";

}

