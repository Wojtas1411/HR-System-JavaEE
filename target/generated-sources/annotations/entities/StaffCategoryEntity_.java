package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(StaffCategoryEntity.class)
public abstract class StaffCategoryEntity_ {

	public static volatile CollectionAttribute<StaffCategoryEntity, EngagementEntity> engagementsById;
	public static volatile SingularAttribute<StaffCategoryEntity, String> name;
	public static volatile SingularAttribute<StaffCategoryEntity, Integer> id;

	public static final String ENGAGEMENTS_BY_ID = "engagementsById";
	public static final String NAME = "name";
	public static final String ID = "id";

}

