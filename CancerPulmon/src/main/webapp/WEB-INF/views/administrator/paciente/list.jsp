<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="http://www.the-acme-framework.org/"%>

<acme:list>
	<acme:list-column code="administrator.paciente.list.label.nuhsa" path="nuhsa" width=""/>
    <acme:list-column code="administrator.paciente.list.label.name" path="name" width=""/>
    <acme:list-column code="administrator.paciente.list.label.surname" path="surname" width=""/>
</acme:list>

