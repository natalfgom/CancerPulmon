<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="http://www.the-acme-framework.org/"%>

<acme:form >
	<acme:input-textbox code="authenticated.donante.form.label.nhusa" path="nhusa"/>	
	<acme:input-textbox code="authenticated.donante.form.label.nombre" path="nombre"/>
	<acme:input-textarea code="authenticated.donante.form.label.apellidos" path="apellidos"/>
	<acme:input-select code="authenticated.donante.form.label.grupoSanguineo" path="grupoSanguineo" choices = "${grupoSanguineo }"/>
	<acme:input-select code="authenticated.donante.form.label.organoDisponible" path="organoDisponible" choices = "${OrganoDisponible }"/>
	<acme:input-double code="authenticated.donante.form.label.volumenPulmonar" path="volumenPulmonar"/>
	<acme:input-moment code="authenticated.donante.form.label.fechaExtraccion" path="fechaExtraccion"/>
		
<%-- 	<jstl:choose> --%>
		<jstl:when test="${acme:anyOf(_command, 'show|update|delete's}">
			<acme:submit code="admin.donante.form.button.update" action="/admin/donante/update"/>
<%-- 			<acme:submit code="admin.donante.form.button.delete" action="/admin/donante/delete"/> --%>
		</jstl:when>
<%-- 		<jstl:when test="${_command == 'create'}"> --%>
<%-- 			<acme:submit code="admin.donante.form.button.create" action="/employer/duty/create?masterId=${masterId}"/> --%>
<%-- 		</jstl:when>		 --%>
<%-- 	</jstl:choose>		 --%>
	
</acme:form>
