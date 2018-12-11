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
        <title>Create EmailsEntity</title>
    </head>
    <body>
        <f:view>
            <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            <h1>Create EmailsEntity</h1>
            <h:form>
                <h:panelGrid columns="2">
                                                            <h:outputText value="id:"/>
                                                    <h:inputText value="#{emailsEntity.entity.id}" title="id" />
                                                                                                        <h:outputText value="prim:"/>
                                                    <h:inputText value="#{emailsEntity.entity.prim}" title="prim" />
                                                                                                        <h:outputText value="value:"/>
                                                    <h:inputText value="#{emailsEntity.entity.value}" title="value" />
                                                                                                        <h:outputText value="personalDataByUserId:"/>
                                                    <h:selectOneMenu value="#{emailsEntity.entity.personalDataByUserId}"  title="personalDataByUserId">
                                <f:selectItems  value="#{personalDataEntity.allEntitiesAsSelectedItems}"/>
                            </h:selectOneMenu>
                                                                            </h:panelGrid>

                <h:commandButton action="#{emailsEntity.create}" value="Save" />
                <h:commandButton action="emailsEntityList" value="Cancel"/>
                <br>
            </h:form>
        </f:view>
    </body>
</html>
