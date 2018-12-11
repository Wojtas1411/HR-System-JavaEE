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
        <title>Create TemporaryPersonalDataEntity</title>
    </head>
    <body>
        <f:view>
            <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            <h1>Create TemporaryPersonalDataEntity</h1>
            <h:form>
                <h:panelGrid columns="2">
                                                            <h:outputText value="id:"/>
                                                    <h:inputText value="#{temporaryPersonalDataEntity.entity.id}" title="id" />
                                                                                                        <h:outputText value="timestamp:"/>
                                                    <h:inputText value="#{temporaryPersonalDataEntity.entity.timestamp}" title="timestamp" />
                                                                                                        <h:outputText value="userId:"/>
                                                    <h:inputText value="#{temporaryPersonalDataEntity.entity.userId}" title="userId" />
                                                                                                        <h:outputText value="familyName:"/>
                                                    <h:inputText value="#{temporaryPersonalDataEntity.entity.familyName}" title="familyName" />
                                                                                                        <h:outputText value="firstName:"/>
                                                    <h:inputText value="#{temporaryPersonalDataEntity.entity.firstName}" title="firstName" />
                                                                                                        <h:outputText value="birthDate:"/>
                                                    <h:inputText value="#{temporaryPersonalDataEntity.entity.birthDate}" title="birthDate" />
                                                                                                        <h:outputText value="birthPlace:"/>
                                                    <h:inputText value="#{temporaryPersonalDataEntity.entity.birthPlace}" title="birthPlace" />
                                                                                                        <h:outputText value="photo:"/>
                                                    <h:inputText value="#{temporaryPersonalDataEntity.entity.photo}" title="photo" />
                                                                                                        <h:outputText value="adres:"/>
                                                    <h:inputText value="#{temporaryPersonalDataEntity.entity.adres}" title="adres" />
                                                                                                        <h:outputText value="emails:"/>
                                                    <h:inputText value="#{temporaryPersonalDataEntity.entity.emails}" title="emails" />
                                                                                                        <h:outputText value="phoneNumbers:"/>
                                                    <h:inputText value="#{temporaryPersonalDataEntity.entity.phoneNumbers}" title="phoneNumbers" />
                                                                            </h:panelGrid>

                <h:commandButton action="#{temporaryPersonalDataEntity.create}" value="Save" />
                <h:commandButton action="temporaryPersonalDataEntityList" value="Cancel"/>
                <br>
            </h:form>
        </f:view>
    </body>
</html>
