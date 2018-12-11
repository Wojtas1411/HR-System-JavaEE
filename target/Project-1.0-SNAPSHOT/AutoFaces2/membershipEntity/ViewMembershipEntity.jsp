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
        <title>MembershipEntity View</title>
    </head>
    <body>
        <f:view>
            <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            <h1>MembershipEntity View</h1>
            <h:form>
                <h:panelGrid columns="2">
                                                           <h:outputText value="id:"/>
                                                   <h:outputText value="#{membershipEntity.entity.id}" title="id" />
                                                                                                       <h:outputText value="workingHoursPerWeek:"/>
                                                   <h:outputText value="#{membershipEntity.entity.workingHoursPerWeek}" title="workingHoursPerWeek" />
                                                                                                       <h:outputText value="personalDataByPersonId:"/>
                                                   <h:selectOneMenu value="#{membershipEntity.entity.personalDataByPersonId}"  title="personalDataByPersonId">
                                <f:selectItems  value="#{personalDataEntity.allEntitiesAsSelectedItems}"/>
                            </h:selectOneMenu>
                                                                                                       <h:outputText value="unitsByUnitId:"/>
                                                   <h:selectOneMenu value="#{membershipEntity.entity.unitsByUnitId}"  title="unitsByUnitId">
                                <f:selectItems  value="#{unitsEntity.allEntitiesAsSelectedItems}"/>
                            </h:selectOneMenu>
                                                                            </h:panelGrid>

                <h:commandButton action="editMembershipEntity" value="Edit" />
                <br>
                <h:commandButton action="membershipEntityList" value="Show All"/>
                <br>
            </h:form>
        </f:view>
    </body>
</html>
