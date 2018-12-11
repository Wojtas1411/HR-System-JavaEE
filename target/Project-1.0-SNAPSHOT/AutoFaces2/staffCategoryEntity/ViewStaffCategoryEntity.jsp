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
        <title>StaffCategoryEntity View</title>
    </head>
    <body>
        <f:view>
            <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            <h1>StaffCategoryEntity View</h1>
            <h:form>
                <h:panelGrid columns="2">
                                                           <h:outputText value="id:"/>
                                                   <h:outputText value="#{staffCategoryEntity.entity.id}" title="id" />
                                                                                                       <h:outputText value="name:"/>
                                                   <h:outputText value="#{staffCategoryEntity.entity.name}" title="name" />
                                                                                
                                                    </h:panelGrid>

                <h:commandButton action="editStaffCategoryEntity" value="Edit" />
                <br>
                <h:commandButton action="staffCategoryEntityList" value="Show All"/>
                <br>
            </h:form>
        </f:view>
    </body>
</html>
