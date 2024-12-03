
<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="http://www.the-acme-framework.org/"%>

<acme:form readonly = "true">
    <acme:input-textbox code="administrator.announcement.form.label.title" path="title"/>
    <acme:input-textbox code="administrator.announcement.form.label.status" path="status"/>
    <acme:input-textarea code="administrator.announcement.form.label.text" path="text"/>
    <acme:input-url code="administrator.announcement.form.label.moreInfo" path="moreInfo"/>
</acme:form>
