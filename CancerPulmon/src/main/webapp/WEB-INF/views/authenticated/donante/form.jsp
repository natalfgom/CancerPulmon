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
    <acme:input-textbox code="authenticated.donante.form.label.nhusa" path="nhusa"/>    
    <acme:input-textbox code="authenticated.donante.form.label.nombre" path="nombre"/>
    <acme:input-textarea code="authenticated.donante.form.label.apellidos" path="apellidos"/>
    <acme:input-textbox code="authenticated.donante.form.label.grupoSanguineo" path="grupoSanguineo"/>
    <acme:input-textbox code="authenticated.donante.form.label.organoDisponible" path="organoDisponible"/>
    <acme:input-double code="authenticated.donante.form.label.volumenPulmonar" path="volumenPulmonar"/>
    <acme:input-moment code="authenticated.donante.form.label.fechaExtraccion" path="fechaExtraccion"/>

    <jstl:choose>
        <jstl:when test="${acme:anyOf(_command, 'show|update|delete')}">
            <acme:submit code="authenticated.donante.form.button.update" action="/authenticated/donante/update"/>
        </jstl:when>
        <jstl:when test="${_command == 'create'}">
            <acme:submit code="authenticated.donante.form.button.create" action="/employer/duty/create?masterId=${masterId}"/>
        </jstl:when>
    </jstl:choose>
</acme:form>


	
