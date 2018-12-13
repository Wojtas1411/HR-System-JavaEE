package entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PersonalDataEntity.class)
public abstract class PersonalDataEntity_ {

	public static volatile SingularAttribute<PersonalDataEntity, UserEntity> userByUserIdId;
	public static volatile CollectionAttribute<PersonalDataEntity, PhoneNumbersEntity> phoneNumbersById;
	public static volatile SingularAttribute<PersonalDataEntity, JobDataEntity> jobDataById;
	public static volatile SingularAttribute<PersonalDataEntity, String> photo;
	public static volatile SingularAttribute<PersonalDataEntity, Date> birthDate;
	public static volatile CollectionAttribute<PersonalDataEntity, MembershipEntity> membershipsById;
	public static volatile SingularAttribute<PersonalDataEntity, String> firstName;
	public static volatile SingularAttribute<PersonalDataEntity, String> birthPlace;
	public static volatile CollectionAttribute<PersonalDataEntity, EmailsEntity> emailsById;
	public static volatile SingularAttribute<PersonalDataEntity, EngagementEntity> engagementsById;
	public static volatile SingularAttribute<PersonalDataEntity, String> familyName;
	public static volatile CollectionAttribute<PersonalDataEntity, AdresEntity> adresById;
	public static volatile SingularAttribute<PersonalDataEntity, Integer> id;
	public static volatile CollectionAttribute<PersonalDataEntity, UnitsEntity> unitsById;

	public static final String USER_BY_USER_ID_ID = "userByUserIdId";
	public static final String PHONE_NUMBERS_BY_ID = "phoneNumbersById";
	public static final String JOB_DATA_BY_ID = "jobDataById";
	public static final String PHOTO = "photo";
	public static final String BIRTH_DATE = "birthDate";
	public static final String MEMBERSHIPS_BY_ID = "membershipsById";
	public static final String FIRST_NAME = "firstName";
	public static final String BIRTH_PLACE = "birthPlace";
	public static final String EMAILS_BY_ID = "emailsById";
	public static final String ENGAGEMENTS_BY_ID = "engagementsById";
	public static final String FAMILY_NAME = "familyName";
	public static final String ADRES_BY_ID = "adresById";
	public static final String ID = "id";
	public static final String UNITS_BY_ID = "unitsById";

}

