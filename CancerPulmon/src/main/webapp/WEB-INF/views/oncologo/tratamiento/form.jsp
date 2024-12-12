<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="http://www.the-acme-framework.org/"%>

<acme:form>

    <acme:input-textbox code="authenticated.tratamiento.form.label.estadoTratamiento" path="estadoTratamiento"/>  
	<acme:input-textbox code="authenticated.tratamiento.form.label.tipoTratamiento" path="tipoTratamiento" />
		<acme:input-textbox code="authenticated.tratamiento.list.label.paciente.orden" path="orden"/>    
    <acme:input-textbox code="authenticated.tratamiento.list.label.paciente.urgencia" path="urgencia"/>    
    <acme:input-textbox code="authenticated.tratamiento.form.label.paciente.nuhsa" path="nuhsa" readonly="true"/>
    <acme:input-textbox code="authenticated.tratamiento.form.label.paciente.name" path="name" readonly="true"/>
    <acme:input-textbox code="authenticated.tratamiento.form.label.paciente.surname" path="surname" readonly="true" />
    <acme:input-textbox code="authenticated.tratamiento.form.label.paciente.genero" path="genero" readonly="true" />
    <acme:input-textbox code="authenticated.tratamiento.form.label.paciente.fechaNacimiento" path="fechaNacimiento" readonly="true"/>
    <acme:input-textbox code="authenticated.tratamiento.form.label.paciente.grupoSanguineo" path="grupoSanguineo" readonly="true"/>

    <jstl:choose>
        <jstl:when test="${acme:anyOf(_command, 'show|update|delete')}">
            <acme:submit code="oncologo.tratamiento.form.button.update" action="/oncologo/tratamiento/update"/>
              <acme:submit code="oncologo.tratamiento.form.button.delete" action="/oncologo/tratamiento/delete"/>
        </jstl:when>
    <jstl:when test="${_command == 'create'}">
        <acme:submit code="creardonante" action="/oncologo/tratamiento/create?pacienteId=${pacienteId }"/>
    </jstl:when>
        
    </jstl:choose>
</acme:form>

 