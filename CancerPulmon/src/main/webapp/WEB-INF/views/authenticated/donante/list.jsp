<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="http://www.the-acme-framework.org/"%>

<acme:list>
	<acme:list-column code="authenticated.donante.list.label.nhusa" path="nhusa" width=""/>
    <acme:list-column code="authenticated.donante.list.label.nombre" path="nombre" width=""/>
    <acme:list-column code="authenticated.donante.list.label.apellidos" path="apellidos" width=""/>
</acme:list>