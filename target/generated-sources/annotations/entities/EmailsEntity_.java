package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EmailsEntity.class)
public abstract class EmailsEntity_ {

	public static volatile SingularAttribute<EmailsEntity, Byte> prim;
	public static volatile SingularAttribute<EmailsEntity, PersonalDataEntity> personalDataByUserId;
	public static volatile SingularAttribute<EmailsEntity, Integer> id;
	public static volatile SingularAttribute<EmailsEntity, String> value;

	public static final String PRIM = "prim";
	public static final String PERSONAL_DATA_BY_USER_ID = "personalDataByUserId";
	public static final String ID = "id";
	public static final String VALUE = "value";

}

