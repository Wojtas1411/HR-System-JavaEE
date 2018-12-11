package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EngagementEntity.class)
public abstract class EngagementEntity_ {

	public static volatile SingularAttribute<EngagementEntity, StaffCategoryEntity> staffCategoryByStaffCategoryId;
	public static volatile SingularAttribute<EngagementEntity, Integer> id;
	public static volatile SingularAttribute<EngagementEntity, PersonalDataEntity> personalDataByPersonId;

	public static final String STAFF_CATEGORY_BY_STAFF_CATEGORY_ID = "staffCategoryByStaffCategoryId";
	public static final String ID = "id";
	public static final String PERSONAL_DATA_BY_PERSON_ID = "personalDataByPersonId";

}

