

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="http://www.the-acme-framework.org/"%>

<acme:form>
    <acme:input-textbox code="administrator.paciente.form.label.nuhsa" path="nuhsa"/>    
    <acme:input-textbox code="administrator.paciente.form.label.name" path="name"/>
    <acme:input-textarea code="administrator.paciente.form.label.surname" path="surname"/>
    <acme:input-textarea code="administrator.paciente.form.label.genero" path="genero"/>
    <acme:input-textbox code="administrator.paciente.form.label.grupoSanguineo" path="grupoSanguineo"/>
    <acme:input-moment code="administrator.paciente.form.label.fechaNacimiento" path="fechaNacimiento"/>

    <jstl:choose>
    <jstl:when test="${(_command == 'show' || _command == 'update' || _command == 'delete') && draftMode == false}">
        <acme:submit code="administrator.paciente.form.button.update" action="/administrator/paciente/update"/>
        <acme:submit code="administrator.paciente.form.button.delete" action="/administrator/paciente/delete"/>
    </jstl:when>
    
    <jstl:when test="${_command == 'create'}">
        <acme:submit code="administrator.paciente.form.button.create" action="/administrator/paciente/create"/>
    </jstl:when>
</jstl:choose>

    
    
</acme:form>


	
