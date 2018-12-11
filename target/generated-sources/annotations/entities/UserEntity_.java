package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UserEntity.class)
public abstract class UserEntity_ {

	public static volatile SingularAttribute<UserEntity, String> password;
	public static volatile SingularAttribute<UserEntity, String> roles;
	public static volatile CollectionAttribute<UserEntity, PersonalDataEntity> personalDataById;
	public static volatile SingularAttribute<UserEntity, Integer> id;
	public static volatile SingularAttribute<UserEntity, String> username;

	public static final String PASSWORD = "password";
	public static final String ROLES = "roles";
	public static final String PERSONAL_DATA_BY_ID = "personalDataById";
	public static final String ID = "id";
	public static final String USERNAME = "username";

}

