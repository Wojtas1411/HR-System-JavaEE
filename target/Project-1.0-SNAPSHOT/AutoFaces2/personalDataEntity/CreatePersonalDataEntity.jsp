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
        <title>Create PersonalDataEntity</title>
    </head>
    <body>
        <f:view>
            <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            <h1>Create PersonalDataEntity</h1>
            <h:form>
                <h:panelGrid columns="2">
                                                            <h:outputText value="id:"/>
                                                    <h:inputText value="#{personalDataEntity.entity.id}" title="id" />
                                                                                                        <h:outputText value="familyName:"/>
                                                    <h:inputText value="#{personalDataEntity.entity.familyName}" title="familyName" />
                                                                                                        <h:outputText value="firstName:"/>
                                                    <h:inputText value="#{personalDataEntity.entity.firstName}" title="firstName" />
                                                                                                        <h:outputText value="birthDate:"/>
                                                    <h:inputText value="#{personalDataEntity.entity.birthDate}" title="birthDate" />
                                                                                                        <h:outputText value="birthPlace:"/>
                                                    <h:inputText value="#{personalDataEntity.entity.birthPlace}" title="birthPlace" />
                                                                                                        <h:outputText value="photo:"/>
                                                    <h:inputText value="#{personalDataEntity.entity.photo}" title="photo" />
                                                                                                                                                                                                                                                                                            <h:outputText value="userByUserIdId:"/>
                                                    <h:selectOneMenu value="#{personalDataEntity.entity.userByUserIdId}"  title="userByUserIdId">
                                <f:selectItems  value="#{userEntity.allEntitiesAsSelectedItems}"/>
                            </h:selectOneMenu>
                                                                                                                                                    </h:panelGrid>

                <h:commandButton action="#{personalDataEntity.create}" value="Save" />
                <h:commandButton action="personalDataEntityList" value="Cancel"/>
                <br>
            </h:form>
        </f:view>
    </body>
</html>
