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
        <title>UnitsEntity List</title>
    </head>
    <body>
        <f:view>
            <h1>UnitsEntity List</h1>
            <h:form>
              <h:commandButton action="#{unitsEntity.startCreate}" value="Create"/>

              <h:dataTable value='#{unitsEntity.allEntities}' var='item' border="1" cellpadding="2" cellspacing="0">
                                                       <h:column>
                      <f:facet name="header">
                      <h:outputText value="id"/>
                      </f:facet>
                      <h:outputText value="#{item.id}"/>
                  </h:column>
                                                                        <h:column>
                      <f:facet name="header">
                      <h:outputText value="name"/>
                      </f:facet>
                      <h:outputText value="#{item.name}"/>
                  </h:column>
                                                                        <h:column>
                      <f:facet name="header">
                      <h:outputText value="type"/>
                      </f:facet>
                      <h:outputText value="#{item.type}"/>
                  </h:column>
                                                                                                          <h:column>
                      <f:facet name="header">
                      <h:outputText value="unitsByParentId"/>
                      </f:facet>
                      <h:outputText value="#{item.unitsByParentId}"/>
                  </h:column>
                                                                                                          <h:column>
                      <f:facet name="header">
                      <h:outputText value="personalDataByBossId"/>
                      </f:facet>
                      <h:outputText value="#{item.personalDataByBossId}"/>
                  </h:column>
                                                   <h:column>
                      <h:commandButton value="View" action="#{unitsEntity.startView}">
                          <f:param name="id" value="#{item.id}"/>
                      </h:commandButton>&nbsp;
                      <h:commandButton value="Edit" action="#{unitsEntity.startEdit}">
                          <f:param name="id" value="#{item.id}"/>
                      </h:commandButton>&nbsp;
                      <h:commandButton value="Delete" action="#{unitsEntity.delete}">
                          <f:param name="id" value="#{item.id}"/>
                      </h:commandButton>
                  </h:column>
              </h:dataTable>
            </h:form>
        </f:view>
    </body>
</html>
