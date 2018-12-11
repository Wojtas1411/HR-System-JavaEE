package entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "job_data", schema = "javaee", catalog = "")
public class JobDataEntity {
    private int id;
    private Date startContract;
    private Date endContract;
    private int monthlySalary;
    private int workingHoursPerWeek;
    private String bankInfo;
    private String bankAccountNumber;
    private PersonalDataEntity personalDataByUserId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "start_contract")
    public Date getStartContract() {
        return startContract;
    }

    public void setStartContract(Date startContract) {
        this.startContract = startContract;
    }

    @Basic
    @Column(name = "end_contract")
    public Date getEndContract() {
        return endContract;
    }

    public void setEndContract(Date endContract) {
        this.endContract = endContract;
    }

    @Basic
    @Column(name = "monthly_salary")
    public int getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(int monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    @Basic
    @Column(name = "working_hours_per_week")
    public int getWorkingHoursPerWeek() {
        return workingHoursPerWeek;
    }

    public void setWorkingHoursPerWeek(int workingHoursPerWeek) {
        this.workingHoursPerWeek = workingHoursPerWeek;
    }

    @Basic
    @Column(name = "bank_info")
    public String getBankInfo() {
        return bankInfo;
    }

    public void setBankInfo(String bankInfo) {
        this.bankInfo = bankInfo;
    }

    @Basic
    @Column(name = "bank_account_number")
    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobDataEntity that = (JobDataEntity) o;
        return id == that.id &&
                monthlySalary == that.monthlySalary &&
                workingHoursPerWeek == that.workingHoursPerWeek &&
                Objects.equals(startContract, that.startContract) &&
                Objects.equals(endContract, that.endContract) &&
                Objects.equals(bankInfo, that.bankInfo) &&
                Objects.equals(bankAccountNumber, that.bankAccountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startContract, endContract, monthlySalary, workingHoursPerWeek, bankInfo, bankAccountNumber);
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public PersonalDataEntity getPersonalDataByUserId() {
        return personalDataByUserId;
    }

    public void setPersonalDataByUserId(PersonalDataEntity personalDataByUserId) {
        this.personalDataByUserId = personalDataByUserId;
    }
}
