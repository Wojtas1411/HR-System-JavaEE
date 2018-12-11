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
        <title>Create UserEntity</title>
    </head>
    <body>
        <f:view>
            <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            <h1>Create UserEntity</h1>
            <h:form>
                <h:panelGrid columns="2">
                                                            <h:outputText value="id:"/>
                                                    <h:inputText value="#{userEntity.entity.id}" title="id" />
                                                                                                        <h:outputText value="username:"/>
                                                    <h:inputText value="#{userEntity.entity.username}" title="username" />
                                                                                                        <h:outputText value="roles:"/>
                                                    <h:inputText value="#{userEntity.entity.roles}" title="roles" />
                                                                                                        <h:outputText value="password:"/>
                                                    <h:inputText value="#{userEntity.entity.password}" title="password" />
                                                                                                        <h:outputText value="personalDataById:"/>
                                                    <h:selectOneMenu value="#{userEntity.entity.personalDataById}"  title="personalDataById">
                                <f:selectItems  value="#{personalDataEntity.allEntitiesAsSelectedItems}"/>
                            </h:selectOneMenu>
                                                                            </h:panelGrid>

                <h:commandButton action="#{userEntity.create}" value="Save" />
                <h:commandButton action="userEntityList" value="Cancel"/>
                <br>
            </h:form>
        </f:view>
    </body>
</html>
