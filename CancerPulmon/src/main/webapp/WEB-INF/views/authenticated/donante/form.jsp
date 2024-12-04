<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="http://www.the-acme-framework.org/"%>

<acme:form readonly = "true">
	<acme:input-textbox code="authenticated.donante.form.label.nhusa" path="nhusa"/>	
	<acme:input-textbox code="authenticated.donante.form.label.nombre" path="nombre"/>
	<acme:input-textarea code="authenticated.donante.form.label.apellidos" path="apellidos"/>
</acme:form>
