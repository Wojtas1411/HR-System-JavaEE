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
        <title>Create StaffCategoryEntity</title>
    </head>
    <body>
        <f:view>
            <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            <h1>Create StaffCategoryEntity</h1>
            <h:form>
                <h:panelGrid columns="2">
                                                            <h:outputText value="id:"/>
                                                    <h:inputText value="#{staffCategoryEntity.entity.id}" title="id" />
                                                                                                        <h:outputText value="name:"/>
                                                    <h:inputText value="#{staffCategoryEntity.entity.name}" title="name" />
                                                                                                                </h:panelGrid>

                <h:commandButton action="#{staffCategoryEntity.create}" value="Save" />
                <h:commandButton action="staffCategoryEntityList" value="Cancel"/>
                <br>
            </h:form>
        </f:view>
    </body>
</html>
