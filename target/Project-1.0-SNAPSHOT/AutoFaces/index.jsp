<!--
  Created by IntelliJ IDEA.
  User: wojtek
  Date: 09.12.18
  Time: 14:28
-->
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html xmlns="http://www.w3.org/1999/xhtml"
xmlns:f="http://java.sun.com/jsf/core"
xmlns:h="http://java.sun.com/jsf/html">
<head>
    <!--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> -->
    <meta content="text/html; charset=UTF-8" />
    <title>Generated Entities</title>
</head>
<body>

<h1>Generated Entities</h1>
<br/>
<f:view>
    <h:form>
                <h:commandLink action="adresEntityList" value="AdresEntity"/>
        <br/>
                <h:commandLink action="emailsEntityList" value="EmailsEntity"/>
        <br/>
                <h:commandLink action="engagementEntityList" value="EngagementEntity"/>
        <br/>
                <h:commandLink action="membershipEntityList" value="MembershipEntity"/>
        <br/>
                <h:commandLink action="phoneNumbersEntityList" value="PhoneNumbersEntity"/>
        <br/>
                <h:commandLink action="personalDataEntityList" value="PersonalDataEntity"/>
        <br/>
                <h:commandLink action="temporaryPersonalDataEntityList" value="TemporaryPersonalDataEntity"/>
        <br/>
                <h:commandLink action="jobDataEntityList" value="JobDataEntity"/>
        <br/>
                <h:commandLink action="staffCategoryEntityList" value="StaffCategoryEntity"/>
        <br/>
                <h:commandLink action="unitsEntityList" value="UnitsEntity"/>
        <br/>
                <h:commandLink action="userEntityList" value="UserEntity"/>
        <br/>
            </h:form>
</f:view>

</body>
</html>
