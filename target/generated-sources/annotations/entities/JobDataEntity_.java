package entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(JobDataEntity.class)
public abstract class JobDataEntity_ {

	public static volatile SingularAttribute<JobDataEntity, Integer> monthlySalary;
	public static volatile SingularAttribute<JobDataEntity, String> bankInfo;
	public static volatile SingularAttribute<JobDataEntity, Integer> workingHoursPerWeek;
	public static volatile SingularAttribute<JobDataEntity, PersonalDataEntity> personalDataByUserId;
	public static volatile SingularAttribute<JobDataEntity, String> bankAccountNumber;
	public static volatile SingularAttribute<JobDataEntity, Integer> id;
	public static volatile SingularAttribute<JobDataEntity, Date> startContract;
	public static volatile SingularAttribute<JobDataEntity, Date> endContract;

	public static final String MONTHLY_SALARY = "monthlySalary";
	public static final String BANK_INFO = "bankInfo";
	public static final String WORKING_HOURS_PER_WEEK = "workingHoursPerWeek";
	public static final String PERSONAL_DATA_BY_USER_ID = "personalDataByUserId";
	public static final String BANK_ACCOUNT_NUMBER = "bankAccountNumber";
	public static final String ID = "id";
	public static final String START_CONTRACT = "startContract";
	public static final String END_CONTRACT = "endContract";

}

