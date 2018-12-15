package plots;

import entities.EngagementEntity;
import entities.MembershipEntity;
import org.primefaces.model.chart.*;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ManagedBean
@RequestScoped
public class ChartView implements Serializable {
    private BarChartModel chart1;
    private BarChartModel chart2;
    private BarChartModel chart3;
    private PieChartModel chart4;

    public BarChartModel getChart1() {
        return chart1;
    }

    public void setChart1(BarChartModel chart1) {
        this.chart1 = chart1;
    }

    public BarChartModel getChart2() {
        return chart2;
    }

    public void setChart2(BarChartModel chart2) {
        this.chart2 = chart2;
    }

    public BarChartModel getChart3() {
        return chart3;
    }

    public void setChart3(BarChartModel chart3) {
        this.chart3 = chart3;
    }

    public PieChartModel getChart4() {
        return chart4;
    }

    public void setChart4(PieChartModel chart4) {
        this.chart4 = chart4;
    }

    private EntityManagerFactory myEntityManagerFactory;
    private EntityManagerFactory getEntityManagerFactory() {
        return myEntityManagerFactory;
    }

    public ChartView() {
        myEntityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
    }

    @PostConstruct
    public void init(){
        initChart1();
        initChart2();
        initChart3();
        initChart4();
    }

    private void initChart1(){
        //number of employees per department
        EntityManager em = getEntityManagerFactory().createEntityManager();
        List<MembershipEntity> pdList = em.createQuery("select o from MembershipEntity AS o", MembershipEntity.class).getResultList();

        HashMap<String, Integer> result = new HashMap<>();
        for(MembershipEntity m: pdList){
            if(!result.containsKey(m.getUnitsByUnitId().getName())){
                result.put(m.getUnitsByUnitId().getName(),1);
            } else {
                result.put(m.getUnitsByUnitId().getName(),result.get(m.getUnitsByUnitId().getName())+1);
            }
        }

        chart1 = new BarChartModel();

        ChartSeries serie1 = new ChartSeries();
        serie1.setLabel("Number of employees per Unit");
        for(Map.Entry<String,Integer> e : result.entrySet()){
            serie1.set(e.getKey(),e.getValue());
        }

        chart1.addSeries(serie1);

        chart1.setTitle("Plot 1 - Number of employees per Unit");
        chart1.setLegendPosition("ne");

        Axis xAxis = chart1.getAxis(AxisType.X);
        xAxis.setLabel("Unit");

        Axis yAxis = chart1.getAxis(AxisType.Y);
        yAxis.setLabel("Number");
        yAxis.setMin(0);
        //yAxis.setMax(10);

    }

    private void initChart2(){
        //number of staff members per category
        EntityManager em = getEntityManagerFactory().createEntityManager();
        List<EngagementEntity> engagements = em.createQuery("SELECT o FROM EngagementEntity AS o", EngagementEntity.class).getResultList();

        HashMap<String, Integer> result = new HashMap<>();
        for(EngagementEntity e : engagements){
            String key = e.getStaffCategoryByStaffCategoryId().getName();
            if(!result.containsKey(key)){
                result.put(key, 1);
            } else {
                result.put(key, result.get(key)+1);
            }
        }

        chart2 = new BarChartModel();

        ChartSeries serie1 = new ChartSeries();
        serie1.setLabel("Number of employees per Category");

        for(Map.Entry<String, Integer> e : result.entrySet()){
            serie1.set(e.getKey(), e.getValue());
        }

        chart2.addSeries(serie1);

        chart2.setTitle("Plot 2 - Number of employees per Category");
        chart2.setLegendPosition("ne");

        Axis xAxis = chart2.getAxis(AxisType.X);
        xAxis.setLabel("Staff Category");

        Axis yAxis = chart2.getAxis(AxisType.Y);
        yAxis.setLabel("Number");
        yAxis.setMin(0);
        //yAxis.setMax(10);
    }

    private void initChart3(){
        // average working hour per week per staff category
        EntityManager em = getEntityManagerFactory().createEntityManager();
        List<EngagementEntity> engagements = em.createQuery("SELECT o FROM EngagementEntity AS o", EngagementEntity.class).getResultList();

        HashMap<String, List<Integer>> result = new HashMap<>();
        for(EngagementEntity e : engagements){
            String key = e.getStaffCategoryByStaffCategoryId().getName();
            Integer val = e.getPersonalDataByPersonId().getJobDataById().getWorkingHoursPerWeek();
            if(!result.containsKey(key)){
                List<Integer> temp = new ArrayList<>();  //temp 0 is sum, temp 1 is average
                temp.add(val);
                temp.add(1);
                result.put(key, temp);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(val+result.get(key).get(0));
                temp.add(1+result.get(key).get(0));
                result.put(key,temp);
            }
        }

        chart3 = new BarChartModel();

        ChartSeries serie1 = new ChartSeries();
        serie1.setLabel("Average working hours per week per staff category");

        for(Map.Entry<String, List<Integer>> e : result.entrySet()){
            serie1.set(e.getKey(), e.getValue().get(0)/e.getValue().get(1));
        }

        chart3.addSeries(serie1);

        chart3.setTitle("Plot 3 - Average working hours per week per staff category");
        chart3.setLegendPosition("ne");

        Axis xAxis = chart3.getAxis(AxisType.X);
        xAxis.setLabel("Staff Category");

        Axis yAxis = chart3.getAxis(AxisType.Y);
        yAxis.setLabel("Average working hours per week");
        yAxis.setMin(0);
        //yAxis.setMax(10);
    }

    private void initChart4(){
        // total monthly wage per department
        EntityManager em = getEntityManagerFactory().createEntityManager();
        List<MembershipEntity> pdList = em.createQuery("select o from MembershipEntity AS o", MembershipEntity.class).getResultList();

        HashMap<String, Integer> result = new HashMap<>();
        for(MembershipEntity m: pdList){
            String key = m.getUnitsByUnitId().getName();
            //calculate proportion of working hours in department
            Integer salary = m.getPersonalDataByPersonId().getJobDataById().getMonthlySalary();
            Integer working = m.getWorkingHoursPerWeek();
            Integer working_total = m.getPersonalDataByPersonId().getJobDataById().getWorkingHoursPerWeek();
            Double prop = ((double)working)/working_total;
            Integer val = (int)(((double)salary)*prop);
            if(!result.containsKey(key)){
                result.put(key,val);
            } else {
                result.put(key,result.get(key)+val);
            }
        }

        chart4 = new PieChartModel();

        for(Map.Entry<String,Integer> e : result.entrySet()){
            chart4.set(e.getKey(),e.getValue());
        }


        chart4.setTitle("Plot 4 - Total monthly salary per Unit");
        chart4.setLegendPosition("ne");

    }


}
