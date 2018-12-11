<!--
  Created by IntelliJ IDEA.
  User: wojtek
  Date: 09.12.18
  Time: 14:28
  To change this template use File | Settings | File Templates.
-->
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>JobDataEntity View</title>
    </head>
    <body>
        <f:view>
            <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            <h1>JobDataEntity View</h1>
            <h:form>
                <h:panelGrid columns="2">
                                                           <h:outputText value="id:"/>
                                                   <h:outputText value="#{jobDataEntity.entity.id}" title="id" />
                                                                                                       <h:outputText value="startContract:"/>
                                                   <h:outputText value="#{jobDataEntity.entity.startContract}" title="startContract" />
                                                                                                       <h:outputText value="endContract:"/>
                                                   <h:outputText value="#{jobDataEntity.entity.endContract}" title="endContract" />
                                                                                                       <h:outputText value="monthlySalary:"/>
                                                   <h:outputText value="#{jobDataEntity.entity.monthlySalary}" title="monthlySalary" />
                                                                                                       <h:outputText value="workingHoursPerWeek:"/>
                                                   <h:outputText value="#{jobDataEntity.entity.workingHoursPerWeek}" title="workingHoursPerWeek" />
                                                                                                       <h:outputText value="bankInfo:"/>
                                                   <h:outputText value="#{jobDataEntity.entity.bankInfo}" title="bankInfo" />
                                                                                                       <h:outputText value="bankAccountNumber:"/>
                                                   <h:outputText value="#{jobDataEntity.entity.bankAccountNumber}" title="bankAccountNumber" />
                                                                                                       <h:outputText value="personalDataByUserId:"/>
                                                   <h:selectOneMenu value="#{jobDataEntity.entity.personalDataByUserId}"  title="personalDataByUserId">
                                <f:selectItems  value="#{personalDataEntity.allEntitiesAsSelectedItems}"/>
                            </h:selectOneMenu>
                                                                            </h:panelGrid>

                <h:commandButton action="editJobDataEntity" value="Edit" />
                <br>
                <h:commandButton action="jobDataEntityList" value="Show All"/>
                <br>
            </h:form>
        </f:view>
    </body>
</html>
