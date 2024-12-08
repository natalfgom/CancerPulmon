<%-- <%@page language="java"%> --%>

<%-- <%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%-- <%@taglib prefix="acme" uri="http://www.the-acme-framework.org/"%> --%>

<%-- <acme:form readonly = "true"> --%>
<%-- 	<acme:input-textbox code="authenticated.donante.form.label.nhusa" path="nhusa"/>	 --%>
<%-- 	<acme:input-textbox code="authenticated.donante.form.label.nombre" path="nombre"/> --%>
<%-- 	<acme:input-textarea code="authenticated.donante.form.label.apellidos" path="apellidos"/> --%>
<%-- 	<acme:input-textarea code="authenticated.donante.form.label.grupoSanguineo" path="grupoSanguineo"/> --%>
<%-- 	<acme:input-textarea code="authenticated.donante.form.label.organoDisponible" path="organoDisponible"/> --%>
<%-- 	<acme:input-textarea code="authenticated.donante.form.label.volumenPulmonar" path="volumenPulmonar"/> --%>
<%-- 	<acme:input-textarea code="authenticated.donante.form.label.fechaExtraccion" path="fechaExtraccion"/> --%>
		
	
	
<%-- </acme:form> --%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="http://www.the-acme-framework.org/"%>

<acme:form>
    <acme:input-textbox code="administrator.donante.form.label.nhusa" path="nhusa"/>    
    <acme:input-textbox code="administrator.donante.form.label.nombre" path="nombre"/>
    <acme:input-textarea code="administrator.donante.form.label.apellidos" path="apellidos"/>
    <acme:input-textbox code="administrator.donante.form.label.grupoSanguineo" path="grupoSanguineo"/>
    <acme:input-textbox code="administrator.donante.form.label.organoDisponible" path="organoDisponible"/>
    <acme:input-double code="administrator.donante.form.label.volumenPulmonar" path="volumenPulmonar"/>
    <acme:input-moment code="administrator.donante.form.label.fechaExtraccion" path="fechaExtraccion"/>

    <jstl:choose>
    <jstl:when test="${acme:anyOf(_command, 'show|update|delete')}">
        <acme:submit code="administrator.donante.form.button.update" action="/administrator/donante/update"/>
        <acme:submit code="administrator.donante.form.button.delete" action="/administrator/donante/delete"/>
    </jstl:when>
    <jstl:when test="${_command == 'create'}">
        <acme:submit code="administrator.donante.form.button.create" action="/administrator/donante/create"/>
    </jstl:when>
</jstl:choose>

	
</acme:form>


	
