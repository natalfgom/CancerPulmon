<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="http://www.the-acme-framework.org/"%>

<acme:list>
	<acme:list-column code="authenticated.tratamiento.list.label.tipoTratamiento" path="tipoTratamiento" width="20%"/>
	<acme:list-column code="authenticated.tratamiento.list.label.estadoTratamiento" path="estadoTratamiento" width="10%"/>
</acme:list>