package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AdresEntity.class)
public abstract class AdresEntity_ {

	public static volatile SingularAttribute<AdresEntity, String> number;
	public static volatile SingularAttribute<AdresEntity, Byte> prim;
	public static volatile SingularAttribute<AdresEntity, String> town;
	public static volatile SingularAttribute<AdresEntity, String> street;
	public static volatile SingularAttribute<AdresEntity, String> postalCode;
	public static volatile SingularAttribute<AdresEntity, PersonalDataEntity> personalDataByUserId;
	public static volatile SingularAttribute<AdresEntity, Integer> id;
	public static volatile SingularAttribute<AdresEntity, String> local;

	public static final String NUMBER = "number";
	public static final String PRIM = "prim";
	public static final String TOWN = "town";
	public static final String STREET = "street";
	public static final String POSTAL_CODE = "postalCode";
	public static final String PERSONAL_DATA_BY_USER_ID = "personalDataByUserId";
	public static final String ID = "id";
	public static final String LOCAL = "local";

}

