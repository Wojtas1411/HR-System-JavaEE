package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UnitsEntity.class)
public abstract class UnitsEntity_ {

	public static volatile SingularAttribute<UnitsEntity, UnitsEntity> unitsByParentId;
	public static volatile SingularAttribute<UnitsEntity, String> name;
	public static volatile SingularAttribute<UnitsEntity, PersonalDataEntity> personalDataByBossId;
	public static volatile SingularAttribute<UnitsEntity, Integer> id;
	public static volatile SingularAttribute<UnitsEntity, String> type;
	public static volatile CollectionAttribute<UnitsEntity, UnitsEntity> unitsById;
	public static volatile CollectionAttribute<UnitsEntity, MembershipEntity> membershipsById;

	public static final String UNITS_BY_PARENT_ID = "unitsByParentId";
	public static final String NAME = "name";
	public static final String PERSONAL_DATA_BY_BOSS_ID = "personalDataByBossId";
	public static final String ID = "id";
	public static final String TYPE = "type";
	public static final String UNITS_BY_ID = "unitsById";
	public static final String MEMBERSHIPS_BY_ID = "membershipsById";

}

