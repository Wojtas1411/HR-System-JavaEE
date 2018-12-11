<!--
  Created by IntelliJ IDEA.
  User: wojtek
  Date: 11.12.18
  Time: 09:46
  To change this template use File | Settings | File Templates.
-->
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Edit JobDataEntity</title>
    </head>
    <body>
        <f:view>
            <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            <h1>Edit JobDataEntity</h1>
            <h:form>
                <h:panelGrid columns="2">
                                    <h:outputText value="id:"/>
                                                                        <h:inputText value="#{jobDataEntity.entity.id}" title="id" />
                                                                                <h:outputText value="startContract:"/>
                                                                        <h:inputText value="#{jobDataEntity.entity.startContract}" title="startContract" />
                                                                                <h:outputText value="endContract:"/>
                                                                        <h:inputText value="#{jobDataEntity.entity.endContract}" title="endContract" />
                                                                                <h:outputText value="monthlySalary:"/>
                                                                        <h:inputText value="#{jobDataEntity.entity.monthlySalary}" title="monthlySalary" />
                                                                                <h:outputText value="workingHoursPerWeek:"/>
                                                                        <h:inputText value="#{jobDataEntity.entity.workingHoursPerWeek}" title="workingHoursPerWeek" />
                                                                                <h:outputText value="bankInfo:"/>
                                                                        <h:inputText value="#{jobDataEntity.entity.bankInfo}" title="bankInfo" />
                                                                                <h:outputText value="bankAccountNumber:"/>
                                                                        <h:inputText value="#{jobDataEntity.entity.bankAccountNumber}" title="bankAccountNumber" />
                                                                                <h:outputText value="personalDataByUserId:"/>
                                                                        <h:selectOneMenu value="#{jobDataEntity.entity.personalDataByUserId}"  title="personalDataByUserId">
                                <f:selectItems  value="#{personalDataEntity.allEntitiesAsSelectedItems}"/>
                            </h:selectOneMenu>
                                                                            </h:panelGrid>

                <h:commandButton action="#{jobDataEntity.save}" value="Save"/>
                <h:commandButton action="jobDataEntityList" value="Cancel"/>
                <br>
            </h:form>
        </f:view>
    </body>
</html>
