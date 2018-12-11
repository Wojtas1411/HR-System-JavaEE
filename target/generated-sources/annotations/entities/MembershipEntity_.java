package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MembershipEntity.class)
public abstract class MembershipEntity_ {

	public static volatile SingularAttribute<MembershipEntity, UnitsEntity> unitsByUnitId;
	public static volatile SingularAttribute<MembershipEntity, Integer> workingHoursPerWeek;
	public static volatile SingularAttribute<MembershipEntity, Integer> id;
	public static volatile SingularAttribute<MembershipEntity, PersonalDataEntity> personalDataByPersonId;

	public static final String UNITS_BY_UNIT_ID = "unitsByUnitId";
	public static final String WORKING_HOURS_PER_WEEK = "workingHoursPerWeek";
	public static final String ID = "id";
	public static final String PERSONAL_DATA_BY_PERSON_ID = "personalDataByPersonId";

}

