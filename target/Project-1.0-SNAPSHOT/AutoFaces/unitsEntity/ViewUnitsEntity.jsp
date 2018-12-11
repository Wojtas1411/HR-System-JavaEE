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
        <title>UnitsEntity View</title>
    </head>
    <body>
        <f:view>
            <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            <h1>UnitsEntity View</h1>
            <h:form>
                <h:panelGrid columns="2">
                                                           <h:outputText value="id:"/>
                                                   <h:outputText value="#{unitsEntity.entity.id}" title="id" />
                                                                                                       <h:outputText value="name:"/>
                                                   <h:outputText value="#{unitsEntity.entity.name}" title="name" />
                                                                                                       <h:outputText value="type:"/>
                                                   <h:outputText value="#{unitsEntity.entity.type}" title="type" />
                                                                                
                                                                               <h:outputText value="unitsByParentId:"/>
                                                   <h:selectOneMenu value="#{unitsEntity.entity.unitsByParentId}"  title="unitsByParentId">
                                <f:selectItems  value="#{unitsEntity.allEntitiesAsSelectedItems}"/>
                            </h:selectOneMenu>
                                                                                
                                                                               <h:outputText value="personalDataByBossId:"/>
                                                   <h:selectOneMenu value="#{unitsEntity.entity.personalDataByBossId}"  title="personalDataByBossId">
                                <f:selectItems  value="#{personalDataEntity.allEntitiesAsSelectedItems}"/>
                            </h:selectOneMenu>
                                                                            </h:panelGrid>

                <h:commandButton action="editUnitsEntity" value="Edit" />
                <br>
                <h:commandButton action="unitsEntityList" value="Show All"/>
                <br>
            </h:form>
        </f:view>
    </body>
</html>
